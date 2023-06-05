package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _05MethodOfMoneyChange {
    public static void main(String[] args) {
        _05MethodOfMoneyChange methodOfMoneyChange = new _05MethodOfMoneyChange();
        int[] arr = new int[]{5, 10, 25, 1, 100, 50, 20};
        int aim = 180;
        int res = methodOfMoneyChange.solution(arr, aim);
        System.out.println(res);
    }

    private int solution(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        //return process2(arr, arr.length - 1, aim);
        return process(arr, 0, aim);
    }

    private int process(int[] arr, int index, int aim) {
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }

        int res = 0;
        //i represent numbers of arr[index]
        for (int i = 0; arr[index] * i <= aim; i++) {
            res += process(arr, index + 1, aim - arr[index] * i);
        }

        return res;
    }


}
