class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    public String longestValidWord(String[] words) {

        TrieNode root = new TrieNode();

        // Insert all words into Trie
        for (String word : words) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.isEndOfWord = true;
        }

        String answer = "";

        // Check which words have all prefixes present
        for (String word : words) {
            TrieNode current = root;
            boolean valid = true;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                current = current.children[index];

                if (current == null || !current.isEndOfWord) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                if (word.length() > answer.length() ||
                    (word.length() == answer.length() &&
                     word.compareTo(answer) < 0)) {

                    answer = word;
                }
            }
        }

        return answer;
    }
}