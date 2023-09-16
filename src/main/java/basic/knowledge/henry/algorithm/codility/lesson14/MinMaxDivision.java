package basic.knowledge.henry.algorithm.codility.lesson14;

//最小大和
//给定正整数数组
//求最大中的最小，或者最小中的最大，要么是二分，要么是动态规划。
public class MinMaxDivision {
    public static void main(String[] args) {
        MinMaxDivision minMaxDivision = new MinMaxDivision();
        int[] arr = new int[]{1, 4, 4};
        int res = minMaxDivision.solution(3, arr);//k划分快数
        int res2 = minMaxDivision.splitArray2(arr, 3);//k划分快数
        System.out.println(res);
        System.out.println(res2);
    }

    public int splitArray2(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m > nums.length || m < 1) {
            return -1;
        }

        int row = nums.length;
        int col = m + 1;

        int[][] dp = new int[row][col];

        dp[0][1] = nums[0];
        for (int i = 1; i < row; i++) {
            dp[i][1] = dp[i - 1][1] + nums[i];
        }

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i <nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 2; j < col; j++) {
                if (j <= i + 1) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = j - 2; k <= i; k++) {

                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i]-sum[k] ));
//                        System.out.println(dp[i][j]);


                    }

                }
            }
        }


        return dp[nums.length - 1][m];


    }



    /**
     * 应该了解到  最终结果绝对 是最接近于(稍微大于)  切分均值  或 等于切分均值的某个个值
     * 了解了 这个 可以继续
     *
     * @param K
     * @param arr
     * @return
     */
    private int solution(int K, int[] arr) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            left = Math.max(left, arr[i]);
            right += arr[i];
        }
        //最小大和值一点在left 和right之间
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isTrue(arr, mid, K)) { // 只有mid 值偏大的情况  适合于 right = mid - 1;
                right = mid - 1;  //只有这种if 情况 针对确定值
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //二分中的判断条件就是该数组是否可以划分小于等于k个块(or mid 是否偏大)，并且每个  注意是 每个  块的和都小于等于mid(sum)
    //1如果符合条件，说明mid的值是过大的(或者是恰好的)，还可以再小一点(或者恰好相等)，但是按照我的代码以及 basic.knowledge.henry.algorithm.algorithm_4_Edition.ch3.BinarySearchDemo
    // 1可以在取小的情况下取得结果 end = mid-1;  (ks == k 都如此 更别谈 ks < k了)
    // 1任何情况的切分 k之和各自都小于Mid  那么res都是小于或等于mid的  而下述方法的切分是最接近结果的  更别谈ks < k的情况 mid更加偏大
    //2 如果不符合条件，说明mid的值是过小的，start=mid + 1;
    //2 的结论 一是可以和上面形成反例,  二是 res
    private boolean isTrue(int[] arr, int sum, int k) {
        int ks = 0;
        int tempSum = 0;
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            if (tempSum > sum) {
                tempSum = 0;
                ks++;
                i--;
            }
        }

        if (tempSum > 0) {
            ks++;
        }

        if (ks <= k) {
            return true;
        }
        return false;
    }
}
