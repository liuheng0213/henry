package basic.knowledge.henry.algorithm.InterviewExperience.canva;

public class Leetcode1472 {
    Node cur;

    public Leetcode1472(String homepage) {
        cur = new Node(homepage);
    }

    public void visit(String url) {
        cur.next = new Node(url);
        cur.next.pre = cur;
        cur = cur.next;

    }


    public String back(int steps) {
        while (steps > 0 && cur.pre != null) {
            cur = cur.pre;
            steps--;
        }
        return cur.val;
    }

    public String forward(int steps) {
        while (steps > 0 && cur.next != null) {
            cur = cur.next;
            steps--;
        }
        return cur.val;
    }


    class Node {
        Node next;
        Node pre;
        String val;

        public Node(String val) {
            this.val = val;
        }
    }

}
