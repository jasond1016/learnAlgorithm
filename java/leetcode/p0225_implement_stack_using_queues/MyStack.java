package leetcode.p0225_implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    Queue<Integer> queue;
    Integer topItem;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        topItem = x;
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        topItem = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        return topItem;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
