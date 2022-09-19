package basic.knowledge.henry.ThreadRelevant._03ProducerConsumer.foobar;

public class App {
    public static void main(String[] args) throws InterruptedException {


        Bar bar = new Bar();
        Foo foo = new Foo();
        new Thread(bar).start();
        new Thread(foo).start();
        FooBar fooBar = new FooBar(20);
        fooBar.bar(bar);
        fooBar.foo(foo);



    }
}
