package basic.knowledge.henry.algorithm.algorithm_4_Edition.ch1.unionfind;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 时间复杂度: 树的高度
 */
public class _02quickUnion {
    private int count;
    private int[] ids;


    public _02quickUnion(int count) {
        this.count = count;
        this.ids = new int[count];
        for (int i = 0; i < this.ids.length; i++) {
            ids[i] = i;
        }
    }

    public int count() {
        return this.count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 找到p的根触点
     *
     * @param p
     * @return
     */
    public int find(int x) {
//        while (p != ids[p]) {
//            p = ids[p];
//        }
//        return p;
        if (x != ids[x]) { //x's parent ids[x] is not x
            //find ids[x]'s parent and set it to be x's parent
            // it must be the parent of x
            ids[x] = find(ids[x]);
        }
        return ids[x];
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        //如果根触点相同, 既p q已经联通
        if (pRoot == qRoot) {
            return;
        }

        ids[pRoot] = qRoot;

        this.count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        _02quickUnion unionfind = new _02quickUnion(n);

        while (!StdIn.isEmpty()) {

            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (unionfind.connected(p, q)) {
                continue;
            }

            unionfind.union(p, q);

            System.out.println("p = " + p + ", q = " + q);


        }

        System.out.println(unionfind.count() + "Components");
    }


}
