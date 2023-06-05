package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//从0,0 走到  对角尽头 ,最小的路径和是多少
public class _02MinSumOfPath_DP {
    public static void main(String[] args) {
        _02MinSumOfPath_DP minSumOfPathDp = new _02MinSumOfPath_DP();
        int[][] arr = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int res = minSumOfPathDp.getRes(arr);
        System.out.println(res);
    }

    private int getRes(int[][] arr) {
        if (arr == null || arr[0] == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = arr[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
