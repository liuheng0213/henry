package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

//组成零钱总数的方法数, 一共多少组合, -1 为没有组合的可能
public class _03MinNumOfCoins_DP {
    public static void main(String[] args) {
        _03MinNumOfCoins_DP minNumOfCoins = new _03MinNumOfCoins_DP();
        int[] arr = {5, 2, 3,10};
        int aim = 20;
        int res = minNumOfCoins.minCoins(arr, aim);
        System.out.println(res);
    }
    public int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        //base case
        for (int j = 1; j < aim + 1; j++) {
            dp[N][j] = -1;
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -1;
                for (int k = 0; k * arr[i] <= j; k++) {

                    if (dp[i + 1][j - k * arr[i]] != -1) {
                        if( dp[i][j] == -1){
                            dp[i][j] = dp[i + 1][j - k * arr[i]] + k;
                        }else{
                            dp[i][j] = Math.min(dp[i][j],dp[i + 1][j - k * arr[i]] + k);
                        }
                    }
                }
            }
        }

        return dp[0][aim];

    }




}
