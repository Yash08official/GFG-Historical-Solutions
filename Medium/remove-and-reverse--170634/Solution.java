import java.util.*;

class Solution {
    String removeReverse(String s) {

        LinkedList<Character> list = new LinkedList<>();
        int[] freq = new int[26];

        // Store characters and calculate frequencies
        for (char ch : s.toCharArray()) {
            list.add(ch);
            freq[ch - 'a']++;
        }

        boolean reversed = false;

        while (true) {

            // Traverse according to the current direction
            Iterator<Character> it;

            if (reversed) {
                it = list.descendingIterator();
            } else {
                it = list.iterator();
            }

            boolean found = false;

            while (it.hasNext()) {
                char ch = it.next();

                // Find the first repeating character
                if (freq[ch - 'a'] > 1) {

                    // Remove its first occurrence
                    it.remove();

                    // Update frequency
                    freq[ch - 'a']--;

                    found = true;
                    break;
                }
            }

            // Stop if no repeating character exists
            if (!found) {
                break;
            }

            // Reverse the logical direction
            reversed = !reversed;
        }

        // Construct the final string
        StringBuilder result = new StringBuilder();

        if (reversed) {
            Iterator<Character> it = list.descendingIterator();

            while (it.hasNext()) {
                result.append(it.next());
            }
        } else {
            for (char ch : list) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}