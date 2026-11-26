# Pair Sum Closest to 0

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/two-numbers-with-sum-closest-to-zero1737/1](https://www.geeksforgeeks.org/problems/two-numbers-with-sum-closest-to-zero1737/1)  
**Problem ID:** `702822`  
**Slug:** `two-numbers-with-sum-closest-to-zero1737`  
**Accepted Submission Date:** `2026-11-26 10:52:50`  

---

## Problem Statement

Given an integer array of **n** elements. You need to find the maximum** **sum of two elements such that sum is closest to zero.

**Examples:**
```text
**Input: **arr[] = [-8 -66 -60]
**Output:** -68
**Explanation**: Sum of two elements closest to 
zero is -68 using numbers -60 and -8.

```

```text
**Input**: arr[] = [-21 -67 -37 -18 4 -65]
**Output:** -14
**Explanation**: Sum of two elements closest to
zero is -14 using numbers -18 and 4.
```

**Constraints:**
2 ≤ n ≤ 5 * 105
-106 ≤ arr[i] ≤ 106

---

## Solution & Approach

### Approach Explanation

Two-Pointer Technique on Sorted Array:
1. Sort the array in non-decreasing order.
2. Initialize two pointers: `left = 0` and `right = n - 1`. Track `bestSum = arr[left] + arr[right]`.
3. At each step, compute `currentSum = arr[left] + arr[right]`.
4. Update `bestSum` if |currentSum| < |bestSum| or if |currentSum| == |bestSum| and currentSum > bestSum (as tie-breaker prefers the maximum sum).
5. If `currentSum < 0`, increment `left` to increase sum. Otherwise, decrement `right` to decrease sum.

### Complexity Analysis
- **Time Complexity:** O(n log n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
import java.util.*;

class Solution {

    public static int closestToZero(int arr[]) {

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        int bestSum = arr[left] + arr[right];

        while (left < right) {

            int currentSum = arr[left] + arr[right];

            // Update if closer to zero
            // In case of a tie, choose the greater sum
            if (Math.abs(currentSum) < Math.abs(bestSum) ||
                (Math.abs(currentSum) == Math.abs(bestSum)
                && currentSum > bestSum)) {

                bestSum = currentSum;
            }

            if (currentSum == 0) {
                return 0;
            }

            if (currentSum < 0) {

                left++;

            } else {

                right--;
            }
        }

        return bestSum;
    }
}
```
