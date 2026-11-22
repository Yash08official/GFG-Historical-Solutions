# Wave Array

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/wave-array-1587115621/1](https://www.geeksforgeeks.org/problems/wave-array-1587115621/1)  
**Problem ID:** `701198`  
**Slug:** `wave-array-1587115621`  
**Accepted Submission Date:** `2026-11-22 19:24:52`  

---

## Problem Statement

Given an **s****orted** array arr[] of integers. Sort the array into a wave-like array (In Place). In other words,** **arrange the elements into a sequence such that : arr[0] ≥ arr[1] ≤ arr[2] ≥ arr[3] ≤ arr[4] ≥ ... and so on. If there are multiple solutions, find the lexicographically smallest one.

**Note: **The given array is sorted in ascending order, and modify the given array in-place without returning a new array.

**Examples:**
```text
**Input: **arr[] = [1, 2, 3, 4, 5]
**Output: **[2, 1, 4, 3, 5]**
Explanation: **Array elements after sorting it in the waveform are 2, 1, 4, 3, 5.
```

```text
**Input: **arr[] = [2, 4, 7, 8, 9, 10]
**Output: **[4, 2, 8, 7, 10, 9]**
Explanation: **Array elements after sorting it in the waveform are 4, 2, 8, 7, 10, 9.

```

```text
**Input:** arr[] = [1]
**Output:** [1]
```

---

## Solution & Approach

### Approach Explanation

In-Place Pairwise Swap on Sorted Array:
1. Given that the input array is already sorted in ascending order.
2. Iterate through the array with step size of 2 (`i += 2`).
3. Swap adjacent elements `arr[i]` and `arr[i + 1]` to form the wave condition `arr[0] >= arr[1] <= arr[2] >= arr[3] ...` while ensuring the lexicographically smallest arrangement.

### Complexity Analysis
- **Time Complexity:** O(n) linear scan
- **Auxiliary Space:** O(1) in-place modification

---

## Source Code

```java
class Solution {
    public void sortInWave(int arr[]) {

        for (int i = 0; i < arr.length - 1; i += 2) {

            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
```
