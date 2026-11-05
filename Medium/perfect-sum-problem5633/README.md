# Count Subsets with Sum

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1](https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1)  
**Problem ID:** `704213`  
**Slug:** `perfect-sum-problem5633`  
**Topic Tags:** `Dynamic Programming`  
**Accepted Submission Date:** `2026-11-05 21:50:07`  
**Language:** `Java`  

---

## Problem Statement

Given an array `arr[]` of non-negative integers and an integer `target`, count all subsets of the array whose sum is equal to the given `target`.

### Examples

```
Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
Output: 3
Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.
```

```
Input: arr[] = [2, 5, 1, 4, 3], target = 10
Output: 3
Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.
```

```
Input: arr[] = [5, 7, 8], target = 3
Output: 0
Explanation: There are no subsets of the given array with sum 3.
```

---

## Approach

- **Dynamic Programming (0/1 Knapsack Subset Sum Pattern):**
  - Let `dp[j]` denote the number of subsets with sum `j`.
  - Initialize `dp[0] = 1` (an empty subset has sum 0).
  - For each number `arr[i]` in the array:
    - Iterate backwards from `target` down to `arr[i]`:
      - `dp[j] += dp[j - arr[i]]`
    - Iterating backwards ensures each element is considered at most once per subset.
  - The final answer is stored in `dp[target]`.
- **Time Complexity:** `O(n * target)` where `n` is the number of elements in `arr`.
- **Space Complexity:** `O(target)` 1D DP table.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: f0a12bc560cdf79ad1f249ec960043199fd934a7c9e352d9f2efdea1afb6dfac`
