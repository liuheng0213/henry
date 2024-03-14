package basic.knowledge.henry.ThreadRelevant._26threadSafe.differentLogicInRunMethod;

public class Consumer implements Runnable{
    Acount acount;//share this account/money

    Consumer(Acount acount) {
        this.acount = acount;
    }

    @Override
    public void run() {
        while (true) {
            int random = (int)(Math.random() * 1000);
            acount.getMoney(random);
        }
    }

}
