# Triplets with Smaller Sum

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1](https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1)  
**Problem ID:** `703292`  
**Slug:** `count-triplets-with-sum-smaller-than-x5549`  
**Accepted Submission Date:** `2026-11-24 11:25:11`  

---

## Problem Statement

Given an array **arr[] **of distinct integers and an integer **sum**, count the number of unique triplets of elements whose sum is strictly less than sum. A triplet is identified only by the three elements it contains, so different permutations of the same three elements are counted as one triplet.

****Examples :****

```text
****Input: ****sum = 2, arr[] = [-2, 0, 1, 3]**
**Output:**  **2**
**Explanation**: T**riplets with sum less than 2 are (-2, 0, 1) and (-2, 0, 3). 

```

```text
****Input: ****sum = 12, arr[] = [5, 1, 3, 4, 7]**
**Output:** **4**
**Explanation**: **Triplets with sum less than 12 are (1, 3, 4), (5, 1, 3), (1, 3, 7) and (5, 1, 4).
```

---

## Solution & Approach

### Approach Explanation

Sorting & Two Pointers:
1. Sort the array `arr[]` in ascending order.
2. Fix the first element `arr[i]` from index `0` to `n - 3`.
3. Use two pointers `left = i + 1` and `right = n - 1`.
4. If `arr[i] + arr[left] + arr[right] < sum`, then every element between `left` and `right` also forms a valid triplet with `arr[i]` and `arr[left]`. Add `(right - left)` to `count` and increment `left`.
5. Otherwise, decrement `right` to reduce the sum.

### Complexity Analysis
- **Time Complexity:** O(n^2) where n is the length of arr[]
- **Auxiliary Space:** O(1) constant auxiliary space

---

## Source Code

```java
import java.util.*;

class Solution {

    int countTriplets(int sum, int arr[]) {

        Arrays.sort(arr);

        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum < sum) {

                    count += right - left;

                    left++;

                } else {

                    right--;
                }
            }
        }

        return count;
    }
}
```
