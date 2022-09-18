package basic.knowledge.henry.algorithm.leetcode.graph.dfs;

public class Leetcode2245 {

    public static void main(String[] args) {
        Leetcode2245 leetcode2245 = new Leetcode2245();
        int[][] grid = new int[][]{{23, 17, 15, 3, 20}, {8, 1, 20, 27, 11}, {9, 4, 6, 2, 21}, {40, 9, 1, 10, 6}, {22, 7, 4, 5, 3}};
        int i = leetcode2245.maxTrailingZeros(grid);
        System.out.println(i);


    }

    public int maxTrailingZeros(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                int zeroes = genTrailing(grid[i][j]);

                int tempMax = process(grid, i + 1, j, grid[i][j], zeroes, "d", false);
                max = Math.max(max, tempMax);
                tempMax = process(grid, i, j + 1, grid[i][j], zeroes, "r", false);
                max = Math.max(max, tempMax);
                tempMax = process(grid, i - 1, j, grid[i][j], zeroes, "u", false);
                max = Math.max(max, tempMax);
                tempMax = process(grid, i, j - 1, grid[i][j], zeroes, "l", false);
                max = Math.max(max, tempMax);
            }
        }
        return max;
    }

    private int genTrailing(int ele) {
        String eleStr = String.valueOf(ele);
        int i = eleStr.length() - 1;

        int res = 0;
        while (i >= 0 && eleStr.charAt(i) == '0') {
            i--;
            res++;
        }

        return res;
    }

    private int process(int[][] grid, int i, int j, int product, int zeroes, String dir, boolean changed) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return zeroes;
        }

        product = product * grid[i][j];

        int trailing = genTrailing(product);
        int max = trailing;
        if (!changed) {
            if (dir.equals("d")) {
                max = Math.max(process(grid, i, j + 1, product, max, "r", true), max);
                max = Math.max(process(grid, i, j - 1, product, max, "l", true), max);
//                max = Math.max(process(grid, i - 1, j, product, max, "u", true), max);
            } else if (dir.equals("r")) {
//                max = Math.max(process(grid, i, j - 1, product, max, "l", true), max);
                max = Math.max(process(grid, i - 1, j, product, max, "u", true), max);
                max = Math.max(process(grid, i + 1, j, product, max, "d", true), max);
            } else if (dir.equals("l")) {
//                max = Math.max(process(grid, i, j + 1, product, max, "r", true), max);
                max = Math.max(process(grid, i - 1, j, product, max, "u", true), max);
                max = Math.max(process(grid, i + 1, j, product, max, "d", true), max);
            } else {
                max = Math.max(process(grid, i, j + 1, product, max, "r", true), max);
                max = Math.max(process(grid, i, j - 1, product, max, "l", true), max);
//                max = Math.max(process(grid, i + 1, j, product, max, "d", true), max);
            }
        }

        if (dir.equals("d")) {
            max = Math.max(max, process(grid, i + 1, j, product, max, dir, changed));
        } else if (dir.equals("u")) {
            max = Math.max(max, process(grid, i - 1, j, product, max, dir, changed));
        } else if (dir.equals("l")) {
            max = Math.max(max, process(grid, i, j - 1, product, max, dir, changed));
        } else {
            max = Math.max(max, process(grid, i, j + 1, product, max, dir, changed));
        }


        return max;

    }

}
