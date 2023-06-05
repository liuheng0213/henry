package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//组成零钱总数的最小钞票数, -1表示找不到组合.
public class _03MinNumOfCoins {
    public static void main(String[] args) {
        _03MinNumOfCoins minNumOfCoins = new _03MinNumOfCoins();
        int[] arr = {5, 2, 3, 10, 15};
        int aim = 20;
        int res = minNumOfCoins.solution_1(arr, aim);
        System.out.println(res);
    }

    private int solution_1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 1) {
            return -1;
        }

        return process(arr, 0, aim);
    }

    private int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest != 0 ? -1 : 0;
        }

        int res = -1;
        for (int k = 0; k * arr[index] <= rest; k++) {
            int next = process(arr, index + 1, rest - k * arr[index]);
            if (next != -1) {
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }

        return res;
    }
}
