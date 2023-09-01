package basic.knowledge.henry.algorithm.InterviewExperience.tiktok.tree;

import basic.knowledge.henry.algorithm.InterviewExperience.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// 之字形遍历二叉树；
public class ZigzagTraversalofBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(7);
        node.left.right.right = new TreeNode(10);


        node.right = new TreeNode(5);
        node.right.left = new TreeNode(8);
        node.right.right = new TreeNode(9);

        ZigzagTraversalofBinaryTree obj = new ZigzagTraversalofBinaryTree();
        List<List<Integer>> res = obj.solution(node);
        for(List<Integer> sub : res){
            System.out.println();
            for(Integer n : sub){
                System.out.println(n);
            }
        }

    }

    private List<List<Integer>> solution(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);
        boolean reverse = false;
        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();

            for(int i= 0;i< size;i++){
                TreeNode poll = queue.poll();
                if(reverse){
                    subList.add(poll.value);
                }else {
                    subList.add(0,poll.value);
                }
                if(poll.left != null){
                    queue.add(poll.left);
                }

                if(poll.right != null){
                    queue.add(poll.right);
                }
            }

            reverse = !reverse;
            result.add(subList);
        }

        return result;
    }
}
