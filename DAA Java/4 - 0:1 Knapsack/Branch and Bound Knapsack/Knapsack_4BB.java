public class Knapsack_4BB {

    static int knapSack(int W, int[] weights, int[] values, int n) {
        int[][] K = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    K[i][w] = Math.max(values[i - 1] + K[i - 1][w - weights[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        return K[n][W];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        int n = values.length;
        System.out.println("Maximum value that can be obtained: " + knapSack(W, weights, values, n));
    }
}
