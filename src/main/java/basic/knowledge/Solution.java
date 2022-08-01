package basic.knowledge;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Definition of Interval:
 * public classs Interval {
 * int start, end;
 * Interval(int start, int end) {
 * this.start = start;
 * this.end = end;
 * }
 * }
 */

public class Solution {


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(Math.pow(2,3));
        System.out.println(Integer.toBinaryString(3&2));
        int[] rolls = {4,2,1,2,3,3,2,4,1};
        int[] rolls1 = {4,2,1,2,3,3,2,4,1};
        int i = Integer.bitCount(536870911);
        int k = 4;

        Solution solution = new Solution();
        long l = solution.minMeetingRooms(new int[][]{{15,20},{0,30},{5,10}});
//        long e = solution.largestVariance("abbb");
        System.out.println(l);
    }

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        //Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->{
            return o1[1] - o2[1];
        });
        queue.offer(intervals[0]);
        for(int i = 1;i < intervals.length;i++){
            int[] cur = queue.poll();
            if(intervals[i][0]>=cur[1]){
                cur = intervals[i];
            }else{
                queue.offer(intervals[i]);
            }
            queue.offer(cur);
        }
        return queue.size();
    }

    public int largestVariance(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()){
            set.add(ch);
        }


        int max = 0;
        for(char c1 : set){
            for(char c2 : set){

                if(c1 == c2)
                {
                    continue;
                }
                int c1Freq=0, c2Freq=0;

                for(char c : s.toCharArray()){
                    if(c == c1){
                        c1Freq++;
                    }
                    if(c == c2){
                        c2Freq++;
                    }

                    if(c1Freq > 0 && c2Freq > 0){
                        max = Math.max(max, Math.abs(c2Freq-c1Freq));
                    }

                    if(c2Freq < c1Freq){
                        c2Freq = 0;
                        c1Freq = 0;
                    }
                }
            }
        }
        return max;

    }



}
