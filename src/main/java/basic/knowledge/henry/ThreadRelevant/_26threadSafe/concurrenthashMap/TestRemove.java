package basic.knowledge.henry.ThreadRelevant._26threadSafe.concurrenthashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//当使用ConcurrentHashMap时，结果为1000；当使用HashMap时，结果为1024； hashtable 1000
//单一操作 安全
public class TestRemove {
    public static void main(String[] args) {
//        final Map<String, Integer> count = new HashMap<>();
        final Map<String, Integer> count = new ConcurrentHashMap<>();
        //final Hashtable<String, Integer> count = new Hashtable<>();
        for (int i = 0; i < 2000; i++) {
            count.put("count" + i, 1);
        }
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    count.remove("count" + i);
                }
            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i < 1500; i++) {
                    count.remove("count" + i);
                }
            }
        };
        new Thread(task1).start();
        new Thread(task2).start();
        try {
            Thread.sleep(1000l);
            System.out.println(count.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
