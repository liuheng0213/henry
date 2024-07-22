package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache;

import java.util.LinkedList;

public class LFUEvictPolicy<K, V> implements EvictPolicy<K, V> {
    CacheElement<K, V> evictCand;

    @Override
    public void onPut(LinkedList<CacheElement<K, V>> list, CacheElement<K, V> cacheElement) {
        onGet(list, cacheElement);
    }

    @Override
    public void onGet(LinkedList<CacheElement<K, V>> list, CacheElement<K, V> cacheElement) {
        list.remove(cacheElement);
        cacheElement.setFreq(cacheElement.getFreq() + 1);
        list.addLast(cacheElement);


        int min = Integer.MAX_VALUE;
        for (CacheElement<K, V> element : list) {
            if (element.getFreq() < min) {
                evictCand = element;
                min = element.getFreq();
            }
        }
    }

    @Override
    public CacheElement<K, V> evict() {
        return evictCand;
    }
}
