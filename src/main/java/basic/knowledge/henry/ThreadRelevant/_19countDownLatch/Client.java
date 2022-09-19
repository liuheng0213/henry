package basic.knowledge.henry.ThreadRelevant._19countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Client {
    private static  final CountDownLatch countDownLatch = new CountDownLatch(5);
    public static void main(String[] args) throws InterruptedException {

        System.out.println("控球后卫到位！等待所有位置球员到位！");
        countDownLatch.countDown();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("得分后卫到位！");
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("中锋到位！");
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            System.out.println("大前锋到位！");
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            System.out.println("小前锋到位！");
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        System.out.print("全部到位，开始进攻！");
    }
}
