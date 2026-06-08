import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> readBinaryWatch(int turnedOn) {

        List<String> result = new ArrayList<>();

        // Check every possible valid time
        for (int h = 0; h < 12; h++) {

            for (int m = 0; m < 60; m++) {

                // Count LEDs turned on in hour and minute
                int ledsOn =
                    Integer.bitCount(h) +
                    Integer.bitCount(m);

                // Valid time if LED count matches
                if (ledsOn == turnedOn) {

                    // Format minutes with leading zero
                    result.add(
                        String.format("%d:%02d", h, m)
                    );
                }
            }
        }

        return result;
    }
}
