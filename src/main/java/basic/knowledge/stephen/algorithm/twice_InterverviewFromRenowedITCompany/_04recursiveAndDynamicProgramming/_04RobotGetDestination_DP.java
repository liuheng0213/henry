package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _04RobotGetDestination_DP {
    public static void main(String[] args) {
        _04RobotGetDestination_DP robotGetDestination = new _04RobotGetDestination_DP();
        int res = robotGetDestination.ways(7, 3, 4, 5);
        System.out.println(res);
    }


    /**
     *
     * @param N
     * @param cur 当前坐标
     * @param rest 还剩多少步
     * @param P
     * @return
     */
    private int ways(int N, int cur, int rest, int P) {
        if (N < 2 || cur < 1 || cur > N || P < 1 || P > N || rest < 1) {
            return 0;
        }

        //int[i][j] 表示还剩i步 当前位置为j return dp[cur][rest]
        int[][] dp = new int[rest + 1][N + 1];

        //base case
        dp[0][P] = 1;

        for (int i = 1; i <= rest; i++) {
            for (int j = 1; j <= N; j++) {
                if(j == 1){
                    dp[i][j] = dp[i - 1][2];
                }else if (j == N){
                    dp[i][j] = dp[i - 1][N - 1];
                }else{
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }

        return dp[rest][cur];
    }
}
