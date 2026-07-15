import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public String predictPartyVictory(String senate) {

        // Queue to store the indices of Radiant senators
        Queue<Integer> radiant = new LinkedList<>();

        // Queue to store the indices of Dire senators
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        // Store the initial positions of all senators
        for (int i = 0; i < n; i++) {

            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        // Continue until one party has no remaining senators
        while (!radiant.isEmpty() && !dire.isEmpty()) {

            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            // The senator with the smaller index acts first
            // and bans the opposing senator
            if (rIndex < dIndex) {

                // Radiant senator survives to the next round
                radiant.add(rIndex + n);

            } else {

                // Dire senator survives to the next round
                dire.add(dIndex + n);
            }
        }

        // The remaining party wins
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
