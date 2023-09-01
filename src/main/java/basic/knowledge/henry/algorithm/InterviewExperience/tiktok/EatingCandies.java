package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

// 你有一组糖果重量和两个人。 一个从左边吃，另一个从右边吃。 他们可以吃多少糖果才能拥有相同的体重？
public class EatingCandies {
    public static void main(String[] args) {
        EatingCandies obj = new EatingCandies();
        int[] candies = new int[]{2,1,4,2,4,1};
        int res = obj.solution(candies);
        System.out.println(res);
    }

    private int solution(int[] candies) {
        int sum1 = 0;
        int sum2 = 0;
        int num = 2;
        int res = 0;
        int i = 0;
        int j = candies.length - 1;
        sum1 += candies[i];
        sum2 += candies[j];
        while (i < j) {
            if (sum1 == sum2) {
                res = Math.max(num, res);
                i++;
                j--;
                sum1 += candies[i];
                sum2 += candies[j];
                num += 2;
            } else if (sum1 < sum2) {
                i++;
                sum1 += candies[i];
                num++;
            } else {
                j--;
                sum2 += candies[j];
                num++;
            }
        }

        return res;
    }
}
