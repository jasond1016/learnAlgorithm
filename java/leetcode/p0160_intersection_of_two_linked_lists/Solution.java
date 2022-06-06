package leetcode.p0160_intersection_of_two_linked_lists;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode intersectionNode = new ListNode(8);
        intersectionNode.next = new ListNode(4);
        intersectionNode.next.next = new ListNode(5);
        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = intersectionNode;

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(1);
        b.next.next.next = intersectionNode;

        ListNode res = solution.getIntersectionNode(a, b);
        System.out.println(res);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}