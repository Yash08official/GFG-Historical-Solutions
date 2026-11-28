# Longest Word with All Prefixes Present

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-the-longest-string--170645/1](https://www.geeksforgeeks.org/problems/find-the-longest-string--170645/1)  
**Problem ID:** `713369`  
**Slug:** `find-the-longest-string--170645`  
**Accepted Submission Date:** `2026-11-28 10:55:06`  

---

## Problem Statement

Given an array of strings **words****[]**. Find the longest word in words[] such that every prefix of it is also present in the array words[]. 

**Note: **If multiple strings have the same maximum length, return the lexicographically smallest one.

**Examples:**
```text
**Input:** words[] = ["p", "pr", "pro", "probl", "problem", "pros", "process", "processor"]
**Output:** pros
**Explanation: **"pros" is the longest word with all prefixes ("p", "pr", "pro", "pros") present in the array words[].
```

```text
**Input: **words[] = ["ab", "a", "abc", "abd"]
**Output: **abc
**Explanation:** Both "abc" and "abd" has all the prefixes in words[]. Since, "abc" is lexicographically smaller than "abd", so the output is "abc".

```

---

## Solution & Approach

### Approach Explanation

Trie Prefix Validation:
1. Insert all candidate words into a Trie, marking `isEndOfWord = true` at the final node.
2. For each word, traverse character-by-character and confirm that every intermediate prefix has `isEndOfWord == true`.
3. Select the valid word with the longest length, breaking length ties with lexicographically smallest comparison.

### Complexity Analysis
- **Time Complexity:** O(sum |words_i|)
- **Auxiliary Space:** O(sum |words_i|)

---

## Source Code

```java
class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    public String longestString(String[] words) {

        TrieNode root = new TrieNode();

        // Step 1: Insert all words into Trie.
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

        // Step 2: Check every word.
        for (String word : words) {

            TrieNode current = root;
            boolean valid = true;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                current = current.children[index];

                // Every prefix must be a complete word.
                if (current == null || !current.isEndOfWord) {
                    valid = false;
                    break;
                }
            }

            // Step 3: Update the answer.
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
