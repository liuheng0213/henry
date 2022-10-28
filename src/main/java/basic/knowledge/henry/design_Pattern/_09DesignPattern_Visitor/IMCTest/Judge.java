package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMCTest;

import java.util.LinkedList;
import java.util.List;

public class Judge {
    Player player1;
    Player player2;

    public Judge(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public void showGameResult(Visitor visitor) {

        HandSymbol s1 = player1.accept(visitor);
        HandSymbol s2 = player2.accept(visitor);

        int index1 = s1.getIndex();
        int index2 = s2.getIndex();

        if (index1 == index2) {
            System.out.println(player1.name + " and " + player2.name + " get a tie");
        } else if ((index2 + 1) % 3 == index1) {
            System.out.println(player2.name + " is the winner");
        } else {
            System.out.println(player1.name + " is the winner");
        }

    }
}
