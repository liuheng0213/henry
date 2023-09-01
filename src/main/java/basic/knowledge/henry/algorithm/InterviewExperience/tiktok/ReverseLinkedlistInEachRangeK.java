package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

import basic.knowledge.henry.algorithm.InterviewExperience.ListNode;

public class ReverseLinkedlistInEachRangeK {
    public static void main(String[] args) {
        ReverseLinkedlistInEachRangeK obj = new ReverseLinkedlistInEachRangeK();
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
        obj.solution(listNode);
        System.out.println("======");
    }

    private void solution(ListNode listNode) {
    }
}
