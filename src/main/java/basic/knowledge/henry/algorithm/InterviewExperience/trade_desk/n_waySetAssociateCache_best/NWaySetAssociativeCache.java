package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache_best;


import java.util.HashMap;

public class NWaySetAssociativeCache<K, V> implements Cache<K, V> {
    //fields
    int listSize;

    int waySize;

    DoublyLinkList<K,V>[] nodeList;

    HashMap<K, Node<K, V>>[] keyNodeMapList;

    private EvictPolicy<K, V> evictPolicy;

    public NWaySetAssociativeCache(int listSize, int waySize, EvictPolicy<K, V> evictPolicy) {
        this.listSize = listSize;
        this.waySize = waySize;
        this.evictPolicy = evictPolicy;
        nodeList = new DoublyLinkList[waySize];
        //todo  可优化by commenting out

        this.keyNodeMapList = new HashMap[waySize];
//        for(int i =0;i< cacheElementListSize;i++){
//            keyNodeMapList[i] = new HashMap<>();
//        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        DoublyLinkList<K,V> list = this.getList(index);
        HashMap<K, Node<K, V>> keyNodeMap = this.getKeyNodeMap(index);
        V value = null;

        if(keyNodeMap.containsKey(key)){
            Node<K, V> toBeUpdated = keyNodeMap.get(key);
            this.evictPolicy.onGet(list,toBeUpdated);
            value = toBeUpdated.getData();
        }

        return value;
    }



    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        DoublyLinkList<K, V> doublyLinkList = this.getList(index);
        HashMap<K, Node<K, V>> keyNodeMap = this.getKeyNodeMap(index);

        if(keyNodeMap.containsKey(key)){
            this.evictPolicy.onPut(doublyLinkList, keyNodeMap.get(key));
            return;
        }

        if (this.listSize == doublyLinkList.size()) {
            Node<K, V> evicted = this.evictPolicy.evict();
            doublyLinkList.remove(evicted);
            keyNodeMap.remove(evicted.getKey());
        }

        Node<K, V> c = new Node<>(key, value);
        this.evictPolicy.onPut(doublyLinkList, c);
        keyNodeMap.put(key,c);
    }

    private DoublyLinkList<K,V> getList(int index) {
        if (this.nodeList[index] == null) {
            this.nodeList[index] = new DoublyLinkList<>();
        }
        return this.nodeList[index];
    }

    private HashMap<K, Node<K,V>> getKeyNodeMap(int index) {
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
