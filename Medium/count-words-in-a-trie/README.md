# Count Words in Trie

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-words-in-a-trie/1](https://www.geeksforgeeks.org/problems/count-words-in-a-trie/1)  
**Problem ID:** `876295`  
**Slug:** `count-words-in-a-trie`  
**Accepted Submission Date:** `2026-11-28 11:08:29`  

---

## Problem Statement

Given root** **of a Trie containing multiple words, count the number of words stored in the Trie. A word is considered stored in the Trie if its corresponding terminal node is marked as the end of a word.

**Examples:**
```text
**Input:** root = ["the", "a", "there", "answer", "any", "by", "bye", "their"]
**Output:** 8
**Explanation: **The given array of string is converted into a trie. Now, the number of words in the trie are 8, which is the total number of words given in the array s.

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/932889/Web/Other/blobid0_1786346365.jpg" />

```

```text
**Input:** root = ["go", "good", "pin", "pink", "brown"]
**Output:** 5
**Explanation: **The given array of string is converted into a trie. Now, the number of words in the trie are 5, which is the total number of words given in the array s.

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/932889/Web/Other/blobid1_1786346382.jpg" />

```

---

## Solution & Approach

### Approach Explanation

Tree Traversal (DFS on Trie):
1. Recursively traverse the Trie starting from `root`.
2. If `current.isEndOfWord` is true, increment word counter by 1.
3. Recursively visit all non-null child pointers among the 26 alphabet branches and accumulate their counts.
4. Return the total count of completed words.

### Complexity Analysis
- **Time Complexity:** O(N)
- **Auxiliary Space:** O(H)

---

## Source Code

```java
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
```
