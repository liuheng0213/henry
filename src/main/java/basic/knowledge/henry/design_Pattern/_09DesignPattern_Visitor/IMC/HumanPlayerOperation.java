package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMC;

import java.util.Scanner;

public class HumanPlayerOperation implements Operation {
    Scanner s = new Scanner(System.in);

    public HandSymbol showHandSymbol() {
        System.out.println("input a number ranging in 0~2; 0 representing Rock;1 representing Scissors;2 representing Paper");
        boolean flag = false;

        int num = 0;
        while (!flag) {
            int index = s.nextInt();
            HandSymbol[] values = HandSymbol.values();

            for (HandSymbol hs : values) {
                if (index == hs.getIndex()) {
                    flag = true;
                    num = index;
                    break;
                }
            }

            if (!flag) {
                System.out.println(" please input a new number ranging in 0~2!");
            }
        }

        return HandSymbol.getHS(num);
    }
}
