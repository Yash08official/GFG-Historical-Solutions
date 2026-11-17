# K-th Missing in Natural Numbers

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/k-th-missing-element-in-natural-numbers/1](https://www.geeksforgeeks.org/problems/k-th-missing-element-in-natural-numbers/1)  
**Problem ID:** `903692`  
**Slug:** `k-th-missing-element-in-natural-numbers`  
**Accepted Submission Date:** `2026-11-16 18:58:20`  

---

## Problem Statement

Given an array `arr[]` of distinct positive integers and a positive integer `k`. Consider an infinite sequence of natural numbers starting from 1. The task is to remove all elements present in `arr[]` from this sequence and find the $k$-th smallest number in the remaining sequence.

**Note:** Your solution must run in $O(1)$ auxiliary space.

**Examples:**
```text
Input: arr[] = [1, 9, 5, 2], k = 6
Output: 10
Explanation: Remaining sequence after removing arr elements: [3, 4, 6, 7, 8, 10, 11, ...]. The 6th smallest number is 10.
```
```text
Input: arr[] = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: Remaining sequence after removing arr elements: [1, 5, 6, 8, 9, 10, ...]. The 5th smallest number is 9.
```

**Constraints:**
- $1 \le 	ext{arr.size()} \le 10^5$
- $1 \le 	ext{arr}[i], k \le 10^9$

---

## Solution & Approach

### Approach Explanation

Sorting + Binary Search on Missing Count:
1. Sort `arr[]` in ascending order.
2. For any index `mid`, the number of missing natural numbers strictly before `arr[mid]` is given by `missing = arr[mid] - (mid + 1)`.
3. If `missing < k`, the $k$-th missing number lies to the right (`low = mid + 1`).
4. Otherwise, it lies to the left (`high = mid - 1`).
5. After binary search completes, the $k$-th missing element is `low + k`.

### Complexity Analysis
- **Time Complexity:** O(n log n) due to sorting, followed by O(log n) binary search
- **Auxiliary Space:** O(1) auxiliary space

---

## Source Code

```java
import java.util.Arrays;

class Solution {

    public int findKthSmall(int[] arr, int k) {

        int n = arr.length;

        // Sort the array
        Arrays.sort(arr);

        // Binary Search
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Calculate kth missing number
        return low + k;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: 3937d1b788ac45c6d6fd0efc697f5ffe50e27fa6758ffcccf4b64e6940a30865`)
