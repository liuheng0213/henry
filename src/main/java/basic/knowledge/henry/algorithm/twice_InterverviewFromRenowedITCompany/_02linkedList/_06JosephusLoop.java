package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._02linkedList;


//环形单链表的约瑟夫环问题
public class _06JosephusLoop {

    public Node josephus(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }

        Node last = head;
        while(last.next != head){
            last = last.next;
        }

        int count =0;
        while(head != last){
            if(++count == m){
                last.next = head.next;
                count=0;
            }else{
                last = head;
            }
            head = head.next;
        }

        return head;
    }

}
