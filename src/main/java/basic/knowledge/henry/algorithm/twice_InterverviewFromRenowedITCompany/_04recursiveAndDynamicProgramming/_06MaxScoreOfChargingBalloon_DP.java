package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _06MaxScoreOfChargingBalloon_DP {
    public static void main(String[] args) {
        _06MaxScoreOfChargingBalloon_DP chargingBalloon = new _06MaxScoreOfChargingBalloon_DP();
        int[] arr = new int[]{3, 2, 5, 6};
        int res = chargingBalloon.solution(arr);
        System.out.println(res);
    }

    private int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] help = new int[arr.length + 2];
        help[0] = 1;
        help[arr.length + 1] = 1;
        for (int i = 1; i < arr.length + 1; i++) {
            help[i] = arr[i - 1];
        }

        int[][] dp = new int[help.length][help.length];

        for (int i = 1; i < help.length - 1; i++) {
            dp[i][i] = help[i - 1] * help[i] * help[i + 1];
        }


        for (int i = help.length - 2; i >= 1; i--) {
            for (int j = i + 1; j <= help.length - 2; j++) {
                int max = Math.max(dp[i + 1][j] + help[i - 1] * help[i] * help[j + 1], dp[i][j - 1] + help[j] * help[i - 1] * help[j + 1]);
                for (int k = i + 1; k <= j - 1; k++) {
                    max = Math.max(max, help[i - 1] * help[k] * help[j + 1] + dp[i][k - 1] + dp[k + 1][j + 1]);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][help.length - 2];

    }
}
