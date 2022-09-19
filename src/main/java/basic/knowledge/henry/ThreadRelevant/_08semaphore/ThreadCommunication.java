package basic.knowledge.henry.ThreadRelevant._08semaphore;

import java.util.concurrent.Semaphore;

/**
 * 三个线程a,b,c 并发运行,b,c需要拿到a初始化的数据
 * 定义一个信号量:该类内部维持了多个线程锁,可以阻塞多个线程,释放多个线程
 * 线程的阻塞和释放通过permit概念
 *   1 线程通过semaphore.aqucire()方法获取permit, 如果当前semaphore有permit则分配给该线程
 * 如果没有则阻塞,则 step 2
 *   2 直到semaphore调用release()方法释放permit
 *   3 构造函数中参数 permit的个数
 */
//功能: threadA 先运行, 然后
public class ThreadCommunication {
    private static Semaphore semaphore = new Semaphore(1, true); //给与一个初始的锁
    private static int num;  //资源数据
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //模拟好事操作之后,初始化num
                    //Thread.sleep(1000);
                   // semaphore.acquire();
                    num = 1;
                    System.out.println(Thread.currentThread().getName() + "haha获取到的Num值为:" + num);
                    //初始化完成后释放两个permits
                    semaphore.release(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取permit,如果semaphore没有可用的permit则等待,有则消耗一个
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "yeah获取到的Num值为:" + num);
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    //获取permit,如果semaphore没有可用的permit则等待,有则消耗一个
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "获取到的Num值为:" + num);
            }
        });
        threadB.start();

        threadC.start();
        threadA.start();
    }
}

