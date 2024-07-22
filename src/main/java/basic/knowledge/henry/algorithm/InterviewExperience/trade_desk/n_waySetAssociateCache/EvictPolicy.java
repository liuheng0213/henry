package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache;

import java.util.LinkedList;

public interface EvictPolicy<K,V> {
    void onPut(LinkedList<CacheElement<K, V>> list,CacheElement<K, V> cacheElement);
    void onGet(LinkedList<CacheElement<K, V>> list,CacheElement<K,V> cacheElement);
    CacheElement<K,V> evict();
}
