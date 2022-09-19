package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

public class _07MonontousStack {
    public int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i< arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                int pop = stack.pop();
                res[pop][0] = stack.isEmpty()? -1 : stack.peek();
                res[pop][1] = i;

            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int pop = stack.pop();
            res[pop][0] = stack.isEmpty()? -1 : stack.peek();
            res[pop][1] = -1;
        }

        return res;
    }


}
