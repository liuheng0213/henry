package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache;

public interface Cache<K, V> {
    V get(final K key);

    void put(final K key, final V value);
}
