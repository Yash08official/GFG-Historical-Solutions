# Count Only Repeated

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-only-repeated2047/1](https://www.geeksforgeeks.org/problems/count-only-repeated2047/1)  
**Problem ID:** `701764`  
**Slug:** `count-only-repeated2047`  
**Accepted Submission Date:** `2026-11-26 10:57:11`  

---

## Problem Statement

Given a sorted array **arr[]** of positive integers where the elements are **consecutive**, meaning the difference between adjacent distinct elements is exactly 1. In the array, exactly one element is repeated one or more times, while all other elements appear exactly once.

Find and return the repeated element and the number of times it occurs in the array. If no element is repeated, return [-1, -1].

**Examples :**

```text
**Input: **arr[] = [1, 2, 3, 3, 4]
**Output: **3 2**
Explanation: **In the given array, 3 is occuring two times.

```

```text
**Input: **arr[] = [2, 3, 4, 5, 5]
**Output: **5 2**
Explanation: **In the given array, 5 is occuring two times.
```

```text
**Input: **arr[] = [1, 2, 3]
**Output: **-1 -1**
Explanation: **In the given array, there's no repeating element, and thus the output is -1 -1.

```

**Constraints:**
1 <= arr.size() <= 107
1 <= arr[i] <= arr.size()

---

## Solution & Approach

### Approach Explanation

Binary Search on Consecutive Sorted Array:
1. An array of n sorted elements has consecutive elements with exactly one element repeated multiple times.
2. If `arr[0] + n - 1 == arr[n-1]`, no element is repeated (frequency <= 1).
3. Otherwise, the repeating element occurs k = n - (arr[n-1] - arr[0]) times.
4. Use binary search to find the transition point where `arr[mid] != arr[0] + mid`. The first such index gives the repeating element `arr[low]`.

### Complexity Analysis
- **Time Complexity:** O(log n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
import java.util.*;

class Solution {

    public ArrayList<Integer> findRepeating(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = arr.length;

        // Step 1: Find the first index where
        // arr[i] != arr[0] + i

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long expected = (long) arr[0] + mid;

            if (arr[mid] == expected) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // No repeated element
        if (low == n) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        // Step 2: Find the repeated element
        int repeated = arr[low - 1];

        // Step 3: Find the first index
        // where element is greater than repeated
        int left = low;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= repeated) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Frequency of repeated element
        int frequency = left - (low - 1);

        result.add(repeated);
        result.add(frequency);

        return result;
    }
}
```
