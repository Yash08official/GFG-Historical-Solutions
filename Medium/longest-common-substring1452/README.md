# Longest Common Substring

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/longest-common-substring1452/1](https://www.geeksforgeeks.org/problems/longest-common-substring1452/1)  
**Problem ID:** `703201`  
**Slug:** `longest-common-substring1452`  
**Topic Tags:** `Strings`, `Dynamic Programming`  
**Accepted Submission Date:** `2026-11-09 17:47:05`  
**Language:** `Java`  

---

## Problem Statement

Given two strings s1 and s2, find the length of the longest common substring between them.

### Examples

```
Input: s1 = "ABCDGH", s2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" of length 4.

Input: s1 = "abc", s2 = "acb"
Output: 1
Explanation: Longest common substrings are "a", "b", "c" of length 1.
```

---

## Approach

- **2D Dynamic Programming:**
  - Let `dp[i][j]` be the length of the longest common suffix of substrings `s1[0..i-1]` and `s2[0..j-1]`.
  - If `s1.charAt(i - 1) == s2.charAt(j - 1)`, then `dp[i][j] = dp[i-1][j-1] + 1`.
  - Else, `dp[i][j] = 0` (contiguous substring breaks).
  - Track `maxLength = max(maxLength, dp[i][j])`.
- **Time Complexity:** $O(n \cdot m)$ where $n = |s1|$ and $m = |s2|$.
- **Space Complexity:** $O(n \cdot m)$ for the 2D DP table.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: b77976463ca5944b2318b0566bfe8c47ba5816ac3c8019900f188defedfa7259`
