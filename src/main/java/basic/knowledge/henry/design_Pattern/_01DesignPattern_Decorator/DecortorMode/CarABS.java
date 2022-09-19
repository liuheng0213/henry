package basic.knowledge.henry.design_Pattern._01DesignPattern_Decorator.DecortorMode;

public class CarABS extends CarDecorator{

	public CarABS(ICarShowable myCar) {
		super(myCar);
	}
	
	public void show(){
		super.show();
		System.out.println("abs added");
	}
	
}


