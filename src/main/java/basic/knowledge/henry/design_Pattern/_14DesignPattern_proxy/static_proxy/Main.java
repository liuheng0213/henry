package basic.knowledge.henry.design_Pattern._14DesignPattern_proxy.static_proxy;


public class Main {
    public static void main(String[] args){
        //定义租房
        IRentHouse rentHouse = new RentHouse();
        //定义中介
        IRentHouse intermediary = new IntermediaryProxy(rentHouse);
        //中介租房
        intermediary.rentHouse();
    }


}
