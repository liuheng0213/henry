package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

//组成零钱总数的方法数, 一共多少组合, -1 为没有组合的可能
public class _03MinNumOfCoins_DP {
    public static void main(String[] args) {
        _03MinNumOfCoins_DP minNumOfCoins_dp = new _03MinNumOfCoins_DP();
        int[] arr = {5, 2, 3, 10, 15};
        int aim = 20;
        int res = minNumOfCoins_dp.solution(arr, aim);
        System.out.println(res);
    }

    private int solution(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 1) {
            return -1;
        }

        int row = arr.length + 1;
        int col = aim + 1;
        int[][] dp = new int[row][col];

        for (int j = 1; j < col; j++) {
            dp[row - 1][j] = -1;
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = -1;
                for (int k = 0; k * arr[i] <= j; k++) {
                    if (dp[i + 1][j - k * arr[i]] != -1) {
                        dp[i][j] = dp[i][j] == -1 ? (dp[i + 1][j - k * arr[i]] + k) : Math.min(dp[i][j], dp[i + 1][j - k * arr[i]] + k);
                    }
                }
            }
        }
        return dp[0][col - 1];

    }


}
