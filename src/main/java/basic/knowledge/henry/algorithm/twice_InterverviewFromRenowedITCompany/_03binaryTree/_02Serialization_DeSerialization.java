package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._03binaryTree;


import java.util.LinkedList;

//先序遍历的序列化与反序列化  这个先序后序  递归比较好 只有层遍历是while
public class _02Serialization_DeSerialization {

    public String serialByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = String.valueOf(head.value);

        res += serialByPre(head.left);
        res += serialByPre(head.right);

        return res;
    }

    public Node reconByPreString(String preStr){
        if(preStr == null || preStr.length() == 0){
            return null;
        }
        String[] strs = preStr.split("!");

        LinkedList<String> queue = new LinkedList<>();
        for(String str : strs){
            queue.add(str);
        }
        return recon(queue);
    }

    private Node recon(LinkedList<String> queue) {
        String poll = queue.pollFirst();
        if(poll.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(poll));
        head.left = recon(queue);
        head.right = recon(queue);

        return head;
    }


}
