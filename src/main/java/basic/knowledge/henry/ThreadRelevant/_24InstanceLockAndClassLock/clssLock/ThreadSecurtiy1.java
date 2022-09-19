package basic.knowledge.henry.ThreadRelevant._24InstanceLockAndClassLock.clssLock;

public class ThreadSecurtiy1 implements Runnable{
    static int ticket = 100;
    @Override
    public void run() {
        sellTicket();//设置线程任务是调用addSalary接口
    }

    public static synchronized void sellTicket(){
        while (ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticket > 0) ticket--;//当票数大于0的时候，就可以卖票
            System.out.println(Thread.currentThread().getName() + "正在卖" + ticket + "张票");
        }
    }

    public static void main(String[] args) {
        ThreadSecurtiy1 ts = new ThreadSecurtiy1();//创建一个ts对象
        ThreadSecurtiy1 ts1 = new ThreadSecurtiy1();//创建另一个对象
        new Thread(ts).start();
        new Thread(ts1).start();
    }
}

