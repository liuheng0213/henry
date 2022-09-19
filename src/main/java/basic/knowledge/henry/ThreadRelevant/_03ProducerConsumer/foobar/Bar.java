package basic.knowledge.henry.ThreadRelevant._03ProducerConsumer.foobar;

public class Bar implements Runnable {
    @Override
    public void run() {
        System.out.println("bar");
    }
}
