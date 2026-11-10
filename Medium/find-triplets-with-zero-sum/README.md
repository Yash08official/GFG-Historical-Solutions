# Check Triplet With 0 Sum

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1](https://www.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1)  
**Problem ID:** `700466`  
**Slug:** `find-triplets-with-zero-sum`  
**Topic Tags:** `two-pointer-algorithm`, `Arrays`, `Searching`, `Hash`, `Sorting`  
**Accepted Submission Date:** `2026-11-09 17:45:27`  
**Language:** `Java`  

---

## Problem Statement

Given an array arr[] of n integers, determine whether it contains a triplet whose sum equals zero.

### Examples

```
Input: arr[] = [0, -1, 2, -3, 1]
Output: true
Explanation: The triplet [0, -1, 1] has a sum equal to zero.

Input: arr[] = [1, 2, 3]
Output: false
Explanation: No triplet with sum zero exists.
```

---

## Approach

- **Sorting & Two-Pointer Triplet Search:**
  - Sort `arr[]` in ascending order.
  - Fix the first element `arr[i]` from `0` to `n - 3`.
  - Use two pointers `left = i + 1` and `right = n - 1`.
  - Calculate `sum = (long)arr[i] + arr[left] + arr[right]`.
  - If `sum == 0`, return `true`.
  - If `sum < 0`, advance `left++`.
  - If `sum > 0`, decrement `right--`.
  - Return `false` if no such triplet is found.
- **Time Complexity:** $O(n^2)$ sorting + two pointers.
- **Space Complexity:** $O(1)$ auxiliary space.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 86a61677161283d58e67892892d285404a37a44fa9d36f72dea00a04c0c55ceb`
