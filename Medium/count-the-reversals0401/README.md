# Minimum Bracket Reversals to Balance

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-the-reversals0401/1](https://www.geeksforgeeks.org/problems/count-the-reversals0401/1)  
**Problem ID:** `703063`  
**Slug:** `count-the-reversals0401`  
**Topic Tags:** `Strings`, `Stack`  
**Accepted Submission Date:** `2026-11-09 17:40:34`  
**Language:** `Java`  

---

## Problem Statement

Given a string consisting of only '{' and '}', find the minimum number of reversals needed to make the expression balanced. Return -1 if impossible.

### Examples

```
Input: s = "}{{}{"
Output: 2
Explanation: Changing the first bracket to '{' and last bracket to '}' gives "{{}{}" which is balanced.

Input: s = "{{{"
Output: -1
Explanation: Odd length string can never be balanced.
```

---

## Approach

- **Counting Unbalanced Brackets:**
  - If string length is odd, balancing is impossible; return -1.
  - Count unmatched `open` and `close` brackets in a single pass.
  - If '{', increment `open`.
  - If '}', decrement `open` if `open > 0`, else increment `close`.
  - Total minimum reversals is `(open + 1) / 2 + (close + 1) / 2`.
- **Time Complexity:** $O(n)$ single pass.
- **Space Complexity:** $O(1)$ constant auxiliary space.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 55db108d91e6b9afb9eaa578a4bf5185f7b19cba6afbc5383eba75e0f7c064d1`
