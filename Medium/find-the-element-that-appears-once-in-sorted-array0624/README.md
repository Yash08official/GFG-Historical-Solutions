# Single Among Doubles in a Sorted

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1](https://www.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1)  
**Problem ID:** `702772`  
**Slug:** `find-the-element-that-appears-once-in-sorted-array0624`  
**Accepted Submission Date:** `2026-11-25 09:50:39`  

---

## Problem Statement

Given a sorted array **arr[]**. Find the element that appears only** once **in the array. All other elements appear exactly **twice**. 

**Examples:**

```text
**Input: **arr[] = [1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65]
**Output:** 4
**Explanation:** 4 is the only element that appears exactly once.

```

```text
**Input: **arr[] = [5]
**Output:** 5
```

```text
**Input: **arr[] = [1, 2, 2, 3, 3]
**Output:** 1
```

**Constraints:**
1 ≤ arr.size() ≤ 2 * 106
1 ≤ arr[i] ≤ 106

---

## Solution & Approach

### Approach Explanation

Binary Search on Even Indices:
1. In a sorted array where every element appears twice except one, pairs before the single element start at even indices (`arr[2k] == arr[2k + 1]`).
2. After the unique element, this pattern breaks (`arr[2k] != arr[2k + 1]`).
3. Binary search: adjust `mid` to even (`if (mid % 2 == 1) mid--`).
4. If `arr[mid] == arr[mid + 1]`, the unique element is to the right (`left = mid + 2`); otherwise it is at or to the left of `mid` (`right = mid`).

### Complexity Analysis
- **Time Complexity:** O(log n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {

    int single(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Make mid even so we can check its pair
            if (mid % 2 == 1) {
                mid--;
            }

            // Pair is correct: single element is on the right
            if (arr[mid] == arr[mid + 1]) {

                left = mid + 2;

            } else {

                // Pair is broken: single element is here or on the left
                right = mid;
            }
        }

        return arr[left];
    }
}
```
