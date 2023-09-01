package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

//求两个字符串共同的序列
public class _09LongsetCommonSubSet_DP {
    public static void main(String[] args) {
        _09LongsetCommonSubSet_DP longsetCommonSubSet = new _09LongsetCommonSubSet_DP();
        String str1 = "1A2C3D4B56７";
        String str2 = "B1D23CA45B6A";
        String res = longsetCommonSubSet.solution(str1, str2);
        System.out.println(res);
    }

    private String solution(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = new int[m][n];

        dp[0][0] = chs1[0] == chs2[0] ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = chs1[i] == chs2[0] ? 1 : Math.max(0, dp[i - 1][0]);
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = chs1[0] == chs2[j] ? 1 : Math.max(0, dp[0][j - 1]);
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (chs1[i] == chs2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        m = chs1.length - 1;
        n = chs2.length - 1;

        int resLen = dp[m][n];
        char[] res = new char[resLen];
        int index = resLen - 1;
        while (m > 0 || n > 0) { //或者index >= 0
            if (chs1[m] == chs2[n]) {
                res[index--] = chs1[m];
                m--;
                n--;
            } else {
                if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                    m--;
                } else if (n > 0) {
                    n--;
                }
            }
        }

        //出来时 必有 m== 0 && n == 0

        return new String(res);
    }

}
