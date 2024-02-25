package basic.knowledge.henry.algorithm.n_waySetAssociateCache;

import java.util.LinkedList;
import java.util.List;

public class LRUEvictPolicy<K, V> implements EvictPolicy<K, V> {
    CacheElement<K, V> evictCand;

    @Override
    public void onPut(LinkedList<CacheElement<K, V>> list, CacheElement<K, V> cacheElement) {
        onGet(list, cacheElement);
    }

    @Override
    public void onGet(LinkedList<CacheElement<K, V>> list, CacheElement<K, V> cacheElement) {
        list.remove(cacheElement);
        list.addLast(cacheElement);
        evictCand = list.peekFirst();
    }

    @Override
    public CacheElement<K, V> evict() {
        return evictCand;
    }
}
