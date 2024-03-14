package basic.knowledge.henry.ThreadRelevant._15concurrentAPI.concurrenthashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//https://www.cnblogs.com/zwh0910/p/14440248.html
public class TestConcurrentHashMap2Value {
    public static void main(String[] args) {
        final Map<String, Integer> count = new ConcurrentHashMap<>();
//        final Map<String, Integer> count = new HashMap<>();
//        final Map<String, Integer> count = new Hashtable<>();
        count.put("count", 0);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                // 复合操作, 并不安全
                //should use synchronized (count){
                int value;
                for (int i = 0; i < 2000; i++) {
                    value = count.get("count");
                    count.put("count", value + 1);
                }
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        try {
            Thread.sleep(1000l);
            System.out.println(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
