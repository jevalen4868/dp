package org.j01.knapsack;

public class KnapsackSolution {
    // total items
    private int n;
    private int capacity;
    // dp table
    private int[][] dp;
    private int[] weights;
    private int[] values;

    public KnapsackSolution(int n, int capacity, int[] weights, int[] values) {
        this.n = n;
        this.capacity = capacity;
        this.weights = weights;
        this.values = values;
        dp = new int[n + 1][capacity + 1];
    }

    public int solve() {
        for(int i = 1; i < n + 1; i++) {
            for(int w = 1; w < capacity + 1; w++) {
                // whether to take item i or not.
                int notTaking = dp[i - 1][w];
                int taking = 0;
                if(weights[i] <= w) {
                    taking = values[i] + dp[i - 1][w - weights[i]];
                }
                // memoization
                dp[i][w] = Math.max(notTaking, taking);
            }
        }

        System.out.println("Max profit: " + dp[n][capacity]);

        // what items are we taking?
        for(int i = n, w = capacity; i > 0; i--) {
            if(dp[i][w] != 0 && dp[i][w] != dp[i - 1][w]) {
                System.out.println("We take item: #" + i);
                w = w - weights[i];
            }
        }

        return dp[n][capacity];
    }
}
