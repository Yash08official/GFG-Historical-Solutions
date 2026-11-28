# Longest Valid Word with All Prefixes

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/longest-valid-word-with-all-prefixes/1](https://www.geeksforgeeks.org/problems/longest-valid-word-with-all-prefixes/1)  
**Problem ID:** `893334`  
**Slug:** `longest-valid-word-with-all-prefixes`  
**Accepted Submission Date:** `2026-11-28 11:01:01`  

---

## Problem Statement

Given an array of strings** words[]**, find the longest string such that every prefix** **of it is also present in **words[]**. If multiple strings have the same maximum length, return the lexicographically smallest one.

If no such string is found, return an empty string.

Examples:

```text
**Input: **words[] = ["p", "pr", "pro", "probl", "problem", "pros", "process", "processor"]
**Output: **"pros" 
**Explanation: **"pros" is the longest word with all prefixes ("p", "pr", "pro", "pros") present.
```

```text
**Input: **words[] = ["geeks", "gfg", "geeksforgeeks"]
**Output: **""
**Explanation: **No valid strings for all their prefixes present in the words array.
```

**Constraints:
**1 <= words.size <= 1000
1 <= words[i].size <= 100**
**

---

## Solution & Approach

### Approach Explanation

Trie Prefix Validation:
1. Insert all words into a Trie, setting `isEndOfWord = true` at each word termination.
2. For each word in `words`, traverse its characters in the Trie and verify that every intermediate node has `isEndOfWord == true`.
3. A word is valid if all its prefixes exist as complete words in the dictionary.
4. Track the valid word with maximum length, breaking ties using lexicographical order.

### Complexity Analysis
- **Time Complexity:** O(sum |word_i|)
- **Auxiliary Space:** O(sum |word_i|)

---

## Source Code

```java
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
```
