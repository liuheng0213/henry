package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._03binaryTree;

import basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._03binaryTree.Node;

public class _03InverseBinaryTree {

    private Node inverseBin(Node cur) {
        if (cur == null) {
            return cur;
        }
        cur.left = inverseBin(cur.right);
        cur.right = inverseBin(cur.left);
        return cur;
    }


}
