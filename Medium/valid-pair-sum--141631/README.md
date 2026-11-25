# Pairs with Positive Sum

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/valid-pair-sum--141631/1](https://www.geeksforgeeks.org/problems/valid-pair-sum--141631/1)  
**Problem ID:** `706063`  
**Slug:** `valid-pair-sum--141631`  
**Accepted Submission Date:** `2026-11-25 09:53:51`  

---

## Problem Statement

Given an integer array **arr[]** , find the number of distinct pairs** **(i , j) such that (i < j) and arr[i] + arr[j] > 0.

**Examples:**

```text
**Input: **arr[] = [3, -2, 1]
**Output:** 2
**Explanation:** [3, -2], [3, 1] are two possible pairs.
```

```text
**Input:** arr[] = [1, 3, 4, -2]
**Output:** 5
**Explanation:** [-2, 3], [-2, 4], [1, 3], [1, 4], and [3, 4] are five possible pairs.

```

```text
**Input:** arr[] = [-1, -1, -1, 0]
**Output:** 0
**Explanation:** There are no possible pairs.
```

---

## Solution & Approach

### Approach Explanation

Sorting & Two Pointers:
1. Sort the array `arr[]` in ascending order.
2. Maintain two pointers: `left = 0` and `right = n - 1`.
3. If `arr[left] + arr[right] > 0`, then all elements between `left` and `right - 1` paired with `arr[right]` also have a sum `> 0`. Add `right - left` to `count` and decrement `right`.
4. Otherwise, the sum is `<= 0`, so increment `left` to increase the pair sum.

### Complexity Analysis
- **Time Complexity:** O(n log n) dominated by sorting
- **Auxiliary Space:** O(1) constant auxiliary space

---

## Source Code

```java
import java.util.*;

class Solution {

    static long validPair(int[] arr) {

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        long count = 0;

        while (left < right) {

            if (arr[left] + arr[right] > 0) {

                count += right - left;

                right--;

            } else {

                left++;
            }
        }

        return count;
    }
}
```
