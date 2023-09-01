package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;


import java.util.Arrays;
import java.util.Comparator;

//给一个整数n，给一个数组nums，找到nums中排列组合数比n大的数中最小的数字。比如n=22 num={2，1}
public class MinCombinationNumber {
    int res = -1;
    boolean find = false;

    public static void main(String[] args) {
        MinCombinationNumber obj = new MinCombinationNumber();

        Integer[] arr = new Integer[]{2,4,9};
        int num = 23121;
        int res = obj.solution(arr, num);
        System.out.println(res);
    }

    private int solution(Integer[] arr, int num) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr,(a,b)->b-a);
        backTrack(arr, num, sb);
        return res;
    }

    private void backTrack(Integer[] arr, int num, StringBuilder sb) {
        int combinedNum = sb.length() == 0 ? Integer.MAX_VALUE : Integer.parseInt(sb.toString());
        if (combinedNum < num) {
            res = combinedNum;
            find = true;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!find) {
                sb.append(arr[i]);
                backTrack(arr, num, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
