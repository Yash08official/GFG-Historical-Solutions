class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    public int countMatches(String[] d, String[] words) {

        TrieNode root = new TrieNode();

        // Insert dictionary words into Trie
        for (String word : d) {

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

        int answer = 0;

        // Check every search pattern
        for (String pattern : words) {

            if (search(root, pattern, 0)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean search(TrieNode current, String pattern, int index) {

        // All pattern characters have been processed
        if (index == pattern.length()) {
            return current.isEndOfWord;
        }

        char ch = pattern.charAt(index);

        // Dot can match any one character
        if (ch == '.') {

            for (int i = 0; i < 26; i++) {

                if (current.children[i] != null) {

                    if (search(current.children[i], pattern, index + 1)) {
                        return true;
                    }
                }
            }

            return false;
        }

        // Normal character: follow only the matching child
        int position = ch - 'a';

        if (current.children[position] == null) {
            return false;
        }

        return search(current.children[position], pattern, index + 1);
    }
}