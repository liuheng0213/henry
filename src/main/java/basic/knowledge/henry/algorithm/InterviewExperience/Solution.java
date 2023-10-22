package basic.knowledge.henry.algorithm.InterviewExperience;

import java.util.HashMap;
import java.util.Map;


class Solution {
    public static void main(String[] args) {
        Solution obj = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(-2);
        node.right = new TreeNode(-3);

        int i = obj.pathSum(node, -1);
        System.out.println(i);
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        return helper(root,targetSum,0L,map);
    }
    public int helper(TreeNode root,int targetSum,long currSum,Map<Long,Integer> map){
        if(root == null)
            return 0;
        currSum += root.value ;
        int count = 0;
        if(map.containsKey(currSum-targetSum)){
            count += map.get(currSum-targetSum);
        }
        map.put(currSum,map.getOrDefault(currSum,0)+1);
        int left = helper(root.left,targetSum,currSum,map) ;
        int right = helper(root.right,targetSum,currSum,map);
        map.put(currSum,map.get(currSum)-1);

        return count+left+right;


    }
}

