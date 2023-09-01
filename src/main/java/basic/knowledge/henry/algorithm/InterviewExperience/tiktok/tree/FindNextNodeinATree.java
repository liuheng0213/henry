package basic.knowledge.henry.algorithm.InterviewExperience.tiktok.tree;

import basic.knowledge.henry.algorithm.InterviewExperience.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//中序遍历,给定节点返回下一个节点
public class FindNextNodeinATree {
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        FindNextNodeinATree obj = new FindNextNodeinATree();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(7);
        node.left.right.right = new TreeNode(10);


        node.right = new TreeNode(5);
        node.right.left = new TreeNode(8);
        node.right.right = new TreeNode(9);
        int res = obj.findNext(node,10);
        System.out.println(res);
       //必须用非递归的方法
    }

    private int findNext(TreeNode head, int pre) {
        if(head != null){
            int first = Integer.MIN_VALUE;
            Stack<TreeNode> s = new Stack<>();
            while(!s.isEmpty() || head != null){
                if(head != null){
                    s.push(head);
                    head = head.left;
                }else{
                    head = s.pop();
                    if(head.value == pre){
                        first = pre;
                    }else if(first == pre){
                        return head.value;
                    }
                    head = head.right;
                }
            }
        }

        return 0;
    }


}
