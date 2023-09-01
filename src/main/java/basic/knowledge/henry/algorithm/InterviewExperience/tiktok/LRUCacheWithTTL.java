package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

//with tile to live
public class LRUCacheWithTTL {
    int c;
    LinkedHashMap<Integer, Integer> map = null;// store key value
    PriorityQueue<Node> pq = new PriorityQueue<>();//store key and timestamp

    public LRUCacheWithTTL(int capacity) {
        this.c = capacity;
        map = new LinkedHashMap<>();
        while (pq.peek().time < System.currentTimeMillis()) {
            Node poll = pq.poll();
            map.remove(poll.key);
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecent(key);
            return map.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);

        } else {
            if (map.size() >= c) {
                int firstKey = 0;
                for (Integer n : map.keySet()) {
                    firstKey = n;
                    break;
                }
                map.remove(firstKey);
            }
            map.put(key, value);

        }
        pq.add(new Node(key,System.currentTimeMillis()));
        makeRecent(key);

    }

    private void makeRecent(int key) {
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
    }

    public class Node implements Comparable<Node> {
        Integer key;
        long time;


        public Node(Integer key, long time) {
            this.key = key;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.time - o.time);
        }
    }
}
