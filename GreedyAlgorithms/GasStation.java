class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        // Total gas surplus/deficit across all stations
        int totalTank = 0;

        // Current gas available while testing a starting station
        int currentTank = 0;

        // Candidate starting station
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {

            // Net gain/loss at this station
            int netGas = gas[i] - cost[i];

            totalTank += netGas;
            currentTank += netGas;

            // Cannot reach next station
            if (currentTank < 0) {

                // Any station between startingStation and i
                // cannot be a valid answer
                startingStation = i + 1;

                // Reset current tank for new candidate
                currentTank = 0;
            }
        }

        // If total gas is negative,
        // completing the circuit is impossible
        return totalTank >= 0 ? startingStation : -1;
    }
}
