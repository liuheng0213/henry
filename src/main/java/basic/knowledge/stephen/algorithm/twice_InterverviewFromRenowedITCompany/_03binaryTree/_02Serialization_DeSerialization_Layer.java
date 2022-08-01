package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._03binaryTree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层级遍历序列化和反序列化
 */
public class _02Serialization_DeSerialization_Layer {
    public String serialByLayer(Node head) {
        if (head == null) {
            return "#!";
        }

        String res = String.valueOf(head.value);
        Queue<Node> queue = new LinkedList<>();

        queue.add(head);

        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                queue.add(head.left);
                res += head.left.value + "!";
            } else {
                res += "#!";
            }

            if (head.right != null) {
                queue.add(head.right);
                res += head.right.value + "!";
            } else {
                res += "#!";
            }
        }

        return res;
    }

    public Node reconByLevelString(String levelStr) {
        String[] strs = levelStr.split("!");
        int index = 0;
        Node head = getNode(strs[index++]);
        if(head == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            Node left = getNode(strs[index++]);
            Node right = getNode(strs[index++]);

            if(left != null){
                cur.left = left;
                queue.add(cur.left);
            }

            if(right != null){
                cur.right = right;
                queue.add(cur.right);
            }

        }

        return head;
    }

    private Node getNode(String str) {
        if (str.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(str));
    }
}
