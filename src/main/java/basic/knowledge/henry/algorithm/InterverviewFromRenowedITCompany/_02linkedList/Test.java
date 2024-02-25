package basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._02linkedList;

public class Test {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);

        Test test = new Test();
        Node node1 = test.reverseN(node, 3);
        System.out.println();
    }
    Node successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    Node reverseN(Node head, int n) {
        if(head == null && n > 1){
            return head;
        }
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        Node last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;

    }
}
