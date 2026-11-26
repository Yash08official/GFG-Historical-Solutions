import java.util.*;

class Solution {

    public String firstNonRepeating(String s) {

        int[] freq = new int[26];

        Queue<Character> queue = new LinkedList<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Step 1: Update frequency
            freq[ch - 'a']++;

            // Step 2: Add current character to queue
            queue.add(ch);

            // Step 3: Remove repeating characters from the front
            while (!queue.isEmpty() &&
                   freq[queue.peek() - 'a'] > 1) {

                queue.poll();
            }

            // Step 4: Get the first non-repeating character
            if (queue.isEmpty()) {
                result.append('#');
            } else {
                result.append(queue.peek());
            }
        }

        return result.toString();
    }
}