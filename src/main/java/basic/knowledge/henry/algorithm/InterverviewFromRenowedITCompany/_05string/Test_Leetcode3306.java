package basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._05string;

public class Test_Leetcode3306 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{9932,9857,4494};
        int[] arr2 = new int[]{9699,6286,4281};

        Test_Leetcode3306 test = new Test_Leetcode3306();
        System.out.println(test.longestCommonPrefix(arr1,arr2));
    }
    class Node{
        Node[] children;

        public Node(){
            children = new Node[10];
        }
    }
    Node root = new Node();
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        //create a trie
        Node cur = null;
        for(int num : arr1){
            cur = this.root;
            char[] chs = String.valueOf(num).toCharArray();
            for(char ch : chs){
                if(cur.children[ch-'0'] == null){
                    cur.children[ch-'0'] = new Node();
                }
                cur = cur.children[ch-'0'];
            }
        }


        int ans = 0;
        for(int num : arr2){
            cur = this.root;
            char[] chs = String.valueOf(num).toCharArray();
            int count = 0;
            for(int i =0;i< chs.length;i++){
                if(cur.children[chs[i]-'0'] != null){
                    cur = cur.children[chs[i]-'0'];
                    count++;
                    ans = Math.max(ans,count);
                }else{
                    break;
                }

            }
        }

        return ans;


    }
}
