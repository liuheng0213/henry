package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMC;

public class Test {

    public static void main(String[] args) {

        Operation cmpPlayerOp = new CmpPlayerOperation();
        Player computerPlayer = new Player(cmpPlayerOp, "computer player");

        Operation humanPlayerOp = new HumanPlayerOperation();
        Player humanPlayer = new Player(humanPlayerOp, "human Player");

        Game game = new Game();

        game.start(humanPlayer, computerPlayer, 5);
    }
}
