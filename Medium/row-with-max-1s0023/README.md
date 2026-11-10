# Row with Max 1s in Rowwise Sorted

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1](https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1)  
**Problem ID:** `702950`  
**Slug:** `row-with-max-1s0023`  
**Topic Tags:** `Matrix`  
**Accepted Submission Date:** `2026-11-09 17:32:13`  
**Language:** `Java`  

---

## Problem Statement

Given a 2D boolean array arr[][] of dimensions n x m where each row is sorted, find the 0-based index of the first row that has the maximum number of 1s. Return -1 if no 1 exists.

### Examples

```
Input: arr[][] = [[0, 1, 1, 1], [0, 0, 1, 1], [1, 1, 1, 1], [0, 0, 0, 0]]
Output: 2
Explanation: Row 2 has 4 ones, which is the maximum.

Input: arr[][] = [[0, 0], [1, 1]]
Output: 1
Explanation: Row 1 has 2 ones.
```

---

## Approach

- **Binary Search per Row:**
  - For each row `i`, apply binary search to find the index of the first `1` (`firstOne`).
  - The count of 1s in row `i` is `m - firstOne`.
  - Update `maxOnes` and record row index `result` if `count > maxOnes`.
- **Time Complexity:** $O(n \log m)$ where $n$ is rows and $m$ is columns.
- **Space Complexity:** $O(1)$ auxiliary space.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 35f91be97f20d77fb7ef5b3155555b57b77d426bcdf19fb1cfb4d566793841b6`
