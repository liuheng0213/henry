package basic.knowledge.tmp;

public class Solution {
    public static void main(String[] args) {

        int[] A = new int[]{0, 4, 2, 2, 4};
        int[] B = new int[]{1, 3, 1, 3, 5};
        Solution solution = new Solution();
        int i = solution.solution(A, B);
        System.out.println(i);

    }

    int res = 0;

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int n = A.length;
        UnionFind uf = new UnionFind(n + 1);
        for(int i = 0;i< n;i++){
            uf.union(A[i],B[i]);
        }

        int res = 0;
        for(int i = 0;i< n + 1;i++){
            res+=uf.findParent(i);
        }

        return res;
    }

    class UnionFind{
        int[] ids;
        int[] heights;

        public UnionFind(int n){
            ids = new int[n];
            heights = new int[n];

            for(int i = 0;i< n;i++){
                ids[i] = i;
                heights[i] = 1;
            }
        }


        private boolean connected(int p, int q){
            return find(p) == find(q);
        }

        private int find(int p){
            while(p != ids[p]){
                p = ids[p];
            }
            return p;
        }

        private int findParent(int p){
            int tmp = 0;
            while(p != ids[p]){
                p = ids[p];
                tmp++;
            }
            return tmp;
        }

        private void union(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);

            if(pRoot == qRoot){
                return;
            }

            if(heights[pRoot] < heights[qRoot]){
                ids[pRoot] = qRoot;
            }else if(heights[pRoot] > heights[qRoot]){
                ids[qRoot] = pRoot;
            }else{
                ids[pRoot] = qRoot;
                heights[qRoot]++;
            }
        }
    }

}
