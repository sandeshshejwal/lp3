// Write a program to solve a 0-1 Knapsack problem using dynamic programming or branch and bound strategy.
class Item {
    int value;
    int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Knapsack_4 {

    public static int knapSack_01(int W, Item[] arr) {
        int n = arr.length;
        int[][] K = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (arr[i - 1].weight <= w) {
                    int wt = arr[i - 1].weight;
                    int val = arr[i - 1].value;
                    K[i][w] = Math.max(val + K[i - 1][w - wt], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        return K[n][W];
    }

    public static void main(String[] args) {
        int W = 100;
        Item[] arr = {new Item(10, 20), new Item(20, 30), new Item(30, 66), new Item(40, 40), new Item(50, 60)};
        
        System.out.println("Knapsack Capacity: " + W);
        System.out.println("Maximum Profit: " + knapSack_01(W, arr));
    }
}
