package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _05MethodOfMoneyChange {


    public static void main(String[] args) {
        _05MethodOfMoneyChange methodOfMoneyChange = new _05MethodOfMoneyChange();
        int[] arr = new int[]{5, 10, 25, 1, 100, 50};
        int methods = methodOfMoneyChange.coin1(arr, 35);
        System.out.println(methods);
    }



    public int coin1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        return process(arr, 0, aim);
    }

    private int process(int[] arr, int i, int aim) {
        if (i == arr.length) {
            return aim == 0 ? 1 : 0;
        }

        int res = 0;
        for (int k = 0; k * arr[i] <= aim; k++) {
            int next = process(arr,i+ 1 ,aim- k * arr[i]);
            res+=next;
        }

        return res;
    }

}
