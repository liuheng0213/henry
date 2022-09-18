package basic.knowledge.henry.algorithm.test;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        Test test = new Test();


        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int i = test.averageOfSubtree(root);

        System.out.println(i);
    }


    int ans = 0;
    List<TreeNode> list = new ArrayList<>();
    public int averageOfSubtree(TreeNode root) {

        if(root == null){
            return ans;
        }

        ReturnType data = process(root);


        return ans;
    }

    private ReturnType process(TreeNode node){
        if(node == null){
            return new ReturnType(0,0);
        }


        ReturnType left = process(node.left);

        ReturnType right = process(node.right);

        int newSum = right.sum + left.sum + node.val;
        int newNumber = right.number + left.number + 1;

        if(newSum/newNumber == node.val){
            ans++;
            list.add(node);
        }

        return new ReturnType(newSum,newNumber);
    }


    class ReturnType{
        int sum;
        int number;

        public ReturnType(int sum,int number){
            this.sum = sum;
            this.number = number;
        }
    }


}
