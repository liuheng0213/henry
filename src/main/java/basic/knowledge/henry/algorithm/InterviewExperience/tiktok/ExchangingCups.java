package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;


import java.util.Arrays;
import java.util.HashMap;

//您有一个从 1 到 N 的未排序数组，您需要找到对它进行排序的最小交换次数。 O(N logN) 解。
public class ExchangingCups {
    public static void main(String[] args) {
        ExchangingCups obj = new ExchangingCups();
        int res = obj.solution(new int[]{1, 4, 3, 2});
        System.out.println(res);
    }

    private int solution(int[] arr) {
        int[] copied = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copied);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int count = 0;
        for (int i = 0; i < copied.length; i++) {
            if(copied[i] != arr[i]){
                int j = map.get(copied[i]);
                count++;
                swap(copied,i,j);
            }
        }

        return count;
    }

    private void swap(int[] copied, int i, int j) {
        int tmp = copied[i];
        copied[i] = copied[j];
        copied[j] = tmp;
    }
}
