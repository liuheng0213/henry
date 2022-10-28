package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMC;

import java.util.Random;

public class CmpPlayerOperation implements Operation {

    Random r = new Random();

    public HandSymbol showHandSymbol() {
        int index = r.nextInt(3);
        return HandSymbol.getHS(index);
    }


}
