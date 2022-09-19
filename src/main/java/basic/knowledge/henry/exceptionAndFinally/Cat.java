package basic.knowledge.henry.exceptionAndFinally;

public class Cat extends Animal {
    @Override
    public void testException() {
        try {
            System.out.println(1/0);
        } catch (Exception e) {
            System.out.println("123 hh");
            System.out.println("123 hh1");
            System.out.println("123 hh2");
            System.out.println("123 hh3");
        }

    }
}
