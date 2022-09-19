package basic.knowledge.henry.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Leetcode1799 {
    public static void main(String[] args) {
        Leetcode1799 leetcode1799 = new Leetcode1799();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(-3);
        set.add(3);
        set.add(7);
        System.out.println(set.toString());

        int i = leetcode1799.maxScore(new int[]{3, 4, 6, 8});

        System.out.println(i);
    }


    int n;
    HashMap<String, Integer> memo;

    public int maxScore(int[] nums) {
        n = nums.length / 2;
        memo = new HashMap<>();
        return backtrack(nums, 1, new HashSet<>());
        //return res;
    }

    private int backtrack(int[] nums, int i, HashSet<Integer> set) {
        if (i > n) {
            return 0;
        }

        String key = convert(i, set);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }


        int val = 0, res = 0;
        for (int j = 0; j < nums.length; j++) {
            if (!set.contains(j)) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (!set.contains(k)) {
                        set.add(j);
                        set.add(k);
                        val = i * (gcd(nums[j], nums[k])) + backtrack(nums, i + 1, set);
                        res = Math.max(res, val);
                        set.remove(j);
                        set.remove(k);
                    }
                }
            }
        }

        memo.put(key, res);
        return res;
    }

    private int gcd(int a, int b) {

        return b == 0 ? a : gcd(b, a % b);
    }

    private String convert(int i, HashSet<Integer> set) {
        return Integer.toString(i) + set.toString();
    }
}
