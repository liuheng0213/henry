package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leetcode218 {
    public static void main(String[] args) {
        Leetcode218 sol = new Leetcode218();
        int[][] buildings = {
                {2, 9, 10}
//                {3, 7, 15},
//                {5, 12, 12},
//                {15, 20, 10},
//                {19, 24, 8}
        };
        List<List<Integer>> result = sol.getSkyline(buildings);
        for (List<Integer> point : result) {
            System.out.println(point);
        }
    }


    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> tmp = new ArrayList<>();

        for (int[] build : buildings) {
            int l = build[0], r = build[1], h = build[2];
            int lhigh = h, rhigh = 0;
            for (int[] t : buildings) {
                if (t[0] <= l && l < t[1]) {
                    lhigh = Math.max(lhigh, t[2]);
                }
                if (t[0] <= r && r < t[1]) {
                    rhigh = Math.max(rhigh, t[2]);
                }
            }
            List<Integer> left = new ArrayList<>();
            left.add(l);
            left.add(lhigh);
            tmp.add(left);
            List<Integer> right = new ArrayList<>();
            right.add(r);
            right.add(rhigh);
            tmp.add(right);
        }

        Collections.sort(tmp, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                return Integer.compare(a.get(0), b.get(0));
            }
        });

        int y = -1; // Current y coordinate
        for (List<Integer> d : tmp) {
            if (d.get(1) == y) continue;
            ans.add(d);
            y = d.get(1);
        }

        return ans;
    }
}
