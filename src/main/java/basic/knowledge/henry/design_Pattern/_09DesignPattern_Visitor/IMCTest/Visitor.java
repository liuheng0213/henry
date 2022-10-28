package basic.knowledge.henry.design_Pattern._09DesignPattern_Visitor.IMCTest;



public interface Visitor {
    HandSymbol visit(CmpPlayer cmpPlayer);

    HandSymbol visit(HumanPlayer humanPlayer);
}
