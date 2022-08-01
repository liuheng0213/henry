package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._03binaryTree;

import basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree.Node;

//叶子节点就是没有左右子节点的节点
//二叉树的最小深度  根节点到最近叶子节点的距离。
//二叉树的最大深度  根节点到最远叶子节点的距离。
public class _01MinDepth {

    public int minDepth(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head, 1);
    }

    private int process(Node head, int level) {
        //leaf node, base case
        if (head.left == null && head.right == null) {
            return level;
        }
        int min = Integer.MAX_VALUE;
        if (head.right != null) {
            min = Math.max(min, process(head.right, level + 1));
        }

        if (head.left != null) {
            min = Math.max(min, process(head.left, level + 1));
        }

        return min;

    }

}
