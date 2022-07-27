package leetcode.p0146_lru_cache;

import java.util.LinkedHashMap;

public class LRUCache2 {
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

    private LinkedHashMap<Integer, Integer> map;
    private int capacity;
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecently(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecently(key);
            return;
        }
        if (map.size() == capacity) {
            int oldKey = map.keySet().iterator().next();
            map.remove(oldKey);
        }
        map.put(key, value);
    }

    private void makeRecently(int key) {
        int value = map.remove(key);
        map.put(key, value);
    }
}
