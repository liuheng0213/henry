package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

import java.math.BigInteger;

public class String2Integer {
    public static void main(String[] args) {
        String2Integer obj = new String2Integer();
        int i = obj.myAtoi(" words and 987");
    }
    public int myAtoi(String s) {
        s = s.trim();
        String[] strs = s.split(" ");

        for(int i = 0;i< strs.length;i++){
            int[] arr = check(strs[i].trim());
            if(arr[0] == 1){
                return arr[1];
            }

        }

        return 0;

    }

    private int[] check(String str){
        char[] chs = str.toCharArray();
        boolean neg = false;
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i< chs.length;i++){
            if(chs[i] == '+'){
                neg = false;
            }else if(chs[i] == '-'){
                neg = true;
            }else if(Character.isDigit(chs[i])){
                sb.append(chs[i]);
            }else {
                return new int[]{0,100};
            }
        }

        long res = 0;
        int di = 1;
        for(int i = sb.length() - 1;i>=0;i--){
            res += (sb.charAt(i) - '0') * di ;
            di *= 10;
        }

        if(neg){
            res = 0 - res;
        }
        if(res < (long)Integer.MIN_VALUE){
            res = Integer.MIN_VALUE;
        }else if(res >(long)Integer.MAX_VALUE){
            res = Integer.MAX_VALUE;
        }
        return new int[]{1,(int)res};
    }
}
