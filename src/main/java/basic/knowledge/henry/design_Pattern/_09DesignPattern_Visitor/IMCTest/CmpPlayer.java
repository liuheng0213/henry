package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMCTest;


import java.util.Random;

public class CmpPlayer extends Player{
    Random r = new Random();

    public CmpPlayer(String name) {
        super(name);
    }

    public HandSymbol showHandSymbol() {
        int index = r.nextInt(3);
        return HandSymbol.getHS(index);
    }


    @Override
    public HandSymbol accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
