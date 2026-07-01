class Solution {

    public boolean isIsomorphic(String s, String t) {

        // Strings of different lengths can never be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Arrays to store the last seen position of each character
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        // Traverse both strings together
        for (int i = 0; i < s.length(); i++) {

            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // If the last occurrence positions differ,
            // the mapping is inconsistent
            if (mapS[charS] != mapT[charT]) {
                return false;
            }

            // Store the current position (+1 because default value is 0)
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }

        // All mappings are consistent
        return true;
    }
}
