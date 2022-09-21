package basic.knowledge.henry.algorithm.segments.max;


// 节点区间定义
// [start, end] 代表节点的区间范围
// max 是节点在(start,end)区间上的最大值
// left , right 是当前节点区间划分之后的左右节点区间


/**
 * 举一反三：
 * 如果需要区间的最小值:
 * root.min = Math.min(root.left.min, root.right.min);
 * 如果需要区间的和:
 * root.sum = root.left.sum + root.right.sum;
 */
public class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }


}
