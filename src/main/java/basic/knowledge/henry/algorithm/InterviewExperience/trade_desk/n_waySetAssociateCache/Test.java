package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b- a);
        Collections.sort(new ArrayList<Integer>(),(a,b)->b- a);


        Hashtable<Integer,Integer> table = new Hashtable<>();

//        System.out.println(Integer.valueOf("0123"));
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(2);
//        list.add(2);
//        list.add(2);
//
//        list.remove(Integer.valueOf(2));
//        System.out.println();

    }

    private static void test5() {
        Cache<Integer, String> cache = new NWaySetAssociativeCache<>(2, 4, new LFUEvictPolicy<>());
        cache.put(16, "Good");
        cache.put(32, "Bad");
        cache.get(16);
        cache.get(32);
        cache.get(32);
        cache.put(24, "New Stuff");

        System.out.println(cache.get(32).equals("Bad"));
        System.out.println(cache.get(16) == null);


    }

    private static void test4() {
        Cache<Integer, String> cache = new NWaySetAssociativeCache<>(4, 8, new LRUEvictPolicy<>());
        cache.put(16, "Good");
        cache.put(32, "Bad");
        cache.put(48, "Ugly");
        cache.put(64, "Something");
        cache.put(80, "Wrong");

        System.out.println(cache.get(16) == null);
        System.out.println(cache.get(32).equals("Bad"));
        System.out.println(cache.get(48).equals("Ugly"));
        System.out.println(cache.get(64).equals("Something"));
        System.out.println(cache.get(80).equals("Wrong"));
    }

    private static void test3() {
        Cache<Integer, String> cache = new NWaySetAssociativeCache<>(2, 8, new MRUEvictPolicy<>());
        cache.put(16, "Good");
        cache.put(32, "Bad");
        cache.put(48, "Ugly");
        System.out.println(cache.get(16).equals("Good"));
        System.out.println(cache.get(32) == null);
        System.out.println(cache.get(48).equals("Ugly"));
    }

    private static void test2() {
        Cache<Integer, String> cache = new NWaySetAssociativeCache<>(2, 8, new LRUEvictPolicy<>());
        cache.put(16, "Good");
        cache.put(32, "Bad");
        cache.put(48, "Ugly");
        String str1 = cache.get(16);
        String str2 = cache.get(32);
        String str3 = cache.get(48);
        System.out.println(str1 == null);
        System.out.println(str2.equals("Bad"));
        System.out.println(str3.equals("Ugly"));
    }

    private static void test1() {
        Cache<String, String> cache = new NWaySetAssociativeCache<>(2, 8, new LRUEvictPolicy<>());
        cache.put("Something", "Good");
        cache.put("Always", "Bad");

        String something = cache.get("Something");
        String always = cache.get("Always");

        System.out.println(something.equals("Good"));
        System.out.println(always.equals("Bad"));

    }
}
