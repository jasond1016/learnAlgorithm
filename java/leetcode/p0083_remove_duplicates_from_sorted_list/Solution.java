package leetcode.p0083_remove_duplicates_from_sorted_list;

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
        ListNode head = new ListNode(1,
                new ListNode(1,
                        new ListNode(2)));
        ListNode res = solution.deleteDuplicates(head);
        System.out.println(res);
        head = new ListNode(1,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(2,
                                        new ListNode(3)))));
        res = solution.deleteDuplicates(head);
        System.out.println(res);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
