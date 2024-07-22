package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache;

public class CacheElement<K, V> {
    private K key;
    private V data;

     CacheElement<K,V> pre;
     CacheElement<K,V> next;

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    private int freq;


    public CacheElement(K key, V data) {
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

    public void setKeyData(K key, V data) {
        this.key = key;
        this.data = data;
    }

}
