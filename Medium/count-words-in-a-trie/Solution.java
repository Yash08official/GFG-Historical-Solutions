class Solution {

    int wordCount(TrieNode root) {

        if (root == null) {
            return 0;
        }

        int count = 0;

        // Check whether the current node marks a complete word
        if (root.isEndOfWord) {
            count++;
        }

        // Visit all child nodes
        for (int i = 0; i < 26; i++) {

            if (root.children[i] != null) {
                count += wordCount(root.children[i]);
            }
        }

        return count;
    }
}