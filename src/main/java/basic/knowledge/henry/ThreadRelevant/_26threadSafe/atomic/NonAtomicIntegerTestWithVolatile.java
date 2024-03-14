package basic.knowledge.henry.ThreadRelevant._26threadSafe.atomic;

//not safe
public class NonAtomicIntegerTestWithVolatile {

    private static final int THREADS_CONUT = 20;
//    public static AtomicInteger count = new AtomicInteger(0);
    public static volatile int c = 0;
    public static void increase() {
//        count.incrementAndGet();
        //volatile 并不能让C++ write operations safe
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
