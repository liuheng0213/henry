package basic.knowledge.henry.ThreadRelevant._25deadLock;

public class TestDeadlock {
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(()->{
            while(true){
                synchronized (o1){
                    System.out.println("1111");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (o2){
                        System.out.println("2222");
                    }
                }
            }
        });


        Thread threadB = new Thread(()->{
            while(true){
                synchronized (o2){
                    System.out.println("1111");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (o1){
                        System.out.println("2222");
                    }
                }
            }
        });



        threadA.start();;
        threadB.start();
    }
}
