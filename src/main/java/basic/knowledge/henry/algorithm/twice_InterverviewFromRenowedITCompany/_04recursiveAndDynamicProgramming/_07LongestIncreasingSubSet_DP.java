package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _07LongestIncreasingSubSet_DP {
    public static void main(String[] args) {
        _07LongestIncreasingSubSet_DP increasingSubSet = new _07LongestIncreasingSubSet_DP();
        int res = increasingSubSet.solution(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7});
        System.out.println(res);
    }

    private int solution(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
