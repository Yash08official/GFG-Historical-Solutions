# Implement Trie

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/trie-insert-and-search0651/1](https://www.geeksforgeeks.org/problems/trie-insert-and-search0651/1)  
**Problem ID:** `701748`  
**Slug:** `trie-insert-and-search0651`  
**Accepted Submission Date:** `2026-11-28 10:51:37`  

---

## Problem Statement

Implement the **Trie** class with the following functions:

- **insert(word)**: Inserts the string word into the trie.

- **search(word)**: Returns true if word exists in the trie; otherwise returns false.

- **isPrefix(word)**: Returns true if word is a prefix of at least one string stored in the trie; otherwise returns false.

For input, the driver uses a 2D array **query[][]**, where each query is one of the following:

- Type 1: [1, word] -> Calls insert(word).

- Type 2: [2, word] -> Calls search(word) and stores the returned value.

- Type 3: [3, word] -> Calls isPrefix(word) and stores the returned value.

The output consists of the results of all Type 2 and Type 3 queries in the order they are processed.

**Examples :**

```text
**Input: **query[][] = [[1, "abcd"], [1, "abc"], [1, "bcd"], [2, "bc"], [3, "bc"], [2, "abc"]]
**Output: **[false, true, true]
**Explanation: **string "bc" does not exist in the trie, "bc" exists as prefix of the word "bcd" in the trie, and "abc" also exists in the trie.
```

```text
**Input: **query[][] = [[1, "gfg"], [1, "geeks"], [3, "fg"], [3, "geek"], [2, "for"]]
**Output:** [false, true, false]
**Explanation:** The string "for" is not present in the trie, "fg" is not a valid prefix, while "geek" is a valid prefix of the word "geeks" in the trie.
```

**Constraints:
**1 ≤ query.size() ≤ 104
1 ≤ word.size() ≤ 103

---

## Solution & Approach

### Approach Explanation

Standard 26-ary Trie Implementation:
1. Define `TrieNode` with an array `children = new TrieNode[26]` and boolean flag `isEndOfWord`.
2. `insert(word)`: Traverse characters ch - 'a', instantiating missing nodes, and mark `isEndOfWord = true` at completion.
3. `search(word)`: Traverse characters; return true if path exists and final node has `isEndOfWord == true`.
4. `isPrefix(word)`: Traverse characters; return true if the entire path exists regardless of `isEndOfWord`.

### Complexity Analysis
- **Time Complexity:** O(|word|)
- **Auxiliary Space:** O(sum |word| * 26)

---

## Source Code

```java
class Trie {

    // Each node represents one character.
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private TrieNode root;

    // Create an empty Trie.
    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie.
    public void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        // Mark the end of the complete word.
        current.isEndOfWord = true;
    }

    // Search for a complete word.
    public boolean search(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isEndOfWord;
    }

    // Check whether a prefix exists.
    public boolean isPrefix(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return true;
    }
}
```
