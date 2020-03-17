package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03BinaryTree;

public class _06IsBalanceTree {
    public static void main(String[] args) {
        Node head = new Node(-3);
        head.left = new Node(3);
        head.left.left = new Node(1);
        head.left.right = new Node(0);

      /*  head.left.right.left = new Node(1);
        head.left.right.right = new Node(6);
        head.left.right.right.left = new Node(-2);
        head.left.right.right.right = new Node(-8);*/

        head.right = new Node(-9);
        head.right.left = new Node(2);
        head.right.right = new Node(1);
        /*head.right.right.right = new Node(5);
        head.right.right.left = new Node(7);
        head.right.right.right.left = new Node(15);
        head.right.right.right.left.left = new Node(-4);
        head.right.right.right.left.left.left= new Node(10);*/

        _06IsBalanceTree isBalanceTree = new _06IsBalanceTree();
        boolean isBalanced = isBalanceTree.isBalancedTree(head);
        System.out.println(isBalanced);
    }

    private boolean isBalancedTree(Node node) {
        ReturnType returnType = process(node);
        return returnType.isBalanced;
    }

    /**
     * 判断自身是否balanced
     * @param node
     * @return
     */
    private ReturnType process(Node node) {
        if(node == null){
            return new ReturnType(true,0);
        }

        ReturnType leftReturnType = process(node.left);
        ReturnType rightReturnType = process(node.right);
        boolean isBalnced = true;
        int height = 1;
        if(!leftReturnType.isBalanced || !rightReturnType.isBalanced){
            isBalnced = false;
        }
        if(Math.abs(leftReturnType.height - rightReturnType.height) >= 1){
            isBalnced = false;
            height += leftReturnType.height - rightReturnType.height > 0 ? leftReturnType.height: rightReturnType.height;
        }else{
            height += leftReturnType.height;
        }

        return new ReturnType(isBalnced,height);
    }


    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}