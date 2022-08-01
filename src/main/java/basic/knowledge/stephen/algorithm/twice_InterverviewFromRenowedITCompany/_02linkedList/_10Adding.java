package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._02linkedList;


import java.util.Stack;

//两个单链表生成相加链表
public class _10Adding {

    public Node addList(Node head1, Node head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (head1 != null) {
            s1.push(head1.value);
            head1 = head1.next;
        }


        while (head2 != null) {
            s1.push(head2.value);
            head2 = head2.next;
        }

        Node node = null;
        Node pre = null;
        int n = 0;
        int n1 = 0;
        int n2 = 0;
        int mod = 0;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();

            pre = node;
            n = n1 + n2 + mod;
            mod = n / 10;
            node = new Node(n % 10);
            node.next = pre;
        }

        if(mod == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }

        return node;


    }

}
