package basic.knowledge.henry.algorithm.segments.max;

public class MaxSegmentTree {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 3};
        MaxSegmentTree maxSegmentTree = new MaxSegmentTree();
        SegmentTreeNode root = maxSegmentTree.build(arr);
        System.out.println("");

    }

    // 构造的代码及注释
    public SegmentTreeNode build(int[] A) {
        // write your code here
        return buildhelper(0, A.length - 1, A);
    }

    public SegmentTreeNode buildhelper(int left, int right, int[] A) {
        if (left > right) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(left, right, A[left]); // 根据节点区间的左边界的序列值为节点赋初值
        if (left == right) {
            return root; // 如果左边界和右边界相等,节点左边界的序列值就是线段树节点的接节点值
        }
        int mid = (left + right) / 2; // 划分当前区间的左右区间
        root.left = buildhelper(left, mid, A);
        root.right = buildhelper(mid + 1, right, A);
        root.max = Math.max(root.left.max, root.right.max); // 根据节点区间的左右区间的节点值得到当前节点的节点值
        return root;
    }


    // 单点更新的代码及注释
    public void modify(SegmentTreeNode root, int index, int value) {
        if(root == null){
            return;
        }
        // write your code here
        if (root.start == root.end && root.start == index) { // 找到被改动的叶子节点
            root.max = value; // 改变value值
            return;
        }
        int mid = (root.start + root.end) / 2; // 将当前节点区间分割为2个区间的分割线
        if (index <= mid) { // 如果index在当前节点的左边
            modify(root.left, index, value); // 递归操作
        } else {            // 如果index在当前节点的右边
            modify(root.right, index, value); // 递归操作
        }
        if (root.right != null && root.left != null) {
            root.max = Math.max(root.left.max, root.right.max); // 可能对当前节点的影响
        }
        return;
    }


    // 区间查询的代码及注释
    public int query(SegmentTreeNode root, int start, int end) {
        if (start <= root.start && root.end <= end) {
            // 如果查询区间在当前节点的区间之内,直接输出结果
            return root.max;
        }
        int mid = (root.start + root.end) / 2; // 将当前节点区间分割为左右2个区间的分割线
        int ans = Integer.MIN_VALUE; // 给结果赋初值
        if (mid >= start) {   // 如果查询区间和左边节点区间有交集,则寻找查询区间在左边区间上的最大值
            ans = Math.max(ans, query(root.left, start, end));
        }
        if (mid + 1 <= end) { // 如果查询区间和右边节点区间有交集,则寻找查询区间在右边区间上的最大值
            ans = Math.max(ans, query(root.right, start, end));
        }
        return ans; // 返回查询结果
    }


}
