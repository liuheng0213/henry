package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

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
        return 0;
    }
}
