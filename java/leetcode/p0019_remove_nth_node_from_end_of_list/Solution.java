package leetcode.p0019_remove_nth_node_from_end_of_list;

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
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));
        ListNode res = solution.removeNthFromEnd(head, 2);
        System.out.println(res);
        head = new ListNode(1, null);
        res = solution.removeNthFromEnd(head, 1);
        System.out.println(res);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, null);
        sentinel.next = head;
        ListNode x = findNthFromEnd(sentinel, n + 1);
        x.next = x.next.next;
        return sentinel.next;
    }
    
    private ListNode findNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
