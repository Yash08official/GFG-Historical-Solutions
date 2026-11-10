# Union of 2 Sorted Arrays

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1](https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1)  
**Problem ID:** `701235`  
**Slug:** `union-of-two-sorted-arrays-1587115621`  
**Topic Tags:** `Arrays`, `two-pointer-algorithm`  
**Accepted Submission Date:** `2026-11-09 17:28:22`  
**Language:** `Java`  

---

## Problem Statement

Given two sorted arrays a[] and b[], find the union of these two arrays. The union contains all distinct elements from both arrays sorted in non-decreasing order.

### Examples

```
Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3]
Output: [1, 2, 3, 4, 5]
Explanation: Distinct elements from both arrays are 1, 2, 3, 4, 5.

Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
Output: [1, 2, 3, 4, 5]
Explanation: Distinct elements from both arrays are 1, 2, 3, 4, 5.
```

---

## Approach

- **Two-Pointer Technique:**
  - Initialize two pointers `i` and `j` at the beginning of `a[]` and `b[]`.
  - At each step, compare `a[i]` and `b[j]`. Pick the smaller element (or either if equal) and advance the corresponding pointer(s).
  - Append the chosen element to `result` only if it differs from the last added element to prevent duplicates.
  - Append any remaining distinct elements from `a[]` and `b[]`.
- **Time Complexity:** $O(n + m)$ where $n$ and $m$ are lengths of $a$ and $b$.
- **Space Complexity:** $O(1)$ auxiliary space (excluding result list).

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: c784bd48f3193da8f703d4b05acd11452224a8cd0aa2238d8a27f665516a7461`
