# Rearrange Array Alternately

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1](https://www.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1)  
**Problem ID:** `701205`  
**Slug:** `-rearrange-array-alternately-1587115620`  
**Accepted Submission Date:** `2026-11-22 19:25:46`  

---

## Problem Statement

Given an array of non-negative integers. Your task is to rearrange the array elements alternatively i.e. first element should be the max value, the second should be the min value, the third should be the second max, the fourth should be the second min, and so on.

**Note: **Modify the original array itself. You do not have to return anything.

**Examples:**

```text
**Input: **arr[] = [1, 2, 3, 4, 5, 6]
**Output: **[6, 1, 5, 2, 4, 3]**
Explanation: **Max element = 6, min = 1, second max = 5, second min = 2, and so on... The modified array is: [6, 1, 5, 2, 4, 3]
```

```text
**Input: **arr[]= [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110]
**Output: **[110, 10, 100, 20, 90, 30, 80, 40, 70, 50, 60]**
Explanation: **Max element = 110, min = 10, second max = 100, second min = 20, and so on... Modified array is : [110, 10, 100, 20, 90, 30, 80, 40, 70, 50, 60]

```

```text
**Input: **arr[]= [1]
**Output: **[1]
```

---

## Solution & Approach

### Approach Explanation

Two-Pointer Alternate Selection:
1. Sort the array in non-decreasing order.
2. Maintain two pointers: `left = 0` (minimums) and `right = n - 1` (maximums).
3. Alternately pick from `right` (maximum) and `left` (minimum) into a temporary array until pointers cross.
4. Copy the result back into the original array.

### Complexity Analysis
- **Time Complexity:** O(n log n) due to array sorting
- **Auxiliary Space:** O(n) for temporary buffer

---

## Source Code

```java
import java.util.*;

class Solution {
    public void rearrange(int arr[]) {

        Arrays.sort(arr);

        int n = arr.length;

        int left = 0;
        int right = n - 1;

        int[] temp = new int[n];

        int index = 0;

        while (left <= right) {

            // First take maximum
            temp[index++] = arr[right--];

            // Then take minimum
            if (left <= right) {
                temp[index++] = arr[left++];
            }
        }

        // Copy rearranged elements into original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}
```
