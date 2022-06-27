package leetcode.p0710_random_pick_with_blacklist;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int n = 7;
        int[] blacklist = new int[]{2, 3, 5};
        // 原始数据：0,1,2,3,4,5,6
        // 黑名单：2,3,5
        // 黑名单往后放：0,1,6,4,3,5,2
        Solution obj = new Solution(n, blacklist);
        System.out.println(obj.pick());
        System.out.println(obj.pick());
        System.out.println(obj.pick());
    }

    int sz;
    Map<Integer, Integer> map;
    Random random;

    public Solution(int n, int[] blacklist) {
        sz = n - blacklist.length;
        map = new HashMap<>();
        random = new Random();
        for (int b : blacklist) {
            map.put(b, 666);
        }
        int last = n - 1;
        for (int b : blacklist) {
            // 黑名单的数已经在范围外
            if (b >= sz) {
                continue;
            }
            // 排除黑名单的数
            while (map.containsKey(last)) {
                last--;
            }
            
            // 将黑名单和非黑名单的数关联上
            map.put(b, last);
            last--;
        }
    }

    public int pick() {
        int index = random.nextInt(sz);
        if (map.containsKey(index)) {
            return map.get(index);
        }
        return index;
    }
}
