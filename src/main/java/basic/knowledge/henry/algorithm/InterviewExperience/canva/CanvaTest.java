package basic.knowledge.henry.algorithm.InterviewExperience.canva;

import java.util.*;

public class CanvaTest {
    public static Integer EMPTY = 0;
    public static Integer UNPOPULATED = -1;
    public static Integer POPULATED = 1;
    Map<String, Integer> map = new HashMap<>();
    public int[][] dirs = new int[][]{{-1, 1}, {0, 1}, {1, 1}, {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    int[][] cells = new int[6][5];
    public static void main(String[] args) {



        CanvaTest canvaTest = new CanvaTest();


        System.out.println(Arrays.deepToString(canvaTest.cells));
        canvaTest.nextStep();
        System.out.println("===========================");
        System.out.println(Arrays.deepToString(canvaTest.cells));
        canvaTest.nextStep();
        System.out.println("===========================");
        System.out.println(Arrays.deepToString(canvaTest.cells));
    }

    public CanvaTest(){
        int m = cells.length;
        int n = cells[0].length;

        cells[1][2] = 1;
        System.out.println(Arrays.deepToString(cells));
        System.out.println("===========================");
        cells[2][1] = -1;
        cells[2][3] = 1;
        cells[3][1] = 1;
        cells[3][2] = 1;
        cells[3][3] = 1;
        cells[4][1] = 1;


    }

    private void nextStep() {
        for(int i =0;i< cells.length;i++){
            for(int j =0;j< cells[0].length;j++){
                changeState(i,j);
            }
        }


        //changeState
        Iterator<String> iterator = map.keySet().iterator();

        while(iterator.hasNext()){
            String key = iterator.next();
            cells[key.charAt(0) - '0'][key.charAt(2) - '0'] = map.get(key);
        }


    }


    private void changeState(int i, int j) {
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
                map.put(i + "_" + j, UNPOPULATED);
            }
        } else {  //UNPOPULATED empty
            if (count == 3) {
                map.put(i + "_" + j, POPULATED);
            }
        }

    }


}
