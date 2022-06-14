package leetcode.p0023_merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

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
        ListNode l1 = new ListNode(1,
                new ListNode(4,
                        new ListNode(5, null)));
        ListNode l2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4, null)));
        ListNode l3 = new ListNode(2,
                new ListNode(6, null));
        ListNode[] listNodeList = new ListNode[]{l1, l2, l3};
        ListNode res = solution.mergeKLists(listNodeList);
        System.out.println(res);

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode sentinel = new ListNode(-1, null);
        ListNode curr = sentinel;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.add(listNode);
            }
        }

        while (!pq.isEmpty()) {
            ListNode p = pq.poll();
            curr.next = p;
            curr = curr.next;
            if (p.next != null) {
                pq.add(p.next);    
            }
        }
        return sentinel.next;
    }
}
