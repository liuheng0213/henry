package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

import java.util.Arrays;

import java.util.Arrays;

public class MaximizeMedian {

    public static void main(String[] args) {
        int[] nums = {1, 4, 5};
        int k = 2;
        MaximizeMedian obj = new MaximizeMedian();

        int maxMedian = obj.maximizeMedian(nums, k);
        System.out.println("Maximum median: " + maxMedian);
    }

    private int maximizeMedian(int[] nums, int k) {
        int l = 1;
        int right = nums[nums.length - 1] + k;

        int res = nums[(nums.length - 1) / 2];
        int median = 0;
        while (l <= right) {
            median = (l + right) / 2;
            if (checkMedian(nums, median, k)) { // median 符合条件, 进一步找更大的
                l = median + 1;
                res = median;
            } else {
                right = median - 1;
            }
        }

        return res;
    }

    private boolean checkMedian(int[] nums, int median, int k) {
        int operations = 0;
        for (int i = nums.length / 2; i < nums.length; i++) {
            if (nums[i] < median) {
                operations += median - nums[i];
            }
        }

        return operations <= k;
    }
}
