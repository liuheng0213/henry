package basic.knowledge.henry.algorithm.leetcode.backtrack;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


//全排列
public class Solution {
    public static void main(String[] args) {
        BigInteger num =  fib(new BigInteger("0"),new BigInteger("1"),10);
        System.out.println(num);
    }
//84266613096281243382112
    public static BigInteger fibonacciModified(int t1, int t2, int n) {
        // Write your code here
        BigInteger num1 = new BigInteger(Integer.toString(t1));
        BigInteger num2 = new BigInteger(Integer.toString(t2));

        return fib(num1,num2,n);

    }

    private static BigInteger fib(BigInteger t1, BigInteger t2, int n){
        if(n == 1){
            return t1;
        }else if(n == 2){
            return t2;
        }else if(n == 3){
            return t1.add(t2.multiply(t2));
        }
        return fib(t1,t2,n - 2).add(fib(t1,t2,n - 1).multiply(fib(t1,t2,n - 1)));
    }
    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {

        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(depth);
            }
        }
    }



}
