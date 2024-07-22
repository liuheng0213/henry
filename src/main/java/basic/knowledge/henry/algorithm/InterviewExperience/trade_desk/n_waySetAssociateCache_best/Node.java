package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache_best;

public class Node<K,V> {
    private K key;
    private V data;
    private int freq;

    Node pre;

    Node next;

    public Node(K key, V data) {
        this.key = key;
        this.data = data;
        this.freq = 0;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }
}
