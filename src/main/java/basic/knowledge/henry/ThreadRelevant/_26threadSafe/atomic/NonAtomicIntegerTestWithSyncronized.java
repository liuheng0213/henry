package basic.knowledge.henry.ThreadRelevant._26threadSafe.atomic;

// safe
public class NonAtomicIntegerTestWithSyncronized {

    private static final int THREADS_CONUT = 30;
//    public static AtomicInteger count = new AtomicInteger(0);
    public static int c = 0;
    public static synchronized void increase() {
//        count.incrementAndGet();
        //synchronized 能让C++ write operations safe
        //但是 synchronized 不能让new Object 操作可序, 因此单例模式  即使加了syncronized 也要加volatile
        c++;
    }
    

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
//        System.out.println(count);
        System.out.println(c);
    }
}
