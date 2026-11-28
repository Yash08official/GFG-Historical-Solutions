import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }

    public ArrayList<Integer> kLengthPref(String[] arr,
                                          String[] queryStr,
                                          int[] queryK) {

        TrieNode root = new TrieNode();

        // Step 1: Insert all strings into Trie.
        for (String word : arr) {

            TrieNode current = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];

                // Count strings having this prefix.
                current.count++;
            }
        }

        // Step 2: Process all queries.
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < queryStr.length; i++) {

            TrieNode current = root;
            int k = queryK[i];

            // Traverse only the first k characters.
            for (int j = 0; j < k; j++) {

                int index = queryStr[i].charAt(j) - 'a';

                if (current.children[index] == null) {
                    current = null;
                    break;
                }

                current = current.children[index];
            }

            // Step 3: Store the answer.
            if (current == null) {
                result.add(0);
            } else {
                result.add(current.count);
            }
        }

        return result;
    }
}