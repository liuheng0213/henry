package basic.knowledge.henry.ThreadRelevant._03ProducerConsumer.foobar;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private AtomicBoolean printF = new AtomicBoolean(false);
    private AtomicBoolean printB = new AtomicBoolean(true);

    public FooBar(int n) {
        this.n = n;
    }


    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try {

            for (int i = 0; i < n; i++) {
                while (!printB.get()) {
                    condition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                printB.set(false);
                printF.set(true);
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        try {

            for (int i = 0; i < n; i++) {
                while (!printF.get()) {
                    condition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                printF.set(false);
                printB.set(true);
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }


    }
}
