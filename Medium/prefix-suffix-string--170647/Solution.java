import java.util.*;

class Solution {
    public int countPrefixSuffix(String[] s1, String[] s2) {
        HashSet<String> prefixes = new HashSet<>();
        HashSet<String> suffixes = new HashSet<>();

        // Store all prefixes and suffixes of strings in s1
        for (String word : s1) {
            for (int i = 1; i <= word.length(); i++) {
                prefixes.add(word.substring(0, i));
                suffixes.add(word.substring(word.length() - i));
            }
        }

        int count = 0;

        // Check each string in s2
        for (String word : s2) {
            if (prefixes.contains(word) || suffixes.contains(word)) {
                count++;
            }
        }

        return count;
    }
}