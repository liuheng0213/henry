package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _01Fibonacci {
    public static void main(String[] args) {
        _01Fibonacci fibonacci = new _01Fibonacci();
        int res = fibonacci.solution_1(23);
        int res1 = fibonacci.solution_2(23);
        System.out.println(res == res1);
        System.out.println(res1);
    }

    public int solution_2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3;i< dp.length;i++){
            dp[i] = dp[i - 1] + dp[i -2];
        }

        return dp[n];
    }

    public int solution_1(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return solution_1(n - 1) + solution_1(n - 2);
    }
}
