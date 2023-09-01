package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;


//倒酒  ，酒杯第一层一个，第二层两个第三层三个...倒入n杯酒，求第n行m列的酒杯里的酒有多少？
public class ChampagneTower {
    public static void main(String[] args) {
        ChampagneTower obj = new ChampagneTower();
        double v = obj.champagneTower(100000009, 33, 17);
        System.out.println(v);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] triangle = new double[query_row + 1][query_glass + 2];
        triangle[0][0] = poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= query_glass; j++) {
                double rest = Math.max(triangle[i][j] - 1.0, 0);
                triangle[i+1][j] += rest / 2.0;
                triangle[i+1][j+1] += rest / 2.0;
            }
        }

        return Math.min(triangle[query_row][query_glass], 1.0);
    }
}
