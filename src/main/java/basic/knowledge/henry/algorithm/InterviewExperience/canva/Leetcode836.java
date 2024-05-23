package basic.knowledge.henry.algorithm.InterviewExperience.canva;

public class Leetcode836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        boolean notOverlapped_X = rec1[0] >= rec2[2] || rec1[2] <= rec2[0];
        boolean notOverlapped_Y = rec1[1] >= rec2[3] || rec1[3] <= rec2[1];

        return !notOverlapped_X && !notOverlapped_Y;

    }


}
