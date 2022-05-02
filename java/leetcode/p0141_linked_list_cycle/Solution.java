package leetcode.p0141_linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 哈希表
    public boolean hasCycle(ListNode head) {
        Set<ListNode> sets = new HashSet<>();
        while (head != null) {
            if (sets.contains(head)) {
                return true;
            } else {
                sets.add(head);
            }
            head = head.next;
        }
        return false;
    }

    // 快慢指针
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
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
