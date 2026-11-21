# Smallest Subarray Sum Greater Than x

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1](https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1)  
**Problem ID:** `702894`  
**Slug:** `smallest-subarray-with-sum-greater-than-x5651`  
**Accepted Submission Date:** `2026-11-21 10:32:16`  

---

## Problem Statement

Given an integer `x` and an array of integers `arr[]`. Find the length of the smallest subarray whose sum is strictly greater than `x`. If no such subarray exists, return `0`.

**Examples:**
```text
Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
Output: 3
Explanation: The smallest subarray with a sum greater than 51 is [4, 45, 6], whose sum is 55 and length is 3.
```
```text
Input: x = 100, arr[] = [1, 10, 5, 2, 7]
Output: 0
Explanation: No subarray has a sum greater than 100. Hence, the answer is 0.
```

**Constraints:**
- $1 \le 	ext{arr.size()} \le 10^5$
- $0 \le 	ext{arr}[i] \le 10^5$
- $1 \le x \le 10^9$

---

## Solution & Approach

### Approach Explanation

Sliding Window (Two Pointers):
1. Maintain a dynamic sliding window `[left, right]` and a running window sum `sum`.
2. Expand the window by adding `arr[right]` to `sum`.
3. While `sum > x`, update `minLength = Math.min(minLength, right - left + 1)`, then contract the window from the left by subtracting `arr[left]` and incrementing `left`.
4. If `minLength` was never updated (i.e. remaining at `Integer.MAX_VALUE`), return `0`; otherwise return `minLength`.

### Complexity Analysis
- **Time Complexity:** O(n) where each element is visited at most twice
- **Auxiliary Space:** O(1) auxiliary space

---

## Source Code

```java
class Solution {

    public int smallestSubWithSum(int[] arr, int x) {

        int n = arr.length;

        int left = 0;
        int sum = 0;

        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            // Add current element
            sum += arr[right];

            // Shrink window while sum > x
            while (sum > x) {

                minLength = Math.min(
                    minLength,
                    right - left + 1
                );

                sum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: fe1bb09de5ac2be46cc69763ce789b3d97b10ab11fe7441ef84a5a78e83d0fbd`)
