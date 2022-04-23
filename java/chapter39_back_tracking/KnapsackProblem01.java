package chapter39_back_tracking;

import java.util.Random;

public class KnapsackProblem01 {
    public static int maxWeight = Integer.MIN_VALUE;

    public static void main(String[] args) {
        KnapsackProblem01 knapsackProblem01 = new KnapsackProblem01();
//        int[] itemsWeight = new int[]{1, 5, 2, 49, 37, 21, 78, 14, 48, 7, 3, 17};
        int[] itemsWeight = knapsackProblem01.generateItemsWeight(100, 15000);
        long start = System.currentTimeMillis();
        knapsackProblem01.solve(0, 0, itemsWeight, itemsWeight.length, 30000);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(maxWeight);
    }

    public void solve(int i, int currentWeight, int[] items, int n, int knapsackWeight) {
//        System.out.print((items[i]) + " ");
        if (i == n || currentWeight == knapsackWeight) {
//            System.out.println("currentWeight: " + currentWeight);
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
            return;
        }

        solve(i + 1, currentWeight, items, n, knapsackWeight);
        if (currentWeight + items[i] <= knapsackWeight) {
            solve(i + 1, currentWeight + items[i], items, n, knapsackWeight);
        }
    }

    public int[] generateItemsWeight(int itemsCount, int singleItemMaxWeigh) {
        int[] itemsWeight = new int[itemsCount];
        Random random = new Random();
        for (int i = 0; i < itemsCount; i++) {
            itemsWeight[i] = random.nextInt(singleItemMaxWeigh + 1);
        }
        return itemsWeight;
    }
}
