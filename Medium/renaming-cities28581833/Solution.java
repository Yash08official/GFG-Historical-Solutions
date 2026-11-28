import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }

    public ArrayList<String> renameCities(String[] cities) {

        TrieNode root = new TrieNode();

        HashMap<String, Integer> frequency = new HashMap<>();

        ArrayList<String> result = new ArrayList<>();

        for (String city : cities) {

            int occurrence = frequency.getOrDefault(city, 0) + 1;
            frequency.put(city, occurrence);

            // Handle repeated cities
            if (occurrence > 1) {
                result.add(city + " " + occurrence);
                continue;
            }

            // Step 1: Insert the COMPLETE city into Trie
            TrieNode current = root;

            for (char ch : city.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
                current.count++;
            }

            // Step 2: Find the shortest unique prefix
            current = root;

            StringBuilder prefix = new StringBuilder();

            for (char ch : city.toCharArray()) {

                int index = ch - 'a';

                current = current.children[index];

                prefix.append(ch);

                if (current.count == 1) {
                    break;
                }
            }

            result.add(prefix.toString());
        }

        return result;
    }
}