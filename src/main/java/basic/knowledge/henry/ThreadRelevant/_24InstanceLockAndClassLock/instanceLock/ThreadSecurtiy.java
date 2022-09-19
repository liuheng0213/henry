package basic.knowledge.henry.ThreadRelevant._24InstanceLockAndClassLock.instanceLock;



//https://blog.csdn.net/zcg_741454897/article/details/108540717
public class ThreadSecurtiy implements Runnable{
    int ticket = 100;
    @Override
    public void run() {
        sellTicket();//设置线程任务是调用addSalary接口
    }

    public synchronized void sellTicket(){
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
        ThreadSecurtiy ts = new ThreadSecurtiy();//创建一个ts对象
        for(int i = 0;i < 10;i++){//通过ts创建了10个线程，这10个线程对同一个对象ts的salary进行访问
            new Thread(ts).start();
        }
    }
}

