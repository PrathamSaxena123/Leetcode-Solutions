public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // Edge case: if there are no prices or only one day, no transaction can happen
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // Initialize minPrice to a very high value and maxProfit to 0
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Traverse through the prices array
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // Update the lowest price found so far
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                // If selling today yields a higher profit, update maxProfit
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    // Optional main method to test your solution locally
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();
        
        int[] samplePrices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + solver.maxProfit(samplePrices)); // Output: 5 (Buy at 1, Sell at 6)
    }
}
