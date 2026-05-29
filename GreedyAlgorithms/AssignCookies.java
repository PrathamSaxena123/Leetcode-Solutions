class Solution {

    public int findContentChildren(int[] g, int[] s) {

        // If no children or no cookies
        if (g.length == 0 || s.length == 0) {
            return 0;
        }

        // Sort greed factors
        Arrays.sort(g);

        // Sort cookie sizes
        Arrays.sort(s);

        // i -> children pointer
        int i = 0;

        // j -> cookie pointer
        int j = 0;

        while (i < g.length &&
               j < s.length) {

            // Current cookie can satisfy child
            if (s[j] >= g[i]) {

                // Child is satisfied
                i++;
            }

            // Move to next cookie
            j++;
        }

        // Number of satisfied children
        return i;
    }
}
