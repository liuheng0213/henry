package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMCTest;


public class Game {
    Judge judge;


    public Game(Judge judge) {
        this.judge = judge;
    }


    public void start(int n) {

        int i = 1;
        while (i < n + 1) {
            System.out.println("Round " + i + ":");
            judge.showGameResult(new HandSymbolVisitor());
            System.out.println("=====================================");
            i++;
        }

        System.out.println(n + " rounds of games are finished!");
    }
}
