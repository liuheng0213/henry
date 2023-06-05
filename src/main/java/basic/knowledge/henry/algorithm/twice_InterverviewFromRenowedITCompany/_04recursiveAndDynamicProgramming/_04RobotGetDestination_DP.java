package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _04RobotGetDestination_DP {
    public static void main(String[] args) {
        _04RobotGetDestination_DP robotGetDestination = new _04RobotGetDestination_DP();
        int res = robotGetDestination.solution(7, 3, 4, 5);
        System.out.println(res);
    }

    private int solution(int n, int cur, int rest, int target) {
        int row = n + 1;
        int col = rest + 1;
        int[][] dp = new int[row][col];

        //base case
        for (int i = 1; i < row; i++) {
            dp[i][0] = i == target ? 1 : 0;
        }

        for (int j = 1; j < col; j++) {
            for (int i = 1; i < row; i++) {
                if (i == 1) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else if (i == row - 1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] + dp[i - 1][j - 1];
                }
            }
        }

        return dp[cur][rest];
    }
}
