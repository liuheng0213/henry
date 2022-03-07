package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

//最大子矩形大小
public class _09MaxSubMatrix {
    public int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;

        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, maxRefFromBottom(height));
        }

        return maxArea;

    }

    private int maxRefFromBottom(int[] height) {
        //todo  if
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                int j = stack.pop();
                int k = stack.isEmpty()? -1 : stack.peek();
                int curArea = height[j] * (i - 1 - k -1 + 1);
                maxArea = Math.max(maxArea,curArea );
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty()? -1 : stack.peek();
             int curArea = height[j] * (height.length - 1 - k -1 + 1);
            maxArea = Math.max(maxArea,curArea );
        }

        return maxArea;
    }
}
