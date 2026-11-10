# Largest Subarray with 0 Sum

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1](https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1)  
**Problem ID:** `700254`  
**Slug:** `largest-subarray-with-0-sum`  
**Topic Tags:** `Arrays`, `Hash`  
**Accepted Submission Date:** `2026-11-09 17:30:14`  
**Language:** `Java`  

---

## Problem Statement

Given an array arr[] of both positive and negative integers, find the length of the longest subarray with a sum of 0.

### Examples

```
Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The largest subarray with 0 sum is [-2, 2, -8, 1, 7] of length 5.

Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with 0 sum.

Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The subarray [0, -4, 3, 1, 0] has sum 0 and length 5.
```

---

## Approach

- **Prefix Sum with Hash Map:**
  - Maintain running `sum` as we iterate through `arr[]`.
  - If `sum == 0`, the subarray from index `0` to `i` has sum 0, so length is `i + 1`.
  - If `sum` has been seen before at index `prevIndex`, the subarray from `prevIndex + 1` to `i` has sum 0; update `maxLength = max(maxLength, i - prevIndex)`.
  - Otherwise, record `(sum, i)` in the map (storing only the earliest index to maximize subsequent lengths).
- **Time Complexity:** $O(n)$ single pass.
- **Space Complexity:** $O(n)$ for storing prefix sums in the map.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 8f8d50dac85ba4d496058aacd04c34b976531bd92209de9d9eadac4de4d025a0`
