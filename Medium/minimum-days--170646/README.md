# Minimum Days

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/minimum-days--170646/1](https://www.geeksforgeeks.org/problems/minimum-days--170646/1)  
**Problem ID:** `713590`  
**Slug:** `minimum-days--170646`  
**Topic Tags:** `Strings`, `Permutation`  
**Accepted Submission Date:** `2026-11-05 20:31:55`  
**Language:** `Java`  

---

## Problem Statement

Given a string `s` of length `n` containing only lowercase English letters, and a permutation array `p[]` of length `n` containing integers from `0` to `n - 1`. 

On the `(i + 1)`th day, the character at index `p[i]` in the string is replaced with `'?'`.

Find the minimum number of days required so that no two adjacent characters in `s` are equal, unless at least one of them is `'?'`.

Formally, for every index `i` (`0 <= i < n - 1`), the string must satisfy: If `s[i] != '?'` and `s[i+1] != '?'`, then `s[i] != s[i+1]`.

### Examples

```
Input: s = "aabb", p = [2, 1, 3, 0]
Output: 2
Explanation:
On Day 1, we replace s[p[0]] (index 2) with '?'. String becomes "aa?b". Index 0 and 1 still have equal adjacent characters 'a'.
On Day 2, we replace s[p[1]] (index 1) with '?'. String becomes "a??b". Now no two adjacent non-'?' characters are equal.
```

```
Input: s = "abca", p = [3, 0, 2, 1]
Output: 0
Explanation:
The initial string "abca" already satisfies the condition without replacing any characters.
```

---

## Approach

- **Binary Search on Answer:** The condition of whether the string becomes valid after `mid` days is monotonic: if it is valid after `mid` days, it remains valid for all days `> mid`.
- We binary search the number of days in range `[1, n]`.
- For each `mid`, mark elements `p[0 ... mid - 1]` as removed and check if any adjacent non-removed elements are identical in `O(n)` time.
- **Time Complexity:** `O(n log n)`
- **Space Complexity:** `O(n)` auxiliary boolean array for removed tracking

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 42478100dd4ad4b5b018fa49d70fe34c15a9aebae1762608edf2bbd5407f5fe1`
