class Solution {
    public int maxProfit(int k, int[] prices) {
        // If no prices, empty array, or no transactions allowed, return 0 profit
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        
        int n = prices.length;
        
        // If k is large enough, we can make as many transactions as we want
        // This is equivalent to buying at every valley and selling at every peak
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                // Add profit whenever price increases from previous day
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        
        // buy[j] represents max profit after j-th buy (currently holding stock)
        // sell[j] represents max profit after j-th sell (not holding stock)
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        
        // Initialize buy array to negative infinity since we start with no stock
        for (int i = 0; i <= k; i++) {
            buy[i] = Integer.MIN_VALUE;
            sell[i] = 0;
        }
        
        // Iterate through each day's price
        for (int price : prices) {
            // For each transaction number from 1 to k
            for (int j = 1; j <= k; j++) {
                // Either keep previous buy state or buy now (using profit from previous sell)
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                
                // Either keep previous sell state or sell now (adding current price to buy state)
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }
        
        // Return maximum profit after completing at most k transactions
        return sell[k];
    }
}
