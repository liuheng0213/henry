package basic.knowledge.henry.algorithm.segments.sum;

public class SegmentTreeNode {
    public int start;
    public int end;
    public int sum;

    SegmentTreeNode left;
    SegmentTreeNode right;

    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = this.right = null;
    }

}
