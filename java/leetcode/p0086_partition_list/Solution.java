package leetcode.p0086_partition_list;

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
                new ListNode(4,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(5,
                                                new ListNode(2, null))))));
        ListNode res = solution.partition(head, 3);
        System.out.println(res);
        
    }
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode sentinel1 = new ListNode(-1, null);
        ListNode sentinel2 = new ListNode(-1, null);
        ListNode current1 = sentinel1;
        ListNode current2 = sentinel2;

        while (p != null) {
            if (p.val < x) {
                current1.next = p;
                current1 = current1.next;
            } else {
                current2.next = p;
                current2 = current2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        
        current1.next = sentinel2.next;

        return sentinel1.next;
    }
}
