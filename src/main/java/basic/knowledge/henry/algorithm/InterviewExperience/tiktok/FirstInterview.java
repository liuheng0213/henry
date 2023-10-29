package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

import basic.knowledge.henry.algorithm.algorithm_4_Edition.entity.User;

import java.util.ArrayList;
import java.util.List;

public class FirstInterview {
    public static void main(String[] args) {
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
