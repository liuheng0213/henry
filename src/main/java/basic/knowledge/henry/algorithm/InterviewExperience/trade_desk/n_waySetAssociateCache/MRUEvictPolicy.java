package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache;

import java.util.LinkedList;

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
