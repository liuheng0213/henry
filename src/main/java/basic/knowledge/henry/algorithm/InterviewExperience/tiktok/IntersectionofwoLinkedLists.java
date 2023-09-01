package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

import basic.knowledge.henry.algorithm.InterviewExperience.ListNode;

//leetcode 160
public class IntersectionofwoLinkedLists {
    public static void main(String[] args) {
        IntersectionofwoLinkedLists obj = new IntersectionofwoLinkedLists();
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
//        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(0);
        headB.next= new ListNode(1);
        headB.next.next = new ListNode(2);
        headB.next.next.next = new ListNode(3);
//        headB.next.next.next.next = new ListNode(4);
//        headB.next.next.next.next.next = new ListNode(5);

        ListNode res = obj.getIntersectionNode(headA, headB);
        System.out.println(res.value);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        //不断的循环, 指针到null了又从头开始
        int c = 0;
        while (a != b) {
            a = a == null ? headA : a.next;
            b = b == null ? headB : b.next;
            System.out.println(a == null ? "null": a.value);
            System.out.println(b == null ? "null": b.value);
            System.out.println("========");
            c++;
        }
        System.out.println(c);
        return a;
    }

}
