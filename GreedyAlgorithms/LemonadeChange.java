class Solution {

    public boolean lemonadeChange(int[] bills) {

        // Count of $5 and $10 bills currently available
        int fives = 0;
        int tens = 0;

        // Process each customer
        for (int bill : bills) {

            // Customer pays with $5
            if (bill == 5) {

                fives++;
            }

            // Customer pays with $10
            else if (bill == 10) {

                // Need one $5 as change
                if (fives == 0) {
                    return false;
                }

                fives--;
                tens++;
            }

            // Customer pays with $20
            else {

                // Prefer giving:
                // one $10 + one $5
                if (tens > 0 && fives > 0) {

                    tens--;
                    fives--;
                }

                // Otherwise give:
                // three $5 bills
                else if (fives >= 3) {

                    fives -= 3;
                }

                // Cannot provide change
                else {

                    return false;
                }
            }
        }

        // Successfully served everyone
        return true;
    }
}
