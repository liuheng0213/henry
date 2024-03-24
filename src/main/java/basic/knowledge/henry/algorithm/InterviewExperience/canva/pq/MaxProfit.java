package basic.knowledge.henry.algorithm.InterviewExperience.canva.pq;

import basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix._20MaxRevenueForProjects;

import java.util.PriorityQueue;

public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxRevenueForProjects = new MaxProfit();
        int[] costs = new int[]{5, 4, 1, 2, 2};
        int[] profits = new int[]{3, 5, 3, 2, 9}; //这指得是利润 而不是 收入//这指得是利润 而不是 收入
        //初始资金为3 最多做两个项目
        int res = maxRevenueForProjects.solution(5, 3, costs, profits);
        System.out.println(res);
    }

    public int solution(int W, int K, int[] costs, int[] profits) {
        PriorityQueue<Programe> costsPq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        PriorityQueue<Programe> profitsPQ = new PriorityQueue<>((a, b) -> b.profit - a.profit);


        for (int i = 0; i < costs.length; i++) {
            costsPq.add(new Programe(costs[i], profits[i]));
        }

        for (int i = 0; i < K; i++) {
            while (!costsPq.isEmpty() && costsPq.peek().cost <= W) {
                profitsPQ.add(costsPq.poll());
            }

            if (!profitsPQ.isEmpty()) {
                W += profitsPQ.poll().profit;
            }
        }
        return W;
    }

    class Programe {
        int cost;
        int profit;


        public Programe(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }
}
