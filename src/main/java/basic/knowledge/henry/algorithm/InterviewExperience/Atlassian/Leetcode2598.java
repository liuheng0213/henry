package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;


/**
 * You are given a 0-indexed integer array nums and an integer value.
 *
 * In one operation, you can add or subtract value from any element of nums.
 *
 * For example, if nums = [1,2,3] and value = 2, you can choose to subtract value from nums[0] to make nums = [-1,2,3].
 * The MEX (minimum excluded) of an array is the smallest missing non-negative integer in it.
 *
 * For example, the MEX of [-1,2,3] is 0 while the MEX of [1,0,3] is 2.
 * Return the maximum MEX of nums after applying the mentioned operation any number of times.
 */
public class Leetcode2598 {
    public static void main(String[] args) {
        Leetcode2598 leetcode2598 = new Leetcode2598();
        int[] nums = new int[]{1,-10,7,13,6,8};
        int value = 5;
        int res = leetcode2598.findSmallestInteger(nums, value);
        System.out.println(res);

    }


    /**
     Here is the explanation to the last line - return minIdx + counts[minIdx]*value;. Read code first.

     Case 1: We have one number which appears count = 0 times.
     nums = [0,1,1,2,3,3], value = 5

     The resulting smallest number would be 4 as it doesn't appear.
     idx/num -> freq
     0 -> 1
     1 -> 2
     2 -> 1
     3 -> 2
     4 -> 0 <-- this is the lowest

     0 1 2 3   0 1 2 3 各拿出来一个 凑齐；  还剩 1 3 凑不齐
     Case 2: We have numbers that appear count >= 1 times.
     nums = [0,0,1,1,2,2,3], value = 4

     So the resulting smallest number out from this list. We take the lowest multiple of lowest count and add value.
     Now, lowest count is at idx/num (of counts[]) = 3.
     So 3 (is present).. but 3 + 1*value (=7 is not present)
     idx/num -> freq
     0 -> 2
     1 -> 2
     2 -> 2
     3 -> 1 <-- this is the lowest

     0 1 2 3  0 1 2（4 5 6）  so 7 is the result
     Q. How can we be sure 7 is the lowest here?

     Firstly, we know 0, 1, 2, 3 numbers are present.
     Is 4 present? - Yes, the 0 can be made use of like - 0, (0 + value = 4).
                     Keep in mind - we can use 0 only 2 times due to its freq
     Is 5 present? - Yes - 1, (1 + value = 5)
     Is 6 present? - Yes - 2, (2 + value = 6)
     Is 7 present? - Ouch, no - Only 3. (can be taken only once due to its freq).
     So here least answer is 3 + value = 7.
     * @param nums
     * @param value
     * @return
     */

    public int findSmallestInteger(int[] nums, int value) {
        int[] largestModulo = new int[value];
        for (int i=0;i<nums.length;i++){
            int modulo = nums[i]%value;
            if (modulo < 0)modulo = modulo + value;
            largestModulo[modulo]++;
        }
        int maxIdx = 0;
        for(int i = 0;i< value;i++) {
            if (largestModulo[i] < largestModulo[maxIdx]) {
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}
