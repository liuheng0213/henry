package basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import edu.princeton.cs.algs4.In;

public class _20DiffValueBetweenNeighbours {
    public int solution(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        boolean[] hasNums = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        for (int i = 0; i < len; i++) {
            int idx = getIndex(nums[i], min, max, len);
            mins[idx] = hasNums[idx] ? Math.min(mins[idx], nums[i]) : nums[i];
            maxs[idx] = hasNums[idx] ? Math.max(maxs[idx], nums[i]) : nums[i];
            hasNums[idx] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i < len + 1; i++) {
            if (hasNums[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    private int getIndex(long num, long min, long max, long len) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int num = 105;
        int max = 110;
        int min = 10;
        int len = 10;
        System.out.println((num - min) * len / (max - min));
    }
}
