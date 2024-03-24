package basic.knowledge.henry.algorithm.InterviewExperience.canva;

import java.util.HashSet;

public class Leetcode681 {
    public static void main(String[] args) {
        Leetcode681 leetcode681 = new Leetcode681();
        String s = leetcode681.nextClosestTime("00:00");
        System.out.println(s);
    }
        public String nextClosestTime(String time) {
            int[] times = new int[4];
            HashSet<Integer> set = new HashSet<>();
            int idx  = 0;
            for(int i =0;i< time.length();i++){
                if(time.charAt(i) != ':'){
                    times[idx++] = time.charAt(i) - '0';
                    set.add(time.charAt(i) - '0');
                }
            }


            int[] closest = oneMinuteIncrement(times);
            while(!isIncluded(set,closest)){
                System.out.println("closest " + closest[0] + closest[1] + ": " +closest[2] + closest[3]);
                closest = oneMinuteIncrement(closest);
            }

            String res = "";
            for(int i =0;i< closest.length;i++){
                res+= closest[i];
                if(i == 1){
                    res+= ":";
                }
            }
            return res;


        }

        private int[] oneMinuteIncrement(int[] times){
            times[3]++;
            if(times[3] != 10){
                return times;
            }
            times[3] = 0;
            times[2]++;

            if(times[2] != 6){
                return times;
            }

            times[2] = 0;
            times[1]++;

//            if(times[0] == 2 && times[1] == 4){
//                times[0] = times[1] = 0;
//            }
//
//            if(times[1] != 10) return times;
//
//            times[1] = 0;
//            times[0]++;
//
//            return times;

             if(times[0] == 1 && times[1] != 10){
                 return times;
             }else if(times[0] == 1 && times[1] == 10){
                 times[0]++;
                 times[1] = 0;
                 return times;
             }else if(times[0] ==2 && times[1] == 4){
                 times[0] = 0;
                 times[1] = 0;
                 return times;
             }else if(times[0] == 0&& times[1] == 10){
                 times[0]++;
                 times[1] = 0;
                 return times;
             }else if(times[0] == 0&& times[1] != 10){
                 return times;
             }
             return times;
        }

        private boolean isIncluded(HashSet<Integer> set,int[] arr){
            for(int n: arr){
                if(!set.contains(n)){
                    return false;
                }
            }
            return true;
        }



}
