package chapter29_heap;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Heap heap = new Heap(k);
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            heap.insert(point);
        }

        int[][] closetPoints = new int[heap.count][];
        for (int i = 0; i < heap.count; i++) {
            closetPoints[i] = heap.points[i + 1];
        }
        return closetPoints;
    }

    class Heap {
        final int[] ZERO = new int[]{0, 0};
        int[][] points;
        int capacity;
        int count;

        public Heap(int capacity) {
            this.points = new int[capacity + 1][];
            this.capacity = capacity;
            this.count = 0;
        }

        void insert(int[] point) {

            if (this.count >= this.capacity) {
                if (distanceFromZero(point) >= distanceFromZero(points[1])) {
                    return;
                } else {
                    removeMax();
                }
            }

            points[++count] = point;
            int i = count;
            while (i / 2 > 0 && distanceFromZero(points[i]) > distanceFromZero(points[i / 2])) {
                swap(points, i, i / 2);
                i = i / 2;
            }

        }

        void removeMax() {
            if (count == 0) {
                return;
            }

            points[1] = points[count--];
            heapify(this.points, this.count, 1);
        }

        private void heapify(int[][] points, int count, int i) {
            while (true) {
                int maxPos = i;
                if (i * 2 <= count && distanceFromZero(points[i]) < distanceFromZero(points[i * 2])) {
                    maxPos = i * 2;
                }
                if (i * 2 + 1 <= count && distanceFromZero(points[maxPos]) < distanceFromZero(points[i * 2 + 1])) {
                    maxPos = i * 2 + 1;
                }
                if (maxPos == i) {
                    break;
                }
                swap(points, i, maxPos);
                i = maxPos;
            }
        }

        private void swap(int[][] a, int i, int j) {
            int[] temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        private double distanceFromZero(int[] point) {
            return this.distanceBetween(ZERO, point);
        }

        private double distanceBetween(int[] point1, int[] point2) {
            return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
        }
    }
}