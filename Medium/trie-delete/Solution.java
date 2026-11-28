class Solution {

    public void deleteKey(TrieNode root, String key) {
        delete(root, key, 0);
    }

    private boolean delete(TrieNode current, String key, int index) {

        // Reached the end of the key
        if (index == key.length()) {

            // Key is not present as a complete word
            if (!current.isEndOfWord) {
                return false;
            }

            // Remove the word-ending status
            current.isEndOfWord = false;

            // Check whether this node has any children
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    return false;
                }
            }

            return true;
        }

        int position = key.charAt(index) - 'a';

        // Character path does not exist
        if (current.children[position] == null) {
            return false;
        }

        // Recursively delete the remaining characters
        boolean shouldDelete = delete(
            current.children[position], key, index + 1
        );

        // Remove child only if it is no longer needed
        if (shouldDelete) {
            current.children[position] = null;
        }

        // Current node can be deleted if:
        // 1. It is not the end of another word.
        // 2. It has no remaining children.
        if (current.isEndOfWord) {
            return false;
        }

        for (int i = 0; i < 26; i++) {
            if (current.children[i] != null) {
                return false;
            }
        }

        return true;
    }
}