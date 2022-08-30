package basic.knowledge;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int abc = solution.minMeetingRooms(new int[][]{{13,15},{1,13}});
//        String dd = solution.shiftingLetters("abc",new int[][]{{0,1,0},{1,2,1},{0,2,1}});


    }

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        List<int[]> list  = new ArrayList<>();
        for(int[] interval: intervals){
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }
        Collections.sort(list,(a, b)-> a[0]==b[0]?a[1] - b[1] : a[0] - b[0]);
        int res = 0;
        int count = 0;
        for(int[] point : list){
            count+=point[1];
            res = Math.max(res,count);
        }

        return res;

    }


//    public String shiftingLetters(String s, int[][] shifts) {
//
//        List<int[]> list  = new ArrayList<>();
//        for(int i = 0;i<shifts.length;i++ ){
//
//            if(shifts[i][2] == 1){
//                list.add()
//                pre[shifts[i][0]] = pre[shifts[i][0]] + 1;
//                pre[shifts[i][1] + 1] = pre[shifts[i][1] + 1] - 1;
//            }else{
//                pre[shifts[i][0]] = pre[shifts[i][0]] - 1;
//                pre[shifts[i][1] + 1] = pre[shifts[i][1] + 1] + 1;
//            }
//
//        }
//        // Array.sort(pre,(a,b)-> a[0]==b[0]?a[1] - b[1] : a[0] - b[0]);
//        int temp =0;
//        char[] ch = s.toCharArray();
//        for(int i = 0;i < pre.length - 1;i++){
//            temp = temp + pre[i];
//            int newChar = ((ch[i] - 'a') + temp) % 26;
//            newChar = newChar < 0 ? newChar + 26 : newChar;
//            ch[i] = (char)('a' + newChar);
//        }
//
//        return new String(ch);
//    }

}
