package basic.knowledge.henry.extend;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Animal ani = test.getAni();
        System.out.println("==========");
    }


    public Animal getAni(){
        Cat cat = new Cat();
        cat.setType("cat");
        cat.setName("mimi");
        return cat;
    }
}
