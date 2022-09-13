package leetcode.p0382_linked_list_random_node;

import java.util.Random;

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
        ListNode test = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));
        Solution solution = new Solution(test);
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }

    ListNode head;
    Random random;
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        ListNode p = head;
        int i = 0;
        int res = p.val;
        while (p != null) {
            i++;
            // [0,i)随机到0的概率 = 1/i
            if (0 == random.nextInt(i)) {
                // 第 i 个数有 1/i 的概率选中（1-1/i的概率不选中），即可完成题目要求
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
