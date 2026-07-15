import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        Arrays.sort(frequencies);
        
        int maxFrequency = frequencies[25];
        int idleSlots = (maxFrequency - 1) * n;
        
        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            idleSlots -= Math.min(maxFrequency - 1, frequencies[i]);
        }
        
        idleSlots = Math.max(0, idleSlots);
        
        return tasks.length + idleSlots;
    }
}
