# Interval List Intersections

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/interval-list-intersections/1](https://www.geeksforgeeks.org/problems/interval-list-intersections/1)  
**Problem ID:** `891250`  
**Slug:** `interval-list-intersections`  
**Accepted Submission Date:** `2026-11-27 00:31:26`  

---

## Problem Statement

Given two 2D arrays **a[][]** and **b[][]** which represent intervals. Each 2D array represents a list of intervals. Each list of intervals is disjoint (no common) and sorted in increasing order. Find the intersection or set of ranges that are common to both the lists.

**Examples:**
```text
**Input:** a[][] = [[0, 4], [5, 10], [13, 20], [24, 25]], b[][] = [[1, 5], [8, 12], [15, 24], [25, 26]] 
**Output:** [[1, 4], [5, 5], [8, 10], [15, 20], [24, 24], [25, 25]]
**Explanation:** [1, 4] lies completely within the range [0, 4] and [1, 5]. Hence, [1, 4] is the desired intersection. Similarly, [24, 24] lies completely within two intervals [24, 25] and [15, 24]
```

```text
**Input: **a[][] = [[0, 2], [5, 10], [12, 22], [24, 25]], b[][] = [[1, 4], [9, 12], [15, 24], [25, 26]]
**Output: **[[1, 2], [9, 10], [12, 12], [15, 22], [24, 24], [25, 25]]
**Explanation**: [1, 2] lies completely within the range [0, 2] and [1, 4]. Hence, [1, 2] is the desired intersection. Similarly, [12, 12] lies completely within two intervals [12, 22] and [9, 12]

```

**Constraints
**1 ≤ a.size(), b.size() ≤ 105
-109 ≤ a[i], b[i] ≤ 109

---

## Solution & Approach

### Approach Explanation

Two-Pointer Interval Sweep:
1. Maintain two pointers i and j to iterate through sorted disjoint interval lists a and b respectively.
2. At each step, calculate the potential overlap: `start = Math.max(a[i][0], b[j][0])` and `end = Math.min(a[i][1], b[j][1])`.
3. If `start <= end`, an intersection exists; add [start, end] to the result.
4. Advance the pointer corresponding to the interval that finishes earlier (i.e. if `a[i][1] < b[j][1]`, increment i, else increment j) since that interval cannot overlap with any subsequent intervals.

### Complexity Analysis
- **Time Complexity:** O(n + m)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> findIntersection(int[][] a, int[][] b) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {

            // Find the overlapping range
            int start = Math.max(a[i][0], b[j][0]);
            int end = Math.min(a[i][1], b[j][1]);

            // Check if an intersection exists
            if (start <= end) {

                ArrayList<Integer> intersection = new ArrayList<>();

                intersection.add(start);
                intersection.add(end);

                result.add(intersection);
            }

            // Move the interval that ends earlier
            if (a[i][1] < b[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
```
