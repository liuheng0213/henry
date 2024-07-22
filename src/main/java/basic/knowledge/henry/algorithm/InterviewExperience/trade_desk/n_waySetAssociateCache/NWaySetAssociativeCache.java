package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class NWaySetAssociativeCache<K, V> implements Cache<K, V> {
    //fields
    int listSize;

    int waySize;

    LinkedList<CacheElement<K, V>>[] cacheElementList;

    HashMap<K, CacheElement<K, V>>[] keyNodeMapList;

    private EvictPolicy<K, V> evictPolicy;

    public NWaySetAssociativeCache(int listSize, int waySize, EvictPolicy<K, V> evictPolicy) {
        this.listSize = listSize;
        this.waySize = waySize;
        this.evictPolicy = evictPolicy;
        cacheElementList = new LinkedList[waySize];
        //todo  可优化by commenting out
        for (List<CacheElement<K, V>> list : cacheElementList) {
            list = new LinkedList<>();
        }

        this.keyNodeMapList = new HashMap[waySize];
//        for(int i =0;i< cacheElementListSize;i++){
//            keyNodeMapList[i] = new HashMap<>();
//        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<CacheElement<K, V>> list = this.getList(index);
        HashMap<K, CacheElement<K, V>> keyNodeMap = this.getKeyNodeMap(index);
        V value = null;

        if(keyNodeMap.containsKey(key)){
            CacheElement<K, V> toBeUpdated = keyNodeMap.get(key);
            this.evictPolicy.onGet(list,toBeUpdated);
            value = toBeUpdated.getData();
        }

        return value;
    }



    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<CacheElement<K, V>> list = this.getList(index);
        HashMap<K, CacheElement<K, V>> keyNodeMap = this.getKeyNodeMap(index);

        if(keyNodeMap.containsKey(key)){
            this.evictPolicy.onPut(list, keyNodeMap.get(key));
            return;
        }

        if (this.listSize == list.size()) {
            CacheElement<K, V> evicted = this.evictPolicy.evict();
            list.remove(evicted);
            keyNodeMap.remove(evicted.getKey());
        }

        CacheElement<K, V> c = new CacheElement<>(key, value);
        this.evictPolicy.onPut(list, c);
        keyNodeMap.put(key,c);
    }

    private LinkedList<CacheElement<K, V>> getList(int index) {
        if (this.cacheElementList[index] == null) {
            this.cacheElementList[index] = new LinkedList<>();
        }
        return this.cacheElementList[index];
    }

    private HashMap<K, CacheElement<K,V>> getKeyNodeMap(int index) {
        if (this.keyNodeMapList[index] == null) {
            this.keyNodeMapList[index] = new HashMap<>();
        }
        return this.keyNodeMapList[index];
    }

    private int getIndex(K key) {
        int hashKey = Math.floorMod(key.hashCode(), this.waySize);
        return hashKey;
    }
}
