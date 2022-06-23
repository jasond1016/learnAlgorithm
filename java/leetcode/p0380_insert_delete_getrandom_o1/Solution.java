package leetcode.p0380_insert_delete_getrandom_o1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }

}

class RandomizedSet {
    ArrayList<Integer> nums = new ArrayList<>();
    Map<Integer, Integer> valToIndex = new HashMap<>();
    Random random = new Random();
    public RandomizedSet() {

    }
    
    // 将数据插入到最后位置
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    // 将要删除的数据和最后一位的数据互换位置后，再删除
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }

        int i = valToIndex.get(val);
        if (i != nums.size() - 1) {
            int lastNum = nums.get(nums.size() - 1);
            nums.set(i, lastNum);
            valToIndex.put(lastNum, i);
        }
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    // 随机获取一个数据
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}