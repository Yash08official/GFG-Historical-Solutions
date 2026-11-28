# Trie Delete

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/trie-delete/1](https://www.geeksforgeeks.org/problems/trie-delete/1)  
**Problem ID:** `700449`  
**Slug:** `trie-delete`  
**Accepted Submission Date:** `2026-11-28 11:02:04`  

---

## Problem Statement

Given a Trie containing lowercase English words and a string **key**, delete the given key from the Trie. If the key is not present, the Trie should remain unchanged.

**Note: **The driver code inserts all strings from words[] into the Trie, calls deleteKey(root, key), and prints all the words remaining in the Trie.

**Examples:**
```text
**Input: **words[] = ["gfg", "geeks", "practice"], key = "geeks"
**Output: **["gfg", "practice"]
**Explanation:**** **The key "geeks" is deleted from the Trie
```

```text
**Input: **words[] = ["the", "a", "there", "answer", "any", "by", "bye", "their"], key = "the"
**Output: **["a", "there", "answer", "any", "by", "bye", "their"]**  
****Explanation: **The key "the" is removed from the Trie. The nodes that are shared with other strings, such as "there" and "their", are preserved because those strings still exist in the Trie. 
```

**Constraints:**
1 ≤ words.size() ≤ 104
1 ≤ |key| ≤ 50

---

## Solution & Approach

### Approach Explanation

Recursive Post-Order Trie Pruning:
1. Recursively search down to the end of `key` in the Trie.
2. If `key` is present as a complete word, unset `isEndOfWord = false`.
3. During the return phase (post-order traversal), determine if the current child node has become useless (i.e. `!isEndOfWord` and all 26 children are null).
4. If useless, prune the child by setting the parent pointer to null.

### Complexity Analysis
- **Time Complexity:** O(|key|)
- **Auxiliary Space:** O(|key|)

---

## Source Code

```java
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
```
