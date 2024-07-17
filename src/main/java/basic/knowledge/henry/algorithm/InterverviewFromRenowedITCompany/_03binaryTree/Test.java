package basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

public class Test {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.right = new Node(3);
        node.right.left = new Node(2);
        Test test = new Test();
        test.mid(node);
    }

    private void mid(Node node) {
        if(node == null){
            return;
        }

        mid(node.left);
        System.out.println(node.value);
        mid(node.right);
    }


}
