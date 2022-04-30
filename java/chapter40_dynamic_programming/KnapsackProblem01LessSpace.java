package chapter40_dynamic_programming;

import java.util.Random;

public class KnapsackProblem01LessSpace {
    public static void main(String[] args) {
        KnapsackProblem01LessSpace knapsackProblem01 = new KnapsackProblem01LessSpace();
        int[] itemsWeight = knapsackProblem01.generateItems(10000, 15000);
        long start = System.currentTimeMillis();
        System.out.println(knapsackProblem01.knapsack(itemsWeight, itemsWeight.length, 30000));
        System.out.println(System.currentTimeMillis() - start);

        int[] itemsValue = knapsackProblem01.generateItems(10000, 15000);
        start = System.currentTimeMillis();
        System.out.println(knapsackProblem01.knapsack3(itemsWeight, itemsValue, itemsWeight.length, 30000));
        System.out.println(System.currentTimeMillis() - start);
    }

    public int knapsack(int[] itemsWeight, int itemsCount, int weightCapacity) {
        boolean[] states = new boolean[weightCapacity + 1];
        // 第一行特殊处理
        states[0] = true;
        if (itemsWeight[0] <= weightCapacity) {
            states[itemsWeight[0]] = true;
        }

        for (int i = 1; i < itemsCount; i++) {
            // 把 i 放到背包里
            // 注意这里需要从大到小遍历避免重复计算的问题
            for (int j = weightCapacity - itemsWeight[i]; j >= 0; j--) {
                if (states[j]) {
                    states[j + itemsWeight[i]] = true;
                }
            }
        }

        // 查找最后一行中最接近背包容量并且为 true 的值
        for (int i = weightCapacity; i >= 0; i--) {
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }

    public int knapsack3(int[] itemsWeight, int[] itemsValue, int itemsCount, int weightCapacity) {
        int[] states = new int[weightCapacity + 1];
        for (int j = 0; j < weightCapacity + 1; j++) {
            states[j] = -1;
        }

        states[0] = 0;
        if (itemsWeight[0] <= weightCapacity) {
            states[itemsWeight[0]] = itemsValue[0];
        }

        for (int i = 1; i < itemsCount; i++) {
            // 注意这里需要从大到小遍历避免重复计算的问题
            for (int j = weightCapacity - itemsWeight[i]; j >= 0; j--) {
                if (states[j] > 0) {
                    int v = states[j] + itemsValue[i];
                    if (v > states[j + itemsWeight[i]]) {
                        states[j + itemsWeight[i]] = v;
                    }
                }
            }
        }

        int maxValue = -1;
        for (int j = weightCapacity; j >= 0; j--) {
            if (states[j] > maxValue) {
                maxValue = states[j];
            }
        }
        return maxValue;
    }

    public int[] generateItems(int itemsCount, int singleItemMaxValue) {
        int[] items = new int[itemsCount];
        Random random = new Random();
        for (int i = 0; i < itemsCount; i++) {
            items[i] = random.nextInt(singleItemMaxValue + 1);
        }
        return items;
    }
}
