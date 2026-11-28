import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }

    ArrayList<Integer> prefCount(ArrayList<String> s, ArrayList<String> q) {

        TrieNode root = new TrieNode();

        // Insert all strings into the Trie
        for (String word : s) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
                current.count++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Process each query
        for (String query : q) {
            TrieNode current = root;

            for (char ch : query.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    current = null;
                    break;
                }

                current = current.children[index];
            }

            result.add(current == null ? 0 : current.count);
        }

        return result;
    }
}