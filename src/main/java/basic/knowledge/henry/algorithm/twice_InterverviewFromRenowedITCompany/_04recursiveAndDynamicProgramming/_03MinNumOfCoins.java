package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//组成零钱总数的最小钞票数, -1表示找不到组合.
public class _03MinNumOfCoins {
    public int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }

        return process(arr, 0, aim);
    }

    private int process(int[] arr, int i, int aim) {
        if (i == arr.length) {
            return aim == 0 ? 0 : -1;
        }

        int res = -1;
        for (int k = 0; k * arr[i] <= aim; k++) {
            int next = process(arr, i + 1, aim - k * arr[i]);
            if (next != -1) {
                res = res == -1 ? next + k : Math.min(next + k, res);
            }
        }
        return res;
    }

}
