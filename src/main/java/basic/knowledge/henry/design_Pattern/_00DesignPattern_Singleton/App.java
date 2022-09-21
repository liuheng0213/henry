package basic.knowledge.henry.design_Pattern._00DesignPattern_Singleton;

public class App {
    public static void main(String[] args) {

        SingletonUsage su = new SingletonUsage();
        for(int i = 0;i< 100;i++){
            new Thread(new SingletonUsage()).start();
        }

    }
}
