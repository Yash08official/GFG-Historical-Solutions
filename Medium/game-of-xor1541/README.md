# XOR of All Subarray XORs

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/game-of-xor1541/1](https://www.geeksforgeeks.org/problems/game-of-xor1541/1)  
**Problem ID:** `703950`  
**Slug:** `game-of-xor1541`  
**Topic Tags:** `Mathematics`, `Bit Magic`  
**Accepted Submission Date:** `2026-11-05 20:33:23`  
**Language:** `Java`  

---

## Problem Statement

Given an integer array `arr[]`, find the XOR of the XOR values of all possible non-empty subarrays of the array.

### Examples

```
Input: arr[] = [1, 2, 3] 
Output: 2
Explanation:
xor[1] = 1
xor[1, 2] = 3
xor[2, 3] = 1
xor[1, 2, 3] = 0
xor[2] = 2
xor[3] = 3
Result: 1 ^ 3 ^ 1 ^ 0 ^ 2 ^ 3 = 2
```

```
Input: arr[] = [1, 2]
Output: 0
Explanation:
xor[1] = 1
xor[1, 2] = 3
xor[2] = 2
Result: 1 ^ 3 ^ 2 = 0
```

---

## Approach

- **Mathematical Parity / Frequency Analysis:**
  - For element at index `i` (0-indexed) in an array of size `n`, the number of subarrays containing `arr[i]` is `(i + 1) * (n - i)`.
  - Since `x ^ x = 0`, elements that appear an even number of times cancel out completely.
  - If `n` is **even**, every element appears an even number of times, so the total XOR is always `0`.
  - If `n` is **odd**, elements at even indices (`0, 2, 4, ...`) appear an odd number of times, while elements at odd indices appear an even number of times. Therefore, we only XOR elements at even indices.
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: f14079d8a0a546c9c62a7576667390e62156cf9195fc1b9993a639c6b1dcf802`
