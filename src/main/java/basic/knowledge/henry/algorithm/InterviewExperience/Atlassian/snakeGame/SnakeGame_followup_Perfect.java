package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.snakeGame;

import java.util.LinkedList;

public class SnakeGame_followup_Perfect {
    int width;
    int height;

    LinkedList<int[]> snake;

    int steps;
    public SnakeGame_followup_Perfect(int width, int height) {
        this.snake = new LinkedList<>();
        this.snake.addFirst(new int[]{0, 0});
        this.width = width;
        this.height = height;
        this.steps = 0;
    }

    public static void main(String[] args) {
        SnakeGame_followup_Perfect solution = new SnakeGame_followup_Perfect(3, 2);
        int r = solution.move("R");
        System.out.println(r);
        int d = solution.move("D");
        System.out.println(d);
        int r1 = solution.move("R");
        System.out.println(r1);
        int u = solution.move("U");
        System.out.println(u);
        int l = solution.move("L");
        System.out.println(l);
        int l1 = solution.move("R");
        System.out.println(l1);

        int u1 = solution.move("U");
        System.out.println(u1);
        System.out.println();


    }

    private int move(String r) {
        this.steps++;
        int[] head = snake.peekFirst();
        int i = head[0];
        int j = head[1];
        switch (r) {
            case "U":
                i--;
                break;
            case "R":
                j++;
                break;
            case "D":
                i++;
                break;
            case "L":
                j--;
                break;
        }
        if(i < 0 || i > height - 1|| j < 0 || j > width - 1){
            return  -1;
        }
        head = new int[]{i,j};
        this.snake.addFirst(head);
        if(!(this.steps % 5 == 0)){
            this.snake.pollLast();
        }

        for(int k = 1;k < this.snake.size();k++){
            if(head[0] == snake.get(k)[0] && head[1] == snake.get(k)[1]){
                return -1;
            }
        }

        return snake.size();


    }
}
