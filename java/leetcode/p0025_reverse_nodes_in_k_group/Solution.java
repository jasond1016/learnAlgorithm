package leetcode.p0025_reverse_nodes_in_k_group;

import java.util.List;

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
        ListNode res = solution.reverse(head);
        System.out.println(res);

        ListNode fourth = new ListNode(4,
                new ListNode(5, null));
        ListNode second = new ListNode(2,
                new ListNode(3,
                        fourth));
        head = new ListNode(1, second);
        res = solution.reverseBetween(second, fourth);
        System.out.println(res);

        head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));
        res = solution.reverseKGroup(head, 2);
        System.out.println(res);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverseBetween(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private ListNode reverseBetween(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
