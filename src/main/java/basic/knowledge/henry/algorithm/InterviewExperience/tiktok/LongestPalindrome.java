package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

//最长回文子串
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();
        String res = obj.soultion("ccc");
        System.out.println(res);
    }

    private String soultion(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i > 0) {
                dp[i - 1][i] = str.charAt(i - 1) == str.charAt(i) ? 2 : 1;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (i + 1 == j - 1) {
                        dp[i][j] = 3;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] >= 2 ? dp[i + 1][j - 1] + 2 : 1;
                    }
                }else{
                    dp[i][j] = 1;
                }
            }
        }

        int maxLen = 0;
        int end = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    end = j;
                }
            }
        }

        return str.substring(end - maxLen + 1, end + 1);
    }
}
