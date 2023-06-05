package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _05MethodOfMoneyChange_DP {
    public static void main(String[] args) {
        _05MethodOfMoneyChange_DP methodOfMoneyChange = new _05MethodOfMoneyChange_DP();
        int[] arr = new int[]{5, 10, 25, 1, 100, 50, 20};
        int aim = 180;
        int res = methodOfMoneyChange.solution(arr, aim);
        System.out.println(res);
    }

    private int solution(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;


        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < aim + 1; j++) {
                dp[i][j] = 0;
                for (int k = 0; arr[i] * k <= j; k++) {
                    dp[i][j] += dp[i + 1][j - arr[i] * k];
                }
            }
        }
        return dp[0][aim];
    }
}
