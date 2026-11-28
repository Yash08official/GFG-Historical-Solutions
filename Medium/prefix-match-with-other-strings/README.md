# K Length Prefix Matches

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/prefix-match-with-other-strings/1](https://www.geeksforgeeks.org/problems/prefix-match-with-other-strings/1)  
**Problem ID:** `706301`  
**Slug:** `prefix-match-with-other-strings`  
**Accepted Submission Date:** `2026-11-28 10:56:27`  

---

## Problem Statement

Given an array of strings **arr[]**, a string array **queryStr[]**, and an integer array **queryK[]**, where queryStr[i] represents the string for the ith query and queryK[i] represents an integer k for that query, find the number of strings in arr[] whose first k characters are exactly the same as the first k characters of queryStr[i].

Return an array containing the count for each query.

**Examples:**

```text
**Input: **arr[] = ["abba", "abbb", "abbc", "abbd", "abaa", "abca"], queryStr[] = ["abbg", "abz", "geeks"], queryK[] = [3, 2, 5]
**Output: **[4, 6, 0]
**Explanation:**
For query 1:
queryStr[0] = "abbg", queryK[0] = 3.
The 3-length prefix is "abb". The strings "abba", "abbb", "abbc"
and "abbd" have the same prefix. Hence, the count is 4.

For query 2:
queryStr[1] = "abz", queryK[1] = 2.
The 2-length prefix is "ab". All 6 strings — "abba", "abbb", "abbc",
"abbd", "abaa" and "abca" — have the same prefix. Hence, the count is 6.

For query 3:
queryStr[2] = "geeks", queryK[2] = 5.
The 5-length prefix is "geeks". No string in arr[] has this prefix.
Hence, the count is 0.
```

```text
**Input: **arr[] = ["geeks", "geeksforgeeks", "forgeeks"], queryStr[] = ["ge", "geeks", "for"], queryK[] = [2, 3, 2]
**Output: **[2, 2, 1]
**Explanation:**
For query 1:
queryStr[0] = "ge", queryK[0] = 2.
The 2-length prefix is "ge". Both "geeks" and "geeksforgeeks"
have the same prefix. Hence, the count is 2.

For query 2:
queryStr[1] = "geeks", queryK[1] = 3.
The 3-length prefix is "gee". Both "geeks" and "geeksforgeeks"
have the same prefix. Hence, the count is 2.

For query 3:
queryStr[2] = "for", queryK[2] = 2.
The 2-length prefix is "fo". Only "forgeeks" has this prefix.
Hence, the count is 1.
```

**Constraints:
**1 ≤ n ≤ 104
1 ≤ q ≤ 104
1 ≤ |arr[i]| ≤ 100
1 ≤ |queryStr[i]| ≤ 100
1 ≤ queryK[i] ≤ |queryStr[i]|
arr[i] and queryStr[i] contain only lowercase English alphabets.
queryStr.size() = queryK.size() = q

---

## Solution & Approach

### Approach Explanation

Trie Prefix Frequency Lookup:
1. Insert all strings from array `arr` into a Trie, maintaining a `count` at each Trie node.
2. For each query (queryStr[i], k), traverse only the first k characters of queryStr[i] in the Trie.
3. If the path terminates before k steps, return 0; otherwise return the `count` at the k-th node.

### Complexity Analysis
- **Time Complexity:** O(sum |arr_i| + sum k_j)
- **Auxiliary Space:** O(sum |arr_i|)

---

## Source Code

```java
import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }

    public ArrayList<Integer> kLengthPref(String[] arr,
                                          String[] queryStr,
                                          int[] queryK) {

        TrieNode root = new TrieNode();

        // Step 1: Insert all strings into Trie.
        for (String word : arr) {

            TrieNode current = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];

                // Count strings having this prefix.
                current.count++;
            }
        }

        // Step 2: Process all queries.
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < queryStr.length; i++) {

            TrieNode current = root;
            int k = queryK[i];

            // Traverse only the first k characters.
            for (int j = 0; j < k; j++) {

                int index = queryStr[i].charAt(j) - 'a';

                if (current.children[index] == null) {
                    current = null;
                    break;
                }

                current = current.children[index];
            }

            // Step 3: Store the answer.
            if (current == null) {
                result.add(0);
            } else {
                result.add(current.count);
            }
        }

        return result;
    }
}
```
