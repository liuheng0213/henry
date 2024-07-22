package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache_best;

public class DoublyLinkList<K,V> {
    Node<K,V> head;
    Node<K,V> tail;

    int size;


    public DoublyLinkList() {
        this.head = new Node<>(null,null);
        this.tail = new Node<>(null,null);
        head.next = tail;
        tail.pre = head;
        this.size = 0;
    }

    public int size(){
        return size;
    }
    public void add2Tail(Node<K,V> cache){
        cache.next = tail;
        cache.pre = tail.pre;
        tail.pre.next = cache;
        tail.pre = cache;
        this.size++;
    }

    public void add2Head(Node<K,V> cache){
        cache.pre = head;
        cache.next = head.next;
        head.next.pre = cache;
        head.next = cache;

        this.size++;
    }
    public void remove(Node<K,V> cache){
        cache.pre.next = cache.next;
        cache.next.pre = cache.pre;
        cache.pre = null;
        cache.next = null;
        this.size--;
    }

    public Node<K,V> getHead() {
        return head.next;
    }

    public Node<K,V> getTail(){
        return tail.pre;
    }
}
