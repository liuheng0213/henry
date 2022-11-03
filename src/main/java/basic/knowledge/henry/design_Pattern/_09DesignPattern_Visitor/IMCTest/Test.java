package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMCTest;


public class Test {

    public static void main(String[] args) {

        Player computerPlayer = new CmpPlayer( "computer player");
        Player humanPlayer = new HumanPlayer( "human Player");

        Judge judge = new Judge(humanPlayer,computerPlayer);
        Game game = new Game(judge);

        game.start(5);
    }
}
