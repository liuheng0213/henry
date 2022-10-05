package basic.knowledge.henry.algorithm.segments.min;

public class MinSegmentTree {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3));


        int[] A = new int[]{1, 4, 2, 3, 6, 1, -7, 34, 22};
        MinSegmentTree minSegmentTree = new MinSegmentTree();
        SegmentTreeNode root = minSegmentTree.build(A);
        minSegmentTree.modify(root, 9, 27);
        int query = minSegmentTree.query(root, 6, 7);
        System.out.println(query);
    }

    public SegmentTreeNode build(int[] A) {
        return build(0, A.length - 1, A);
    }

    private SegmentTreeNode build(int s, int e, int[] A) {
        if (s > e) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(s, e, A[s]);
        if (s == e) {
            return root;
        }

        int mid = (s + e) / 2;
        root.left = build(s, mid, A);
        root.right = build(mid + 1, e, A);
        root.min = Math.min(root.left.min, root.right.min);
        return root;

    }


    private void modify(SegmentTreeNode root, int index, int value) {
        if(root == null){
            return;
        }
        if (root.start == root.end && root.end == index) {
            root.min = value;
            return;
        }

        int mid = (root.start + root.end) / 2;
        if (index <= mid) {
            if(root.left == null){
                System.out.println("node.left=="+root.left);
            }
            modify(root.left, index, value);
        } else {
            if(root.right == null){
                System.out.println("node.right=="+root.right);
            }
            modify(root.right, index, value);
        }
        if(root.right != null && root.left != null){
            root.min = Math.min(root.right.min, root.left.min);
        }
    }

    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end) {
            throw new RuntimeException("wrong parameters");
        }
        int ans = Integer.MAX_VALUE;
        if (root == null ||start > root.end || end < root.start) {
            return ans;
        }

        if (start <= root.start && end >= root.end) {
            return root.min;
        }
        int mid = (root.start + root.end) / 2;
        if (start <= mid) {
            ans = Math.min(ans, query(root.left, start, end));
        }
        if (end >= mid + 1) {
            ans = Math.min(ans, query(root.right, start, end));
        }
        return ans;
    }
}
