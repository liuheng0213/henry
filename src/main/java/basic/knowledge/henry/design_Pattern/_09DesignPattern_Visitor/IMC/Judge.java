package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMC;

public class Judge {

    public void playAndShow(Player p1, Player p2) {

        HandSymbol s1 = p1.play();
        HandSymbol s2 = p2.play();

        int index1 = s1.getIndex();
        int index2 = s2.getIndex();

        if (index1 == index2) {
            System.out.println(p1.name + " and " + p2.name + " get a tie");
        } else if ((index2 + 1) % 3 == index1) {
            System.out.println(p2.name + " is the winner");
        } else {
            System.out.println(p1.name + " is the winner");
        }

    }
}
