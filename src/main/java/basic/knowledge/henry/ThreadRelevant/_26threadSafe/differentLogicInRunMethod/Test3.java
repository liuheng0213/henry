package basic.knowledge.henry.ThreadRelevant._26threadSafe.differentLogicInRunMethod;

public class Test3 {


     int j = 100;

    public static void main(String[] args) {

        new Test3().test();

    }

    private  void test() {
        for (int i = 0; i < 6; i++) {
            new Thread(new Add()).start();
            new Thread(new Reduce()).start();
        }
    }

    /**
     * 共享数据内部类方式
     */
    /*****同步******/
    public synchronized void add() {
        j++;
        System.out.println("add:" + j);
    }

    /*****同步******/
    public  synchronized void reduce() {
        j--;
        System.out.println("reduce:" + j);
    }

     class Add implements Runnable {

        @Override
        public void run() {
            add();
        }
    }

     class Reduce implements Runnable {

        @Override
        public void run() {
            reduce();
        }
    }

}
