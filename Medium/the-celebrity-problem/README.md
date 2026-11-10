# Celebrity Problem

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/the-celebrity-problem/1](https://www.geeksforgeeks.org/problems/the-celebrity-problem/1)  
**Problem ID:** `700253`  
**Slug:** `the-celebrity-problem`  
**Topic Tags:** `Arrays`, `Stack`, `two-pointer-algorithm`  
**Accepted Submission Date:** `2026-11-09 17:37:46`  
**Language:** `Java`  

---

## Problem Statement

In an n x n square matrix mat where mat[i][j] = 1 indicates person i knows person j, a celebrity is known by everyone but knows no one. Find the celebrity's index or return -1.

### Examples

```
Input: mat[][] = [[0, 1, 0], [0, 0, 0], [0, 1, 0]]
Output: 1
Explanation: Person 1 is known by both 0 and 2, and 1 knows nobody.

Input: mat[][] = [[0, 1], [1, 0]]
Output: -1
Explanation: Both people know each other; no celebrity exists.
```

---

## Approach

- **Two-Pointer Elimination:**
  - Set `top = 0` and `bottom = n - 1`.
  - If `mat[top][bottom] == 1`, `top` knows `bottom` so `top` cannot be celebrity (`top++`).
  - Else, `top` does not know `bottom` so `bottom` cannot be celebrity (`bottom--`).
  - Verify remaining candidate: must not know anyone (`mat[candidate][i] == 0`) and must be known by everyone (`mat[i][candidate] == 1`).
- **Time Complexity:** $O(n)$ elimination + $O(n)$ verification = $O(n)$.
- **Space Complexity:** $O(1)$ constant auxiliary space.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 8fe3399303409b296fe0b154b8dd00932eda86eaad1f1ce3c8124844f9aafba4`
