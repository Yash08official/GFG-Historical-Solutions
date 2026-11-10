# Maximum Index

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/maximum-index-1587115620/1](https://www.geeksforgeeks.org/problems/maximum-index-1587115620/1)  
**Problem ID:** `701209`  
**Slug:** `maximum-index-1587115620`  
**Topic Tags:** `Arrays`, `two-pointer-algorithm`  
**Accepted Submission Date:** `2026-11-09 17:38:36`  
**Language:** `Java`  

---

## Problem Statement

Given an array arr[] of positive integers, find the maximum index difference (j - i) such that arr[i] <= arr[j] and i <= j.

### Examples

```
Input: arr[] = [34, 8, 10, 3, 2, 80, 30, 33, 1]
Output: 6
Explanation: For i = 1 (arr[1] = 8) and j = 7 (arr[7] = 33), arr[1] <= arr[7] and j - i = 6.

Input: arr[] = [1, 2, 3, 4, 5, 6]
Output: 5
Explanation: For i = 0 and j = 5, arr[0] <= arr[5] and j - i = 5.
```

---

## Approach

- **Prefix Min & Suffix Max with Two Pointers:**
  - Construct `leftMin[]` where `leftMin[i]` is minimum in `arr[0..i]`.
  - Construct `rightMax[]` where `rightMax[j]` is maximum in `arr[j..n-1]`.
  - Two pointers `i = 0, j = 0`:
    - If `leftMin[i] <= rightMax[j]`: update `maxDiff = max(maxDiff, j - i)` and advance `j`.
    - Else: advance `i`.
- **Time Complexity:** $O(n)$ linear traversal.
- **Space Complexity:** $O(n)$ for prefix/suffix arrays.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 3da33ecf90e9b152ef193043784c3b3ebc0306aab0d206a524dbb57ff74a50c8`
