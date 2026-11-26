# Missing in AP

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/missing-element-of-ap2228/1](https://www.geeksforgeeks.org/problems/missing-element-of-ap2228/1)  
**Problem ID:** `703333`  
**Slug:** `missing-element-of-ap2228`  
**Accepted Submission Date:** `2026-11-26 13:58:48`  

---

## Problem Statement

Given a sorted array **arr[] **that represents an Arithmetic Progression (AP) with exactly **one** missing element, find the missing number.
The array **arr[]** is sorted in either ascending or descending order.

**Note: **An element will always exist that, upon inserting into a sequence forms Arithmetic progression. If the given sequence already forms a valid complete **AP**, return the **(n+1)**-th element that would come next in the sequence.

**Examples:**
```text
**Input: **arr[] = [2, 4, 8, 10, 12, 14]
**Output:** 6
**Explanation:** Actual AP should be 2, 4, **6**, 8, 10, 12, 14.

```

```text
**Input: **arr[] = [1, 6, 11, 16, 21, 31]
**Output:** 26
**Explanation:** Actual AP should be 1, 6, 11, 16, 21, **26**, 31.
```

```text
**Input: **arr[] = [4, 7, 10, 13, 16]
**Output:** 19
**Explanation:** Since the sequence already forms a valid AP, the next element after 16 in the sequence would be 19. Therefore, the output is 19.
```

---

## Solution & Approach

### Approach Explanation

Binary Search on Arithmetic Progression:
1. Determine the common difference d by finding the minimum absolute difference between adjacent elements, oriented with the progression's sign (positive if ascending, negative if descending).
2. In an intact AP starting at arr[0], the element at index i must equal arr[0] + i * d.
3. Perform binary search in range [0, n - 1]. If arr[mid] == arr[0] + mid * d, the missing element lies to the right (`low = mid + 1`); otherwise it lies to the left (`high = mid - 1`).
4. The missing element is arr[0] + low * d.

### Complexity Analysis
- **Time Complexity:** O(log n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {

    public int findMissing(int[] arr) {

        int n = arr.length;

        // Find the common difference
        int d = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            d = Math.min(d, Math.abs(arr[i] - arr[i - 1]));
        }

        // Preserve ascending or descending direction
        if (arr[n - 1] < arr[0]) {
            d = -d;
        }

        // Binary search for the first incorrect position
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int expected = arr[0] + mid * d;

            if (arr[mid] == expected) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Missing element, or next element if AP is complete
        return arr[0] + low * d;
    }
}
```
