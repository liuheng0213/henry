package basic.knowledge.henry.algorithm.InterviewExperience.canva;

public class LongestSubArray {
    public static void main(String[] args) {
        LongestSubArray longestSubArray = new LongestSubArray();
        int len = longestSubArray.solution(new int[]{1, 2, 1, -2, 2, -1, 2}, 4);
        System.out.println(len);
    }

    private int solution(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        while (right < arr.length) {
            sum += arr[right];
            if (sum <= k) {
                max = Math.max(max, right - left + 1);
            }
            while (sum > k) {
                sum -= arr[left];
                left++;
            }
            right++;
        }

        return max;
    }
}
