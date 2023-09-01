package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

import basic.knowledge.henry.algorithm.InterviewExperience.ListNode;

//删除链表中的倒数第k个节点并返回第k个节点
public class DeleteTheLastKNode {
    public static void main(String[] args) {
        DeleteTheLastKNode obj = new DeleteTheLastKNode();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = new ListNode(8);
        listNode.next.next.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next.next.next = new ListNode(10);
        listNode.next.next.next.next.next.next.next.next.next.next = new ListNode(11);

        int res = obj.deleteK(listNode,6);
        System.out.println(res);


    }

    private int deleteK(ListNode listNode, int k) {
        int i = 1;
        ListNode last = null;
        listNode = listNode.next;
        if(listNode == null){
            if(k == 1){
                int res = last.value;
                last = null;
                return res;
            }
            return Integer.MIN_VALUE;
        }
        while(listNode != null){
            i++;
            if(i == k){
                last.next = listNode.next;
                listNode.next = null;
                return listNode.value;
            }
            last = listNode;
            listNode = listNode.next;
        }

        return Integer.MIN_VALUE;
    }
}
