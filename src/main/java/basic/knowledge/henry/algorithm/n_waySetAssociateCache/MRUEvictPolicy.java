package basic.knowledge.henry.algorithm.n_waySetAssociateCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MRUEvictPolicy<K, V> implements EvictPolicy<K, V> {

    CacheElement<K, V> evictCand;


    @Override
    public void onPut(LinkedList<CacheElement<K, V>> list, CacheElement<K, V> cacheElement) {
        onGet(list, cacheElement);
    }

    @Override
    public void onGet(LinkedList<CacheElement<K, V>> list, CacheElement<K, V> cacheElement) {
        list.remove(cacheElement);
        list.addFirst(cacheElement);
        evictCand = list.peekFirst();
    }

    @Override
    public CacheElement evict() {
        return evictCand;
    }
}
