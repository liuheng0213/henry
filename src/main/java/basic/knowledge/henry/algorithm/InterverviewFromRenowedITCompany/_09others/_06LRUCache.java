package basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._09others;

import java.util.LinkedHashMap;
import java.util.Map;


public class _06LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int CACHE_SIZE;
    public static void main(String[] args) {
        _06LRUCache<String, Integer> myCache = new _06LRUCache<>(5);
        myCache.put("a",1);
        myCache.put("b",2);
        myCache.put("c",3);
        myCache.put("d",4);
        myCache.put("e",5);
        myCache.put("j",5);
        myCache.put("a",6);
        System.out.println();
    }



    public _06LRUCache(int cache_size) {
        super(cache_size, (float) 0.75,true);
        this.CACHE_SIZE = cache_size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > CACHE_SIZE;
    }


}
