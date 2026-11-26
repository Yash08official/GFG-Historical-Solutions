# Smallest Diff Triplet in Three Arrays

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/happiest-triplet2921/1](https://www.geeksforgeeks.org/problems/happiest-triplet2921/1)  
**Problem ID:** `702809`  
**Slug:** `happiest-triplet2921`  
**Accepted Submission Date:** `2026-11-26 14:02:12`  

---

## Problem Statement

Given three integer arrays **a[], b[] and c[]** of equal size **n**, find a triplet** **(one element from each array) that minimizes** **the difference between its maximum and minimum elements. If there is a tie, return the triplet with the smallest sum. The final triplet must be returned in descending order.

**Examples:**

```text
**Input: **a[] = [5, 2, 8] , b[] = [10, 7, 12] , c[] = [9, 14, 6]
**Output:** [7, 6, 5]
**Explanation**: The triplet [5, 7, 6]  has difference (maximum - minimum)= (7 - 5) = 2 which is minimum of all triplets.  
```

```text
**Input: **a[] = [15, 12, 18, 9] , b[] = [10, 17, 13, 8] , c[] = [14, 16, 11, 5]
**Output:** [11, 10, 9]
**Explanation**:  Multiple triplets have the same minimum difference, and among them [11, 10, 9] has the smallest sum, so it is chosen.
```

**Constraints:**
1 ≤ a.size(), b.size(), c.size() ≤ 105
1 ≤ a[i], b[i], c[i] ≤ 105

---

## Solution & Approach

### Approach Explanation

Three-Pointer Traversal on Sorted Arrays:
1. Sort all three arrays a, b, c in ascending order.
2. Initialize three pointers i = 0, j = 0, k = 0. At each step, compute x = a[i], y = b[j], z = c[k].
3. Find min(x, y, z) and max(x, y, z). The difference is max - min.
4. Update the best triplet if difference is strictly smaller, or if difference is equal and sum is smaller (tie-breaking rule).
5. Increment the pointer pointing to the minimum value to potentially reduce the spread.
6. Return the chosen triplet in descending order: [max, mid, min].

### Complexity Analysis
- **Time Complexity:** O(n * log n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
import java.util.*;

class Solution {

    ArrayList<Integer> smallestDiff(int a[], int b[], int c[]) {

        int n = a.length;

        // Sort all three arrays
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;

        int bestDiff = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;

        int bestMax = 0;
        int bestMid = 0;
        int bestMin = 0;

        while (i < n && j < n && k < n) {

            int x = a[i];
            int y = b[j];
            int z = c[k];

            int min = Math.min(x, Math.min(y, z));
            int max = Math.max(x, Math.max(y, z));

            int diff = max - min;
            int sum = x + y + z;

            // Check whether this triplet is better
            if (diff < bestDiff ||
                (diff == bestDiff && sum < bestSum)) {

                bestDiff = diff;
                bestSum = sum;

                bestMax = max;
                bestMin = min;
                bestMid = sum - max - min;
            }

            // Move the pointer having the minimum value
            if (x == min) {
                i++;
            } else if (y == min) {
                j++;
            } else {
                k++;
            }
        }

        // Return in descending order
        ArrayList<Integer> result = new ArrayList<>();

        result.add(bestMax);
        result.add(bestMid);
        result.add(bestMin);

        return result;
    }
}
```
