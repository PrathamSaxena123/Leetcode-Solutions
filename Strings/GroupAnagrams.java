import java.util.*;

/**
 * LeetCode 49 - Group Anagrams
 * 
 * This class groups strings that are anagrams of each other.
 * Two strings are anagrams if they contain the same characters
 * with the same frequencies, regardless of their order.
 */
public class GroupAnagrams {

    /**
     * Groups anagrams from the given array of strings.
     *
     * @param strs An array of strings.
     * @return A list of lists where each inner list contains
     *         strings that are anagrams of each other.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        // Edge case: if the input array is null or empty,
        // return an empty list.
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // HashMap to store the mapping between the sorted string (key)
        // and the list of anagrams (value).
        Map<String, List<String>> anagramMap = new HashMap<>();

        // Iterate through each string in the input array.
        for (String str : strs) {

            // Step 1: Convert the string to a character array.
            char[] charArray = str.toCharArray();

            // Step 2: Sort the character array.
            // All anagrams will result in the same sorted sequence.
            Arrays.sort(charArray);

            // Step 3: Convert the sorted character array back to a string.
            // This string will serve as a unique key for the HashMap.
            String key = new String(charArray);

            // Step 4: If the key is not already present in the map,
            // initialize a new list for this key.
            anagramMap.putIfAbsent(key, new ArrayList<>());

            // Step 5: Add the original string to the corresponding list.
            anagramMap.get(key).add(str);
        }

        // Step 6: Convert the map values to a list and return.
        return new ArrayList<>(anagramMap.values());
    }

    /**
     * Main method to test the functionality of the program.
     */
    public static void main(String[] args) {

        // Example input
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Call the method to group anagrams
        List<List<String>> result = groupAnagrams(input);

        // Print the grouped anagrams
        System.out.println("Grouped Anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
