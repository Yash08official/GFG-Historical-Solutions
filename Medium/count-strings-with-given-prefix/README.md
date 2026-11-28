# Count Strings with Given Prefix

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-strings-with-given-prefix/1](https://www.geeksforgeeks.org/problems/count-strings-with-given-prefix/1)  
**Problem ID:** `705485`  
**Slug:** `count-strings-with-given-prefix`  
**Accepted Submission Date:** `2026-11-28 10:59:44`  

---

## Problem Statement

Given an array of strings **s[]** and an array of query strings **q[]**, where all strings consist of lowercase English letters. For each query string q[i], find the number of strings in s[] that have q[i] as a **prefix**.

Return an array res[] such that res[i] denotes the number of strings in s[] that have prefix q[i].

**Examples :**

```text
**Input: **s[] = ["abracadabra", "geeksforgeeks", "abracadabra", "geeks", "geeksthrill"]
q[] = ["abr", "geeks", "ge", "gar"]
**Output:** [2, 3, 3, 0]
**Explanation: **For each query:**  **
"abr" is a prefix of both occurrences of "**abr**acadabra", so the count is **2**.
"geeks" is a prefix of "**geeks**forgeeks", "**geeks**", and "**geeks**thrill", so the count is **3**.
"ge" is a prefix of "**ge**eksforgeeks", "**ge**eks", and "**ge**eksthrill", so the count is **3**.
"gar" is **not** a prefix of any string in s[], so the count is **0**.
```

```text
**Input:** s[] = ["apple", "app", "banana", "application"]
q[] = ["ap", "ban"]
**Output: **[3, 1]
**Explanation: **For each query: 
"ap" is a prefix of "**ap**ple", "**ap**p", and "**ap**plication", so the count is 3.
"ban" is a prefix of "**ban**ana", so the count is 1.
```

**Constraints:**
1 ≤ s.size() ≤ 104
1 ≤ q.size() ≤ 104
1 ≤ |s[i]|, |q[i]| ≤ 100

---

## Solution & Approach

### Approach Explanation

Trie Node Subtree Counting:
1. Build a Trie where each node maintains a `count` field indicating how many strings pass through or end in its subtree.
2. Insert each word in list `s`, incrementing `node.count` at each step.
3. For each query prefix in `q`, traverse the Trie following the prefix characters. If the prefix exists, the answer is `current.count`; otherwise 0.

### Complexity Analysis
- **Time Complexity:** O(sum |s_i| + sum |q_j|)
- **Auxiliary Space:** O(sum |s_i|)

---

## Source Code

```java
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
```
