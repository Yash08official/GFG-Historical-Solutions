# Ternary Search

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/searching-an-element-in-a-sorted-array-ternary-search--141631/1](https://www.geeksforgeeks.org/problems/searching-an-element-in-a-sorted-array-ternary-search--141631/1)  
**Problem ID:** `706239`  
**Slug:** `searching-an-element-in-a-sorted-array-ternary-search--141631`  
**Accepted Submission Date:** `2026-11-26 10:54:40`  

---

## Problem Statement

**Ternary search** is a divide-and-conquer algorithm that divides the search range into three parts and identifies the part that may contain the target element. The process is repeated until the element is found or the search range becomes empty. 

Given a sorted array arr and an integer x, determine whether x is present in the array using ternary search.

**Examples:**

```text
**Input: **arr = [1, 2, 3, 4, 6], x = 6
**Output: **true
**Explanation: **The element 6 is present in the array, so the output is true.
```

```text
**Input: **arr = [1, 3, 4, 5, 6], x = 2
**Output: **false
**Explanation: **The element 2 is not present in the array, so the output is false.

```

**Constraints:
**1 ≤ arr.size() ≤ 106
1 ≤ x ≤ 106
1 ≤ arr[i] ≤ 106

---

## Solution & Approach

### Approach Explanation

Ternary Search on Sorted Array:
1. In a sorted array, divide the search range [low, high] into three equal segments using two midpoints: `mid1 = low + (high - low) / 3` and `mid2 = high - (high - low) / 3`.
2. Compare x with `arr[mid1]` and `arr[mid2]`. If equal to either, return `true`.
3. If x < arr[mid1], search in [low, mid1 - 1].
4. If x > arr[mid2], search in [mid2 + 1, high].
5. Otherwise, search in [mid1 + 1, mid2 - 1].
6. Repeat until range is exhausted; if not found, return `false`.

### Complexity Analysis
- **Time Complexity:** O(log_3 n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {
    public boolean ternarySearch(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            // Check both middle elements
            if (arr[mid1] == x || arr[mid2] == x) {
                return true;
            }

            // Search left part
            if (x < arr[mid1]) {
                high = mid1 - 1;
            }

            // Search right part
            else if (x > arr[mid2]) {
                low = mid2 + 1;
            }

            // Search middle part
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }

        return false;
    }
}
```
