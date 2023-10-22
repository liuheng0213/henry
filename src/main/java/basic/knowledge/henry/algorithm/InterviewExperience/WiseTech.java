package basic.knowledge.henry.algorithm.InterviewExperience;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/699973/Goldman

public class WiseTech {
    static int no_used = -1;
    static int exit = 1;
    static int enter = 0;
    public static void main(String[] args) {
        WiseTech wiseTech = new WiseTech();
        List<Integer> time = new ArrayList<>();
        time.add(0);
        time.add(0);
        time.add(1);
        time.add(5);

        List<Integer> direction = new ArrayList<>();
        direction.add(0);
        direction.add(1);
        direction.add(1);
        direction.add(0);

        // answer : 2 0 1 5
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        rotateLeft(4,arr);


    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        for(int i = 0;i< d;i++){
            arr.add(arr.get(i));
        }

        for(int i = 0;i< arr.size();i++){
            System.out.println(arr.get(i));
        }
        System.out.println("================");
        for(int i = 0;i< d;i++){
            arr.remove(i);
        }

        return arr;
    }

    public List<Integer> solution(List<Integer> time,List<Integer> direction){
//        for(){
//
//        }

        return null;
    }

    static class Turnstile{
        long action_time;
        int status;

        Queue<Integer> exQueue;

        Queue<Integer> enQueue;


        public Turnstile(long action_time, int status, Queue<Integer> exQueue, Queue<Integer> enQueue) {
            this.action_time = action_time;
            this.status = status;
            this.exQueue = exQueue;
            this.enQueue = enQueue;
        }
    }

}
