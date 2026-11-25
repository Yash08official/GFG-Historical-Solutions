# Rational Number Search

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-rational-number/1](https://www.geeksforgeeks.org/problems/find-rational-number/1)  
**Problem ID:** `899289`  
**Slug:** `find-rational-number`  
**Accepted Submission Date:** `2026-11-25 09:52:16`  

---

## Problem Statement

Given two arrays a[] and b[] of the same size, both sorted in non-decreasing order. The pair (a[i], b[i]) represents a numerator and denominator at index i and given a target numerator p and a target denominator q. Find the first index i such that a[i] == p and b[i] == q. If no such index exists, return -1.

**Note:** Pairs are compared exactly on numerator and denominator, not by decimal or fractional value. For example, (2, 4) does not match (1, 2).

**Examples:**

```text
**Input: **a[] = [1, 2, 3, 13], b[] = [2, 2, 3, 5], p = 2, q = 2**
Output: **1**
Explanation: **The pair at index 1 is (2, 2), which matches (p, q) = (2, 2). Hence, the first occurrence index is 1.
```

```text
**Input: **a[] = [1, 2, 4, 6], b[] = [2, 4, 8, 10], p = 1, q = 2**
Output: **0**
Explanation: **The pair at index 0 is (1, 2), which matches (p, q) = (1, 2). Hence, the first occurrence index is 0.
```

```text
**Input: **a[] = [1, 2, 3, 13], b[] = [2, 2, 3, 5], p = 5, q = 1**
Output: **-1**
Explanation: **No index has the pair (5, 1), so the answer is -1.
```

---

## Solution & Approach

### Approach Explanation

Two-Level Binary Search (Lower Bound):
1. The fractions `a[i] / b[i]` are sorted primarily by numerator `a[i]` and secondarily by denominator `b[i]`.
2. Perform binary search comparing `a[mid]` with `p`.
3. If numerators match, compare denominator `b[mid]` with `q`.
4. When an exact match is found, record `answer = mid` and continue searching left (`right = mid - 1`) to find the first occurrence.

### Complexity Analysis
- **Time Complexity:** O(log n) logarithmic binary search
- **Auxiliary Space:** O(1) constant auxiliary space

---

## Source Code

```java
class Solution {

    public int findIndex(int[] a, int[] b, int p, int q) {

        int left = 0;
        int right = a.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Compare numerator first
            if (a[mid] < p) {

                left = mid + 1;

            } else if (a[mid] > p) {

                right = mid - 1;

            } else {

                // Numerator matches, compare denominator
                if (b[mid] < q) {

                    left = mid + 1;

                } else if (b[mid] > q) {

                    right = mid - 1;

                } else {

                    // Both numerator and denominator match
                    answer = mid;

                    // Search left for the first occurrence
                    right = mid - 1;
                }
            }
        }

        return answer;
    }
}
```
