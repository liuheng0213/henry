package basic.knowledge.henry.design_Pattern._14DesignPattern_proxy.mandatory_proxy;


public class Main {
    public static void main(String[] args) {

        IRentHouse iRentHosue = new LandLord();
        //租客找房东租房
        iRentHosue.rentHouse();
        //找中介租房
        IRentHouse rentHouse = iRentHosue.getProxy();
        rentHouse.rentHouse();


    }

}

