package basic.knowledge.henry.algorithm;

import java.util.*;

public class CanvaTest {
    public static Integer EMPTY = 0;
    public static Integer UNPOPULATED = -1;
    public static Integer POPULATED = 1;

    public int[][] dirs = new int[][]{{-1, 1}, {0, 1}, {1, 1}, {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public static void main(String[] args) {

        int[][] cells = new int[6][5];
        cells[1][2] = 1;
        System.out.println(Arrays.deepToString(cells));
        System.out.println("===========================");
        cells[2][1] = -1;
        cells[2][3] = 1;
        cells[3][1] = 1;
        cells[3][2] = 1;
        cells[3][3] = 1;
        cells[4][1] = 1;
        CanvaTest canvaTest = new CanvaTest();


        System.out.println(Arrays.deepToString(cells));
        canvaTest.solution(cells);
        System.out.println("===========================");
        System.out.println(Arrays.deepToString(cells));
        canvaTest.solution(cells);
        System.out.println("===========================");
        System.out.println(Arrays.deepToString(cells));
    }

    private void solution(int[][] cells) {
        int m = cells.length;
        int n = cells[0].length;
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                storeState(i, j, cells, map);
            }
        }
        //changeState
        Iterator<int[]> iterator = map.keySet().iterator();

        while(iterator.hasNext()){
            int[] key = iterator.next();
            cells[key[0]][key[1]] = map.get(key);
        }


    }


    private void storeState(int i, int j, int[][] cells, Map<int[], Integer> map) {
        int count = 0;
        for (int k = 0; k < dirs.length; k++) {
            int in = i + dirs[k][0];
            int jn = j + dirs[k][1];
            if(in < 0 || in > cells.length - 1 || jn < 0 || jn > cells[0].length - 1){
                continue;
            }
            if (cells[in][jn] == POPULATED) {
                count++;
            }
        }

        if (cells[i][j] == POPULATED) {
            if (count <= 1 || count >= 4) {
                map.put(new int[]{i, j}, UNPOPULATED);
            }
        } else { // EMPTY || UNPOPULATED
            if (count == 3) {
                map.put(new int[]{i, j}, POPULATED);
            }
        }
    }


}
