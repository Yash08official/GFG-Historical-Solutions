# Merge Sort

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/merge-sort/1](https://www.geeksforgeeks.org/problems/merge-sort/1)  
**Problem ID:** `700150`  
**Slug:** `merge-sort`  
**Accepted Submission Date:** `2026-11-22 19:26:33`  

---

## Problem Statement

Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort algorithm.

**Examples:**
```text
**Input: **arr[] = [4, 1, 3, 9, 7]
**Output: **[1, 3, 4, 7, 9]
**Explanation: **We get the sorted array after using merge sort

```

```text
**Input: **arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
**Output: **[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
**Explanation:** We get the sorted array after using merge sort 
```

---

## Solution & Approach

### Approach Explanation

Divide and Conquer:
1. Divide the array into two halves at `mid = l + (r - l) / 2`.
2. Recursively sort the left half `[l, mid]` and right half `[mid + 1, r]`.
3. Merge the two sorted subarrays using auxiliary arrays `left` and `right`, maintaining relative order of equal elements (stable sort).

### Complexity Analysis
- **Time Complexity:** O(n log n) in all cases (best, worst, average)
- **Auxiliary Space:** O(n) auxiliary space for temporary merge buffers

---

## Source Code

```java
class Solution {

    public void mergeSort(int arr[], int l, int r) {

        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        // Divide into two halves
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        // Merge sorted halves
        merge(arr, l, mid, r);
    }

    private void merge(int arr[], int l, int mid, int r) {

        int n1 = mid - l + 1;
        int n2 = r - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        // Copy elements into temporary arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // Merge both sorted arrays
        while (i < n1 && j < n2) {

            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements from left
        while (i < n1) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements from right
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
}
```
