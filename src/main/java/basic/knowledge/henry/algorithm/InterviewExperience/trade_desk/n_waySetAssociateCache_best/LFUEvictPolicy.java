package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache_best;


public class LFUEvictPolicy<K, V> implements EvictPolicy<K, V> {
    Node<K, V> evictCan;
    @Override
    public void onPut(DoublyLinkList<K, V> list, Node<K, V> node) {
        onGet(list, node);
    }

    @Override
    public void onGet(DoublyLinkList<K, V> list, Node<K, V> node) {
        if(node.pre != null && node.next != null){
            list.remove(node);
        }
        node.setFreq(node.getFreq() + 1);
        list.add2Tail(node);

        int min = Integer.MAX_VALUE;
        Node<K,V> cur = list.head.next;
        while(cur != list.tail){
            if (cur.getFreq() < min) {
                evictCan = cur;
                min = cur.getFreq();
            }
            cur = cur.next;
        }
    }

    @Override
    public Node<K, V> evict() {
        return evictCan;
    }
}
