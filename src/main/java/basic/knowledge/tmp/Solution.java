package basic.knowledge.tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        HashSet<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(2, 3));
        set.add(Arrays.asList(2, 3));
        List<Integer>[] adjList = new ArrayList[1];
        Solution solution = new Solution();
        int[][] grid = new int[][]{{6, 2, 1, 3}, {4, 2, 1, 5}, {9, 2, 8, 7}, {4, 1, 2, 9}};
        int i = solution.maxSum(grid);
        System.out.println(i);

    }

    int[][] surrounds = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 0}, {1, -1}, {1, 0}, {1, 1}};
    int[][] dirs = new int[][]{{1, 0}, {0, 1}};
    int res = Integer.MIN_VALUE;

    public int maxSum(int[][] grid) {
        HashSet<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(0, 0));
        bfs(set, grid, 0, 0);

        return res;
    }


    private void bfs(HashSet<List<Integer>> set, int[][] grid, int i, int j) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            System.out.println(Arrays.toString(cur));
            res = Math.max(res, getSum(grid, cur[0], cur[1]));
            for (int[] dir : dirs) {
                int newI = cur[0] + dir[0];
                int newJ = cur[1] + dir[1];
                if (newI < 0 || newI > grid.length - 1 || newJ < 0 || newJ > grid[0].length - 1 || set.contains(Arrays.asList(newI,newJ))) {
                    continue;
                }
                set.add(Arrays.asList(newI,newJ));
                queue.addLast(new int[]{newI, newJ});
            }
        }
    }

    private int getSum(int[][] grid, int i, int j) {
        int sum = 0;

        for (int[] s : surrounds) {
            int newI = i + s[0];
            int newJ = j + s[1];
            if (newI < 0 || newI > grid.length - 1 || newJ < 0 || newJ > grid[0].length - 1) {
                return 0;
            }
            sum += grid[newI][newJ];
        }

        return sum;
    }

}
