package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

//打起球的最大分数
public class _06MaxScoreOfChargingBalloon {

    public static void main(String[] args) {
        _06MaxScoreOfChargingBalloon chargingBalloon = new _06MaxScoreOfChargingBalloon();
        int[] arr = new int[]{3, 2, 5, 6};
        int res = chargingBalloon.solution(arr);
        System.out.println(res);
    }

    private int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] help = new int[arr.length + 2];
        help[0] = 1;
        help[arr.length + 1] = 1;
        for (int i = 1; i < arr.length + 1; i++) {
            help[i] = arr[i - 1];
        }
        return process(help, 1, arr.length);
    }

    private int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l - 1] * arr[l] * arr[r + 1];
        }

        int max = Math.max(arr[l - 1] * arr[l] * arr[r + 1] + process(arr, l + 1, r),
                arr[l - 1] * arr[r] * arr[r + 1] + process(arr, l, r - 1));


        for (int i = l + 1; i <= r - 1; i++) {
            max = Math.max(max, process(arr, l, i - 1) + arr[l - 1] * arr[i] * arr[r + 1] + process(arr, i + 1, r));
        }

        return max;
    }

}
