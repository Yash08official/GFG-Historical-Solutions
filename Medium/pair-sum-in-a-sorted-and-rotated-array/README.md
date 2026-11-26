# Pair Sum in Sorted and Rotated

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/pair-sum-in-a-sorted-and-rotated-array/1](https://www.geeksforgeeks.org/problems/pair-sum-in-a-sorted-and-rotated-array/1)  
**Problem ID:** `884343`  
**Slug:** `pair-sum-in-a-sorted-and-rotated-array`  
**Accepted Submission Date:** `2026-11-27 00:28:09`  

---

## Problem Statement

Given an array of positive elements ****arr[]**** that is sorted and then rotated around an unknown point, the task is to check if the array has a pair with sum equals to a given ****target****.

**Examples:**
```text
**Input: **arr[] = [7, 9, 1, 3, 5], target = 6
**Output: **true
**Explanation: **arr[2] and arr[4] has sum equals to 6 which is equal to the target.

```

```text
**Input: **arr[] = [2, 3, 4, 1], target = 3
**Output: **true
**Explanation: **arr[0] and arr[3] has sum equals to 3 which is equal to the target.

```

```text
**Input: **arr[] = [10, 7, 4, 1], target = 9
**Output: **false
**Explanation: **There is no such pair exists in arr[] which sums to target.
```

---

## Solution & Approach

### Approach Explanation

Circular Two-Pointer Search:
1. Find the pivot index where the sorted array wraps around (arr[i] > arr[i + 1]).
2. If no pivot exists, the array is strictly sorted; use standard two pointers.
3. Otherwise, set `left = (pivot + 1) % n` (smallest element) and `right = pivot` (largest element).
4. While `left != right`:
   - If arr[left] + arr[right] == target, return true.
   - If the sum is less than target, advance left clockwise: `left = (left + 1) % n`.
   - If the sum is greater than target, advance right counter-clockwise: `right = (right - 1 + n) % n`.
5. If pointers meet without finding the target, return false.

### Complexity Analysis
- **Time Complexity:** O(n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {
    static boolean pairInSortedRotated(int arr[], int target) {

        int n = arr.length;
        int pivot = -1;

        // Find the pivot
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no pivot exists, array is not rotated
        if (pivot == -1) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            return false;
        }

        // Smallest and largest elements
        int left = (pivot + 1) % n;
        int right = pivot;

        while (left != right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left = (left + 1) % n;
            } else {
                right = (right - 1 + n) % n;
            }
        }

        return false;
    }
}
```
