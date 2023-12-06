package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;

import java.util.Arrays;

public class lc1048StringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for(int i = 1;i< n;i++){
            dp[i] = 1;
            for(int j = 0;j< i;j++){
                boolean isPre = isPre(words[j],words[i]);
                if(isPre){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }

            }
            res = Math.max(res,dp[i]);
        }

        return res;
    }

    private boolean isPre(String str1,String str2){
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        if(chs1.length + 1 != chs2.length){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i< chs1.length){
            while(j< chs2.length && chs2[j] != chs1[i]){
                j++;
            }
            if(j == chs2.length){
                break;
            }else{
                i++;
                j++;
            }

        }
        return i == chs1.length;

    }
}
