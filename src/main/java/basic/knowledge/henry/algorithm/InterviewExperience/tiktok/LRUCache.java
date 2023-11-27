package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

import java.util.LinkedHashMap;

public class LRUCache {
    int c;
    LinkedHashMap<Integer,Integer> map =null;
    public LRUCache(int capacity) {
        this.c = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            makeRecent(key);
            return map.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
        }else{
            if(map.size() >= c){
                int firstKey = 0;
                for(Integer n:map.keySet()){
                    firstKey = n;
                    break;
                }
                map.remove(firstKey);
            }
            map.put(key,value);

        }
        makeRecent(key);

    }

    private void makeRecent(int key){
        int value = map.get(key);
        map.remove(key);
        map.put(key,value);
    }
}
