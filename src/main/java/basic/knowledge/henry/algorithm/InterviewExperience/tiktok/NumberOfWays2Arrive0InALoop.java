package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

//一个环，有n个点, 问从0点出发，经过k步回到原点有多少种方法
public class NumberOfWays2Arrive0InALoop {
    public static void main(String[] args) {
        NumberOfWays2Arrive0InALoop obj = new NumberOfWays2Arrive0InALoop();
        int res = obj.solution(102, 12);
        System.out.println(res);
    }

    //n个点,从0走k步 ,到达0一共多少种走法
    private int solution(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 && k == 0) {
            if (k == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (n == 2) {
            if (k % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int[][] dp = new int[n][k + 1];

        //dp[i][j]means the starting position is i, steps is j, the number of ways to finally get to 0
        //从0 走 0步 到0
        dp[0][0] = 1;
        //从非0 走 0步 到0
        for (int i = 1; i < n; i++) {
            dp[i][0] = 0;
        }
        //dp[i][j] = dp[(n + i - 1) % n][j - 1] + dp[(i + 1) % n][j - 1];
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i < n; i++) {
                dp[i][j] = dp[(n + i - 1) % n][j - 1] + dp[(i + 1) % n][j - 1];
            }
        }

        return dp[0][k];
    }
}
