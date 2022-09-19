package basic.knowledge.henry.design_Pattern._02DesignPattern_Builder.AbstractBuilder;


import basic.knowledge.henry.design_Pattern._02DesignPattern_Builder.Product.Car;

public interface ICarBuilder {
    void buildWheel();
    void buildSkeleton();
    void buildEngine();

    Car buildCar();
}
