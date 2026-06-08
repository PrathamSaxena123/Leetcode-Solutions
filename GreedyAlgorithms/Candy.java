class Solution {

    public int candy(int[] ratings) {

        int n = ratings.length;

        // Every child gets at least 1 candy
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Left → Right pass
        // If current rating is greater than previous rating,
        // give one more candy than previous child
        for (int i = 1; i < n; i++) {

            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right → Left pass
        // Ensure right-side condition is also satisfied
        for (int i = n - 2; i >= 0; i--) {

            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(
                    candies[i],
                    candies[i + 1] + 1
                );
            }
        }

        // Calculate total candies
        int total = 0;

        for (int candy : candies) {
            total += candy;
        }

        return total;
    }
}
