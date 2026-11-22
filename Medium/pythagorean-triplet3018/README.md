# Pythagorean Triplet

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/pythagorean-triplet3018/1](https://www.geeksforgeeks.org/problems/pythagorean-triplet3018/1)  
**Problem ID:** `702805`  
**Slug:** `pythagorean-triplet3018`  
**Accepted Submission Date:** `2026-11-22 20:33:20`  

---

## Problem Statement

Given an array **arr[]**, return true if there is a **triplet (a, b, c)** from the array (where a, b, and c are on different indexes) that satisfies **a2 + b2 = c2**, otherwise return false.

**Examples:**
```text
**Input: **arr[] = [3, 2, 4, 6, 5]
**Output:** true
**Explanation:** a=3, b=4, and c=5 forms a pythagorean triplet.

```

```text
**Input: **arr[] = [3, 8, 5]
**Output:** false
**Explanation:** No such triplet possible.
```

```text
**Input: **arr[] = [1, 1, 1]
**Output:** false
```

---

## Solution & Approach

### Approach Explanation

Frequency Array & Triplet Verification:
1. Find maximum element `max` in `arr[]` and count frequencies of each value in `freq[]`.
2. Iterate through each possible hypotenuse `c` (1 to `max`) present in the array.
3. For each `c`, iterate `a` from 1 to `c - 1`.
4. Calculate `bSquared = c^2 - a^2` and verify if `b = sqrt(bSquared)` is an integer.
5. If `a`, `b`, and `c` are present in `arr[]` with sufficient frequencies (handling `a == b`), return `true`.

### Complexity Analysis
- **Time Complexity:** O(max^2) where max is the maximum element in arr
- **Auxiliary Space:** O(max) for frequency array

---

## Source Code

```java
class Solution {
    boolean pythagoreanTriplet(int[] arr) {

        int n = arr.length;

        // Find the maximum element
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }

        // Store frequency of each number
        int[] freq = new int[max + 1];

        for (int num : arr) {
            freq[num]++;
        }

        // Consider every possible hypotenuse c
        for (int c = 1; c <= max; c++) {

            if (freq[c] == 0) {
                continue;
            }

            // Consider a and b such that a² + b² = c²
            for (int a = 1; a < c; a++) {

                int bSquared = c * c - a * a;
                int b = (int) Math.sqrt(bSquared);

                if (b < a || b > max) {
                    continue;
                }

                if (b * b == bSquared &&
                    freq[a] > 0 &&
                    freq[b] > 0) {

                    // Ensure different indexes
                    if (a != b || freq[a] >= 2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
```
