package chapter40_dynamic_programming;

import java.util.Random;

public class KnapsackProblem01 {
    public static void main(String[] args) {
        KnapsackProblem01 knapsackProblem01 = new KnapsackProblem01();
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
        boolean[][] states = new boolean[itemsCount][weightCapacity + 1];
        // 第一行特殊处理
        states[0][0] = true;
        if (itemsWeight[0] <= weightCapacity) {
            states[0][itemsWeight[0]] = true;
        }

        for (int i = 1; i < itemsCount; i++) {
            // 不把 i 放到背包里
            for (int j = 0; j <= weightCapacity; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }

            // 把 i 放到背包里
            for (int j = 0; j <= weightCapacity - itemsWeight[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + itemsWeight[i]] = true;
                }
            }
        }

        // 查找最后一行中最接近背包容量并且为 true 的值
        for (int i = weightCapacity; i >= 0; i--) {
            if (states[itemsCount - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    public int knapsack3(int[] itemsWeight, int[] itemsValue, int itemsCount, int weightCapacity) {
        int[][] states = new int[itemsCount][weightCapacity + 1];
        for (int i = 0; i < itemsCount; i++) {
            for (int j = 0; j < weightCapacity + 1; j++) {
                states[i][j] = -1;
            }
        }

        states[0][0] = 0;
        if (itemsWeight[0] <= weightCapacity) {
            states[0][itemsWeight[0]] = itemsValue[0];
        }

        for (int i = 1; i < itemsCount; i++) {
            for (int j = 0; j < weightCapacity + 1; j++) {
                if (states[i - 1][j] > 0) {
                    states[i][j] = states[i - 1][j];
                }
            }

            for (int j = 0; j < weightCapacity + 1 - itemsWeight[i]; j++) {
                if (states[i - 1][j] > 0) {
                    int v = states[i - 1][j] + itemsValue[i];
                    if (v > states[i][j + itemsWeight[i]]) {
                        states[i][j + itemsWeight[i]] = v;
                    }
                }
            }
        }

        int maxValue = -1;
        for (int j = weightCapacity; j >= 0; j--) {
            if (states[itemsCount - 1][j] > maxValue) {
                maxValue =  states[itemsCount - 1][j];
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
