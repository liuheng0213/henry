package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk;

public class Leetcode322 {
    public int coinChange_dp(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];

        dp[coins.length][0] = 0;
        for(int j =1;j< amount+1;j++ ){
            dp[coins.length][j] = -1;
        }

        for(int i = coins.length - 1;i>=0;i--){
            for(int j = 0;j< amount+1;j++){
                dp[i][j] = -1;
                for(int k =0;k* coins[i]<= j;k++){
                    if(dp[i +1][j - k * coins[i]] != -1){
                        dp[i][j] = dp[i][j] == -1? k + dp[i +1][j- k * coins[i]] : Math.min(dp[i][j],k + dp[i +1][j- k * coins[i]]);
                    }
                }
            }
        }

        return dp[0][amount];
    }


    public int coinChange(int[] coins, int amount) {
        return helper(0,coins,amount);
    }

    private int helper(int idx,int[] coins,int amount){
        if(idx == coins.length){
            if(amount == 0){
                return 0;
            }else {
                return -1;
            }
        }
        int res = -1;
        for(int k = 0; k * coins[idx] <= amount;k++){
            int next = helper(idx+1,coins,amount - k * coins[idx]);
            if(next != -1){
                if(res == -1){
                    res = k+next;
                }else{
                    res = Math.min(res,k+next);
                }
            }
        }

        return res;
    }
}
