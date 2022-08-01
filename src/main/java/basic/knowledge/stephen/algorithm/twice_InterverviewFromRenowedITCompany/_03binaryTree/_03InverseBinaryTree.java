package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._03binaryTree;

import basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree.Node;

import java.util.LinkedList;

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
