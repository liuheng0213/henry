package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMCTest;

public enum HandSymbol {
    ROCK(0, "Rock"), SCISSORS(1, "Scissors"), PAPER(2, "Paper");

    private int index;
    private String name;

    HandSymbol(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static HandSymbol getHS(int index) {
        for (HandSymbol hs : HandSymbol.values()) {
            if (index == hs.getIndex()) {
                return hs;
            }
        }
        return null;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

}
