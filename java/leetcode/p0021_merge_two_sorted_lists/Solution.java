package leetcode.p0021_merge_two_sorted_lists;

public class Solution {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode res = solution.mergeTwoLists(list1, list2);
        System.out.println(res);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode sentinel = new ListNode(-1, null);
        ListNode current = sentinel;
        while (p1 != null && p2 != null) {
            if (compare(p1, p2) <= 0) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }
        if (p1 != null) {
            current.next = p1;
        }
        if (p2 != null) {
            current.next = p2;
        }
        return sentinel.next;
    }

    private int compare(ListNode l1, ListNode l2) {
        return Integer.compare(l1.val, l2.val);
    }
}
