package basic.knowledge.henry.algorithm.segments.sum;

public class SumSegmentTree {

    public static void main(String[] args) {
        SumSegmentTree sumSegmentTree = new SumSegmentTree();
        int[] A = new int[]{1, 4, 2, 3, 6, 1};
        SegmentTreeNode root = sumSegmentTree.build(A);

        int query = sumSegmentTree.query(root, 0, 2);
        System.out.println(query);
        sumSegmentTree.update(root, 1, 9);

        int query1 = sumSegmentTree.query(root, 1, 5);
        System.out.println(query1);
    }

    public SegmentTreeNode build(int[] A) {
        return build(0, A.length - 1, A);
    }

    private SegmentTreeNode build(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end, A[start]);

        if (start == end) {
            return root;
        }

        int mid = (start + end) / 2;
        root.left = build(start, mid, A);
        root.right = build(mid + 1, end, A);

        root.sum = root.left.sum + root.right.sum;

        return root;
    }


    public void update(SegmentTreeNode root, int index, int value) {
        if(root == null){
            return;
        }
        if (root.start == root.end && root.end == index) {
            root.sum = value;
            return;
        }

        int mid = (root.end + root.start) / 2;

        if (index <= mid) {
            update(root.left, index, value);
        } else {
            update(root.right, index, value);
        }

        if (root.right != null && root.left != null) {
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end) {
            throw new RuntimeException("wrong parameters");
        }

        int sum = 0;
        if (start > root.end || end < root.start) {
            return sum;
        }
        if (start <= root.start && end >= root.end) {
            return root.sum;
        }

        int mid = (root.start + root.end) / 2;
        if (start <= mid) {
            sum += query(root.left, start, end);
        }

        if (end >= mid + 1) {
            sum += query(root.right, start, end);
        }

        return sum;
    }
}
