package basic.knowledge.henry.algorithm.InterviewExperience.canva.pq;

import java.util.PriorityQueue;

public class MediumNumberStream {
    PriorityQueue<Integer> minPQ = null;
    PriorityQueue<Integer> maxPQ = null;

    public MediumNumberStream() {
        minPQ = new PriorityQueue<>((a,b)-> a- b);//store bigger numbers
        maxPQ = new PriorityQueue<>((a,b)-> b- a);//store smaller numbers
    }

    public void addNum(int num) {
        if(minPQ.isEmpty() && maxPQ.isEmpty()){
            minPQ.add(num);
        }else if(!minPQ.isEmpty() && maxPQ.isEmpty()){
            if(minPQ.peek() <= num){
                minPQ.add(num);
            }else{
                maxPQ.add(num);
            }
        }else if(minPQ.isEmpty() && !maxPQ.isEmpty()){
            if(maxPQ.peek() >= num){
                maxPQ.add(num);
            }else{
                minPQ.add(num);
            }
        }else{
            int minPeek  = minPQ.peek();
            if(num <= minPeek){
                maxPQ.add(num);
            }else{
                minPQ.add(num);
            }

        }
        adjust();
    }

    public double findMedian() {
        double res = 0.0;
        if(minPQ.size() == maxPQ.size()){
            res = ((minPQ.peek() + maxPQ.peek()) / 2.0);
        }else if(minPQ.size() > maxPQ.size()){
            res = minPQ.peek();
        }else{
            res = maxPQ.peek();
        }

        return res;
    }

    private void adjust(){
        if(minPQ.size() > maxPQ.size() + 1){
            maxPQ.add(minPQ.poll());
        }


        if(maxPQ.size() > minPQ.size() + 1){
            minPQ.add(maxPQ.poll());
        }
    }
}
