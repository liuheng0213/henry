package basic.knowledge.henry.ThreadRelevant._01startDemo;

//1):定义一个类A实现于java.lang.Runnable接口,注意A类不是线程类.
class MusicImplements implements Runnable {
    //2):在A类中覆盖Runnable接口中的run方法.
    public void run() {
        //3):在run方法中编写需要执行的操作
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "播放音乐=>" + i);
        }
    }
}

public class ThreadStart2 {
    public static void main(String[] args) {
        for (int j = 0; j < 3; j++) {


            //4):在main方法(线程)中,创建线程对象,并启动线程
            MusicImplements mi = new MusicImplements();
            Thread t = new Thread(mi);
            t.start();

        }
    }
}
