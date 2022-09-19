package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _05MethodOfMoneyChange_DP {
    public static void main(String[] args) {
        _05MethodOfMoneyChange_DP methodOfMoneyChange = new _05MethodOfMoneyChange_DP();
        int[] arr = new int[]{5, 10, 25, 1, 100, 50};
        int methods = methodOfMoneyChange.coin(arr, 180);
        System.out.println(methods);
    }



    public int coin(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        //dp[i][j] 表示 i~arrlength - 1已用 j为剩余的数额
        //dp[i][j] 依赖于i+1 ,aim-k*arr[i]

        int[][] dp = new int[arr.length + 1][aim + 1];

        dp[arr.length][0] = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = 0;

                for(int k = 0;k * arr[i]<= j;k++){
                    dp[i][j]+= dp[i+1][j - k * arr[i]];
                }
            }
        }

        return dp[0][aim];
    }

}
