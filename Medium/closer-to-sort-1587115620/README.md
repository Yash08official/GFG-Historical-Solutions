# Closer to sort

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/closer-to-sort-1587115620/1](https://www.geeksforgeeks.org/problems/closer-to-sort-1587115620/1)  
**Problem ID:** `701245`  
**Slug:** `closer-to-sort-1587115620`  
**Accepted Submission Date:** `2026-11-26 14:01:04`  

---

## Problem Statement

You are given an array **arr[]** of distinct positive integers that is closely sorted, and a target element **x**, your task is to find the index of **x** in the array. If **x** is not present, return -1.
**Closer Sorted**: The first array is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e, maybe to the **arr[i+1]** or **arr[i-1]**.

**Examples:**

```text
**Input**: arr[] = [3 2 10 4 40], x = 2
**Output**: 1
**Explanation**: 2 is present at index 1 (0-based indexing) in the given array.
```

```text
**Input**: arr[] = [2 1 4 3], x = 5
**Output**: -1
**Explanation**: 5 is not in the array so the output will be -1.

```

**Constraints:**
1 ≤ arr.size() ≤ 106
1 ≤ arr[i],x ≤ 109

---

## Solution & Approach

### Approach Explanation

Modified Binary Search on Nearly Sorted Array:
1. In a nearly sorted array where every element is at most 1 position away from its sorted index, element x could reside at index mid - 1, mid, or mid + 1.
2. In each iteration of binary search, compare x with arr[mid], arr[mid - 1], and arr[mid + 1]. If matched, return the respective index.
3. If x < arr[mid], search the left half by updating `high = mid - 2`.
4. Otherwise, search the right half by updating `low = mid + 2`.

### Complexity Analysis
- **Time Complexity:** O(log n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {

    int closer(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Check middle element
            if (arr[mid] == x) {
                return mid;
            }

            // Check left adjacent element
            if (mid - 1 >= low && arr[mid - 1] == x) {
                return mid - 1;
            }

            // Check right adjacent element
            if (mid + 1 <= high && arr[mid + 1] == x) {
                return mid + 1;
            }

            // Search left half
            if (x < arr[mid]) {
                high = mid - 2;
            }

            // Search right half
            else {
                low = mid + 2;
            }
        }

        return -1;
    }
}
```
