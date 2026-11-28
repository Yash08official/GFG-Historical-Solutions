# Minimum XOR Value Pair

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/minimum-xor-value-pair/1](https://www.geeksforgeeks.org/problems/minimum-xor-value-pair/1)  
**Problem ID:** `706237`  
**Slug:** `minimum-xor-value-pair`  
**Accepted Submission Date:** `2026-11-28 11:07:23`  

---

## Problem Statement

Given an array **arr[]**, find the minimum value of** **arr[i] XOR arr[j] among all pairs of distinct indices i and j.

**Examples:**
```text
**Input: **arr[] = [9 5 3]**
Output: **6**
Explanation: **The XOR values of all possible pairs are 9 ^ 5 = 12, 9 ^ 3 = 10, and 5 ^ 3 = 6. Therefore, the minimum XOR value is 6.
```

```text
**Input**: arr[] = [6 1 4 2]
**Output:** 2
**Explanation**: Among all pairs, the minimum XOR value is obtained from 6 ^ 4 = 2.
```

**Constraints:**
1 <= n <= 105
1 <= arr[i] <= 105

---

## Solution & Approach

### Approach Explanation

Sorting and Adjacent Pair Comparison:
1. Sort array `arr` in ascending order.
2. In a sorted array, the minimum XOR difference between any pair of numbers (A, B) with A <= B is guaranteed to occur between adjacent elements because intermediate numbers share more significant bits with adjacent neighbors than with distant elements.
3. Traverse adjacent pairs (arr[i], arr[i - 1]) and update the minimum XOR value.

### Complexity Analysis
- **Time Complexity:** O(n * log n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
import java.util.*;

class Solution {
    public int minXor(int[] arr) {

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {

            int xor = arr[i] ^ arr[i - 1];

            min = Math.min(min, xor);
        }

        return min;
    }
}
```
