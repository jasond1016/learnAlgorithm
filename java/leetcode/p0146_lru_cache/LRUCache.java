package leetcode.p0146_lru_cache;

import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1)); // 1
        obj.put(3, 3);
        System.out.println(obj.get(2)); // -1
        obj.put(4, 4);
        System.out.println(obj.get(1)); // -1
        System.out.println(obj.get(3)); // 3
        System.out.println(obj.get(4)); // 4
    }
    
    // 链表节点
    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    // 双向链表
    private static class DoublyLinkList {
        Node head;
        Node tail;
        int size;

        public DoublyLinkList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }
        
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }
        
        public int size() {
            return size;
        }
    }

    private HashMap<Integer, Node> map;
    private DoublyLinkList cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new DoublyLinkList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecently(key);
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            makeRecently(key);
            return;
        }
        if (cache.size() == capacity) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    private void makeRecently(int key) {
        Node recentlyUsedNode = map.get(key);
        cache.remove(recentlyUsedNode);
        cache.addLast(recentlyUsedNode);
    }
    
    private void removeLeastRecently() {
        Node removed = cache.removeFirst();
        map.remove(removed.key);
    }

    private void addRecently(int key, int value) {
        Node newNode = new Node(key, value);
        cache.addLast(newNode);
        map.put(key, newNode);
    }

    private void deleteKey(int key) {
        Node x = map.remove(key);
        cache.remove(x);
    }
}
