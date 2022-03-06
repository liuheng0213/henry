package basic.knowledge.stephen.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {



    public static void main(String[] args) {

        int[] A= new int[]{3, 0, 5};
        int resul = solution(A);
        System.out.println(resul);

    }


    public static int solution(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        // write your code in Java SE 8
        PriorityQueue<Double> pq = new PriorityQueue<>(new Comparator<Double>(){
            @Override
            public int compare(Double o1,Double o2){
                return (int)(o2-o1);
            }
        });

        Double sumPollution = new Double(0);
        for(int i = 0;i< A.length;i++){
            Double ab = Double.valueOf(A[i]);
            pq.add(ab);
            sumPollution+=A[i];
        }


        Double halfPollution = sumPollution/2;
        int result = 0;
        Double deductedPollution = 0.0;
        while(deductedPollution.compareTo(halfPollution) < 0){
            Double d = pq.poll();

            Double newd = d/2;
            deductedPollution += d-newd;
            pq.add(newd);
            result++;

        }

        return result;




    }



}
