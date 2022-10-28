package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMC;

public class Game {
    Judge judge = null;

    public Game() {
        judge = new Judge();
    }


    public void start(Player player1, Player player2, int n) {

        int i = 1;
        while (i < n + 1) {
            System.out.println("Round " + i + ":");
            this.judge.playAndShow(player1, player2);
            System.out.println("=====================================");
            i++;
        }

        System.out.println(n + " rounds of games are finished!");
    }
}
