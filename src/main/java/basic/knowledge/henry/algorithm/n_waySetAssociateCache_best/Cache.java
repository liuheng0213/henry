package basic.knowledge.henry.algorithm.n_waySetAssociateCache_best;

public interface Cache<K,V> {
    V get(final K key);

    void put(final K key, final V value);
}
