# Pairs with 0 Sum

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1](https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1)  
**Problem ID:** `703284`  
**Slug:** `count-pairs-with-given-sum5022`  
**Topic Tags:** `Arrays`, `Sorting`, `two-pointer-algorithm`  
**Accepted Submission Date:** `2026-11-09 17:29:19`  
**Language:** `Java`  

---

## Problem Statement

Given an integer array arr[], find all unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0. Pairs must be sorted.

### Examples

```
Input: arr[] = [-1, 0, 1, 2, -1, -4]
Output: [[-1, 1]]
Explanation: Only [-1, 1] satisfies the condition arr[i] + arr[j] == 0 with distinct pair values.

Input: arr[] = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
Output: [[-6, 6], [-1, 1]]
Explanation: Pairs with zero sum are [-6, 6] and [-1, 1].
```

---

## Approach

- **Sorting & Two Pointers:**
  - Sort `arr[]` in ascending order.
  - Place `left = 0` and `right = arr.length - 1`.
  - If `arr[left] + arr[right] == 0`, add `[arr[left], arr[right]]` to the result, then advance `left` past identical elements and decrement `right` past identical elements to avoid duplicate pairs.
  - If sum < 0, advance `left`.
  - If sum > 0, decrement `right`.
- **Time Complexity:** $O(n \log n)$ due to sorting.
- **Space Complexity:** $O(1)$ auxiliary space.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: b54f0fd33e074af99f077460ef8baaa30f6a564271d97ed2c535b0082dc3ea92`
