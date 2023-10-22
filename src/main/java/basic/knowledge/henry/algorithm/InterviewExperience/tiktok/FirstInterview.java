package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

import java.util.ArrayList;
import java.util.List;

public class FirstInterview {
    public static void main(String[] args) {
//        ArrayList<Integer>[] list = new ArrayList[3];
//        FirstInterview firstInterview = new FirstInterview();
////        System.out.println(String.valueOf(-6));
//        int[][] arr = new int[][]{{2, 3}, {-6, 10}, {8, 16}, {-5, 6}};
//        String str = firstInterview.solution(arr);
//        System.out.println(str);

        String s = counterGame(6);
        System.out.println(s);
    }

    public static String counterGame(long n) {
        // Write your code here
        return counterGame(n,0);

    }

    private static String counterGame(long n,int k){
        if(n == 1){
            if(k % 2 == 0){
                return "Richard";
            }else{
                return "Louise";
            }
        }

        long[] arr = findNextNumber(n);
        if(arr[0] == 1){
            n = n/2;
        }else{
            n -= arr[1];
        }
        return counterGame(n,k+1);
    }

    public static long[] findNextNumber(long num){
        long p = (long) (Math.log(num) / Math.log(2));
        if(Math.pow(2,p)== num){
            return new long[]{1,p};
        }else{
            return new long[]{0,(long)Math.pow(2,p)};
        }
    }

    private String solution(int[][] arr) {
        int[] pre = arr[0];
        int num = pre[0];
        int deno = pre[1];
        for (int i = 1; i < arr.length; i++) {
            int[] cur = arr[i];
            int cur_num = cur[0];
            int cur_deno = cur[1];
            int lcm_deno = lcm(deno, cur_deno);
            num = num * lcm_deno / deno + cur_num * lcm_deno / cur_deno;
            deno = lcm_deno;
            int gcd = gcd(num < 0 ? 0 - num : num, deno);
            num /= gcd;
            deno /= gcd;
        }
        int gcd = gcd(num < 0 ? 0 - num : num, deno);
        String res = "";
        res += String.valueOf(num / gcd);
        res += "/";
        res += String.valueOf(deno / gcd);
        return res;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


}
