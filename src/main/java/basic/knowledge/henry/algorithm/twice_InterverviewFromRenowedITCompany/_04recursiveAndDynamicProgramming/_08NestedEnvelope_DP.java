package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 类似最长递增子序列
 * 合理排序  可形成宽度满足最长子序列条件 长度必定满足条件
 */
public class _08NestedEnvelope_DP {
    public static void main(String[] args) {
        _08NestedEnvelope_DP envelopeDp = new _08NestedEnvelope_DP();
        int[][] arr = new int[][]{{3, 4}, {2, 3}, {4, 5}, {1, 3}, {2, 2}, {3, 6}, {1, 2}, {3, 2}, {2, 4}};
        int res = envelopeDp.solution(arr);
        System.out.println(res);
    }

    private int solution(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);

        int n = arr.length;
        int[] widths = new int[n];
        for (int i = 0; i < n; i++) {
            widths[i] = arr[i][1];
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (widths[i] > widths[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
