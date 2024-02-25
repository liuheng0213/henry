package basic.knowledge.henry.algorithm.n_waySetAssociateCache_best;

public class LRUEvictPolicy<K,V> implements EvictPolicy<K,V> {
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
        list.add2Tail(node);
        evictCan = list.getHead();
    }

    @Override
    public Node<K, V> evict() {
        return evictCan;
    }
}
