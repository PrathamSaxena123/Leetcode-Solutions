class Solution {

    public int maxProfit(int[] prices) {

        // Stores total profit earned
        int maxProfit = 0;

        // Start from Day 2
        for (int i = 1; i < prices.length; i++) {

            // If price increased compared to yesterday,
            // capture that profit
            if (prices[i] > prices[i - 1]) {

                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
