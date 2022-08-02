package leetcode.p0295_find_median_from_data_stream;

import java.util.PriorityQueue;

public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian()); // 1.5
        finder.addNum(3);
        System.out.println(finder.findMedian()); // 2
    }

    // 大顶堆，堆顶数据为小数据中最大的
    PriorityQueue<Integer> small;
    // 小顶堆，堆顶数据为大数据中最小的
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 需要维护两堆数据个数相差不超过1
        // 当大顶堆数据多时，需要插入到小顶堆。
        // 但是要先插入大顶堆中，再从大顶堆取堆顶数据放到小顶堆中才能保证数据排序没问题
        // 反之，同理
        if (small.size() > large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        // 两堆大小不一致时，从多的堆顶取数据
        if (small.size() > large.size()) {
            return small.peek();
        } else if (small.size() < large.size()) {
            return large.peek();
        }
        // 两堆大小一致时，分别取堆顶取数据求平均
        return (small.peek() + large.peek()) / 2.0;
    }
}
