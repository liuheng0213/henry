package basic.knowledge.henry.algorithm.segments;

public class Leetcode2407 {
    public static void main(String[] args) {
        Leetcode2407 solution = new Leetcode2407();
        int i = solution.lengthOfLIS(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.println(i);
    }

    public int lengthOfLIS(int[] nums, int k) {
        Node root = build(0, 5);
        int max = 0;
        for (int num : nums) {
            int pre = query(Math.max(0, num - k), Math.max(0, num - 1), root);
            max = Math.max(pre + 1, max);
            update(num, pre + 1, root);
        }
        return max;
    }

    private Node build(int l, int r) {
        if (l > r) {
            return null;
        }

        if (l == r) {
            return new Node(l, r, 0);
        }
        Node node = new Node(l, r, 0);
        int mid = l + (r - l) / 2;
        node.left = build(l, mid);
        node.right = build(mid + 1, r);
        return node;
    }

    private void update(int num, int cnt, Node node) {
        if(node == null) {
            return;
        }
        if (node.l == node.r && node.l == num) {
            node.cnt = cnt;
            return;
        }
        int mid = (node.l + node.r) / 2;
        if (num <= mid) {
            update(num, cnt, node.left);
        } else {
            update(num, cnt, node.right);
        }

        if(node.left != null && node.right!= null){
            node.cnt = Math.max(node.left.cnt, node.right.cnt);
        }

    }

    private int query(int from, int to, Node node) {
        if (from > to) {
            return 0;
        }
        int ans = 0;
        if (node == null || from > node.r || to < node.l) {
            return ans;
        }
        if (from <=node.l && to >= node.r) {
            return node.cnt;
        }
        int mid = node.l + (node.r - node.l) / 2;
        if (from <= mid) {
            ans = Math.max(ans, query(from, to, node.left));
        }

        if (to >= mid + 1) {
            ans = Math.max(ans, query(from, to, node.right));
        }
        return ans;
    }

    private static class Node {
        int l;
        int r;
        int cnt;
        Node left;
        Node right;

        public Node(int l, int r, int cnt) {
            this.l = l;
            this.r = r;
            this.cnt = cnt;
        }
    }
}
