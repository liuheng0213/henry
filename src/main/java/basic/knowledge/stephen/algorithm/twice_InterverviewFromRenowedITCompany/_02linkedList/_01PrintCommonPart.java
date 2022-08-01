package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._02linkedList;


/**
 * 有序链表 打印公共部分
 * 双指针
 */
public class _01PrintCommonPart {

    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Common part:");
        if (head1 == null || head2 == null) {
            return;
        }
        while (head1 != null && head2 != null) {

            if (head1.value == head2.value) {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }else if(head1.value < head2.value){
                head1 = head1.next;
            }else{
                head2 = head2.next;
            }

        }
    }

}

