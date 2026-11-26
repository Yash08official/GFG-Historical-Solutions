# Range Minimum Query

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/range-minimum-query/1](https://www.geeksforgeeks.org/problems/range-minimum-query/1)  
**Problem ID:** `700229`  
**Slug:** `range-minimum-query`  
**Accepted Submission Date:** `2026-11-26 13:39:29`  

---

## Problem Statement

Given an integer array **arr[]** and a 2D integer array **queries[][] **of size **q × 2**, process all the queries using 0-based indexing.

Each query [l, r] asks for the minimum element present in the subarray **arr[l...r]**.

**Example:**
```text
**Input:** arr[] = [1, 2, 3, 4], queries[][] = [[0, 2], [2, 3]]
**Output: **[1, 3]
**Explanation:**
Query [0, 2]: The elements in arr[0...2] are [1, 2, 3]. The minimum element is 1.
Query [2, 3]: The elements in arr[2...3] are [3, 4]. The minimum element is 3.
```

```text
**Input:** arr[] = [7, 2, 9, 4], queries[][] = [[1, 1], [0, 3]]
**Output: **[2, 2]
**Explanation:**
Query [1, 1]: The subarray arr[1...1] contains only one element, 2. The minimum element is 2.
Query [0, 3]: The elements in arr[0...3] are [7, 2, 9, 4]. The minimum element is 2.
```

**Constraints:
**1 ≤ arr.size() ≤ 105
1 ≤ queries.size() ≤ 105
1 ≤ arr[i] ≤ 109
0 ≤ l ≤ r < arr.size()

---

## Solution & Approach

### Approach Explanation

Segment Tree Range Minimum Query (RMQ):
1. Build a segment tree over array `arr` where each internal node stores `Math.min(left_child, right_child)`.
2. Base cases for range queries `[l, r]`:
   - If node range is completely disjoint from `[l, r]`, return `Integer.MAX_VALUE`.
   - If node range is completely inside `[l, r]`, return `tree[node]`.
   - Otherwise, split query into left and right subtrees and return `Math.min(leftMin, rightMin)`.
3. Process each query independently in O(log n).

### Complexity Analysis
- **Time Complexity:** O(n + q * log n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    int[] tree;

    // Build the segment tree
    private void build(int[] arr, int node, int start, int end) {

        if (start == end) {

            tree[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, 2 * node, start, mid);

        build(arr, 2 * node + 1, mid + 1, end);

        tree[node] = Math.min(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Find minimum in a given range
    private int query(int node, int start, int end,
                      int l, int r) {

        // Case 1: No overlap
        if (end < l || start > r) {
            return Integer.MAX_VALUE;
        }

        // Case 2: Complete overlap
        if (start >= l && end <= r) {
            return tree[node];
        }

        // Case 3: Partial overlap
        int mid = start + (end - start) / 2;

        int leftMin = query(
            2 * node, start, mid, l, r
        );

        int rightMin = query(
            2 * node + 1, mid + 1, end, l, r
        );

        return Math.min(leftMin, rightMin);
    }

    public ArrayList<Integer> rangeMinQuery(int[] arr, int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = arr.length;

        tree = new int[4 * n];

        // Build segment tree
        build(arr, 1, 0, n - 1);

        // Process all queries
        for (int[] q : queries) {

            int l = q[0];
            int r = q[1];

            int minimum = query(1, 0, n - 1, l, r);

            result.add(minimum);
        }

        return result;
    }
}
```
