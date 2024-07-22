package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache_best;


public interface EvictPolicy<K, V> {
    void onPut(DoublyLinkList<K, V> list, Node<K, V> node);

    void onGet(DoublyLinkList<K, V> list, Node<K, V> node);

    Node<K, V> evict();
}
