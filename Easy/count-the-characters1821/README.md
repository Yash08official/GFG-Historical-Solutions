# Count Group Occurrences

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-the-characters1821/1](https://www.geeksforgeeks.org/problems/count-the-characters1821/1)  
**Problem ID:** `703057`  
**Slug:** `count-the-characters1821`  
**Topic Tags:** `Strings`  
**Accepted Submission Date:** `2026-11-09 10:04:07`  
**Language:** `Java`  

---

## Problem Statement

Given a string `s` and an integer `k`, count the number of distinct characters that appear in exactly `k` groups in the string.

A group is defined as one or more consecutive occurrences of the same character. For example, in the string `"aaabbcca"`, the groups are `"aaa"`, `"bb"`, `"cc"`, and `"a"`.

### Examples

```
Input: s = "abc", k = 1
Output: 3
Explanation: The characters 'a', 'b', and 'c' each appear in exactly one group.
```

```
Input: s = "geeksforgeeks", k = 2
Output: 4
Explanation: The characters 'g', 'e', 'k', and 's' each appear in exactly two groups.
```

```
Input: s = "aaaaa", k = 2
Output: 0
Explanation: The character 'a' appears in only one group, so no character appears in exactly two groups.
```

---

## Approach

- **Linear Traversal & Group Frequency Counting:**
  - A new group starts at index `0` and at any subsequent index `i` where `s.charAt(i) != s.charAt(i - 1)`.
  - Maintain a frequency array `freq` of size 26 for lowercase English letters.
  - Traverse `s` from left to right; whenever a new consecutive group starts, increment `freq[s.charAt(i) - 'a']`.
  - Finally, iterate through all 26 lowercase characters and count how many have `freq[i] == k`.
- **Time Complexity:** $O(|s| + 26) = O(|s|)$ single pass through the string.
- **Space Complexity:** $O(1)$ constant auxiliary space (fixed-size array of 26 integers).

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: b4e0f12be9d6adc11773718095d15279816334df68fb7d7785a61c8699751800`
