package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;

public class lc741CherryPickUp {
    public static void main(String[] args) {
        lc741CherryPickUp lc741CherryPickUp = new lc741CherryPickUp();
        int[][] grid = new int[][]{{0,1,-1}, {1,0,-1}, {1,1,1}};
        lc741CherryPickUp.cherryPickup(grid);
    }


    //tle
    int max = 0;

    public int cherryPickup(int[][] grid) {
        TopToBottom(grid, 0, 0, 0);
        return max;
    }

    public void TopToBottom(int[][] grid, int i, int j, int totalCount) {
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
            return;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            bottomUp(grid, i, j, totalCount);
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        TopToBottom(grid, i + 1, j, totalCount + temp);
        TopToBottom(grid, i, j + 1, totalCount + temp);
        grid[i][j] = temp;
    }

    public void bottomUp(int[][] grid, int i, int j, int totalCount) {
        if (i < 0 || j < 0 || grid[i][j] == -1) {
            return;
        }
        if (i == 0 && j == 0) {
            totalCount += grid[i][j];
            max = Math.max(max, totalCount);
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        bottomUp(grid, i - 1, j, totalCount + temp);
        bottomUp(grid, i, j - 1, totalCount + temp);
        grid[i][j] = temp;
    }
}
