package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.snakeGame;


import basic.knowledge.henry.algorithm.InterviewExperience.ListNode;

import java.util.LinkedList;

public class SnakeGame {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        SnakeGame solution = new SnakeGame(3, 2);
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

    int width;
    int height;
    LinkedList<Position> snake;
    int steps;

    int len;

    public SnakeGame(int width, int height) {
        this.width = width;
        this.height = height;
        this.snake = new LinkedList<>();
        this.snake.addFirst(new Position(0, 0));
        this.steps = 1;
        this.len = 0;
    }

    public int move(String dir) {

        Position head = snake.peekFirst();
        int x = head.x;
        int y = head.y;
        if (dir.equals("U")) {
            x--;
        } else if (dir.equals("D")) {
            x++;
        } else if (dir.equals("R")) {
            y++;
        } else {
            y--;
        }
        // System.out.println("head x: " + head.x + " head y: " + head.y);
        // go out of the range
        if (x < 0 || x > height - 1 || y < 0 || y > width - 1) {
            return -1;
        }

        head = new Position(x, y);

        //meet snake itself
        for (int i = 1; i < snake.size() - 1; i++) {
            Position p = snake.get(i);
            if (p.equals(head)) {
                return -1;
            }
        }
        snake.addFirst(head);
        if (!(steps % 5 == 0)) {
            snake.pollLast();
        }
        steps++;

        return snake.size();
    }

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Position that) {
            return this.x == that.x && this.y == that.y;
        }
    }
}
