package basic.knowledge.henry.algorithm.n_waySetAssociateCache;

import java.util.LinkedList;
import java.util.List;

public interface EvictPolicy<K,V> {
    void onPut(LinkedList<CacheElement<K, V>> list,CacheElement<K, V> cacheElement);
    void onGet(LinkedList<CacheElement<K, V>> list,CacheElement<K,V> cacheElement);
    CacheElement<K,V> evict();
}
