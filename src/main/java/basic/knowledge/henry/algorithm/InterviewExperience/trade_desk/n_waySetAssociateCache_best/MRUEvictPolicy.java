package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache_best;

public class MRUEvictPolicy<K,V> implements EvictPolicy<K,V> {
    Node<K, V> evictCan;
    @Override
    public void onPut(DoublyLinkList<K, V> list, Node<K, V> node) {
        onGet(list,node);
    }

    @Override
    public void onGet(DoublyLinkList<K, V> list, Node<K, V> node) {
        if(node.pre != null && node.next != null){
            list.remove(node);
        }
        list.add2Head(node);
        evictCan = node;
    }

    @Override
    public Node<K, V> evict() {
        return evictCan;
    }
}
