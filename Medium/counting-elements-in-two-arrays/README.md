# Counting elements in two arrays

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1](https://www.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1)  
**Problem ID:** `700563`  
**Slug:** `counting-elements-in-two-arrays`  
**Accepted Submission Date:** `2026-11-25 09:51:24`  

---

## Problem Statement

You are given two unsorted arrays **a[]** and **b[]**. Both arrays may contain duplicate elements. For each element in **`a[]`**, your task is to count how many elements in **`b[]`** are **less than or equal** to that element.

**Examples:**
```text
**Input:** a[] = [4, 8, 7, 5, 1], b[] = [4, 48, 3, 0, 1, 1, 5]
**Output: **[5, 6, 6, 6, 3]
**Explanation: 
**For a[0] = 4, there are 5 elements in b (4, 3, 0, 1, 1) that are ≤ 4.
For a[1] = 8 and a[2] = 7, there are 6 elements in b that are ≤ 8 and ≤ 7.
For a[3] = 5, there are 6 elements in b that are ≤ 5.
For a[4] = 1, there are 3 elements in b (0, 1, 1) that are ≤ 1.
```

```text
**Input:** a[] = [10, 20], b[] = [30, 40, 50]
**Output: **[0, 0]
**Explanation: 
**For a[0] = 10 and a[1] = 20, there are no elements in b that are less than or equal to 10 or 20. Hence, the output is [0, 0].
```

**Constraints:**
1 ≤ a.size(), b.size() ≤ 105
0 ≤ a[i], b[j] ≤ 105

---

## Solution & Approach

### Approach Explanation

Sorting & Binary Search (Upper Bound):
1. Sort array `b[]` in ascending order.
2. For each query element `x` in `a[]`, use binary search (upper bound) to find the first index in `b[]` where `b[mid] > x`.
3. That index `left` equals the count of elements in `b[]` that are `<= x`.
4. Append the count to the result list.

### Complexity Analysis
- **Time Complexity:** O(m log m + n log m) where m is length of b[] and n is length of a[]
- **Auxiliary Space:** O(1) auxiliary space (excluding result array)

---

## Source Code

```java
import java.util.*;

class Solution {

    public static ArrayList<Integer> countLessEq(int a[], int b[]) {

        Arrays.sort(b);

        ArrayList<Integer> result = new ArrayList<>();

        for (int x : a) {

            int left = 0;
            int right = b.length;

            // Find the first element greater than x
            while (left < right) {

                int mid = left + (right - left) / 2;

                if (b[mid] <= x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // left represents the count of elements <= x
            result.add(left);
        }

        return result;
    }
}
```
