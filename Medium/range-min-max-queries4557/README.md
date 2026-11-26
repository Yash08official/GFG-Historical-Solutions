# Range Min Max Queries

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/range-min-max-queries4557/1](https://www.geeksforgeeks.org/problems/range-min-max-queries4557/1)  
**Problem ID:** `701697`  
**Slug:** `range-min-max-queries4557`  
**Accepted Submission Date:** `2026-11-26 13:41:03`  

---

## Problem Statement

Given an integer array **arr[] **and a 2D array **queries[][]**, where each query is one of the following two types:
- Type 1: [1, l, r] -> Return the minimum and maximum values in the range [l, r] (both inclusive).
- Type 2: [2, index, value] -> Update arr[index] to value.

Return an array containing the answers to all Type 1 queries in the order they appear in queries[][].

**Note:** Use 0-based indexing.

**Examples:**
```text
**Input: **arr[] = [11, 3, 7, 5, 9, 1], queries[][] = [[1, 0, 2],[2, 3, 17],[1, 0, 5]]
**Output:** [[3, 11], [1, 17]]
**Explanation:
**Query [1, 0, 2]: The minimum and maximum from index 0 to 2 is 3 and 11 respectively.
Query [2, 3, 17]: Update the value at index 3 from 5 to 17.
Query [1, 0, 5]: The minimum and maximum from index 0 to 5 is 1 and 17 respectively.
```

```text
**Input: **arr[] = [3, 1, 1, 2, 5], queries[][] = [[1, 0, 4]]**
****Output:** [1, 5]
**Explanation:
**Query [1, 0, 4]: The minimum and maximum from index 0 to 4 is 1 and 5 respectively.
```

**Constraints:
**

1 ≤ arr.size(), q ≤ 105
1 ≤ arr[i], value ≤ 104
0 ≤ l ≤ r < arr.size()
0 ≤ index < arr.size()

---

## Solution & Approach

### Approach Explanation

Dual Segment Tree for Range Extremes and Point Updates:
1. Maintain two segment trees: `minTree` tracking minimum values and `maxTree` tracking maximum values across segment intervals.
2. For point updates (Type 2), update the leaf at index `index` with `value` and update ancestor nodes in both trees with `min` and `max` respectively.
3. For range queries (Type 1), query both trees over interval `[l, r]` in O(log n) to retrieve `[rangeMin, rangeMax]`.

### Complexity Analysis
- **Time Complexity:** O(n + q * log n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    int[] minTree;
    int[] maxTree;

    // Build the segment tree
    private void build(int[] arr, int node, int start, int end) {

        if (start == end) {
            minTree[node] = arr[start];
            maxTree[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);

        minTree[node] = Math.min(
            minTree[2 * node],
            minTree[2 * node + 1]
        );

        maxTree[node] = Math.max(
            maxTree[2 * node],
            maxTree[2 * node + 1]
        );
    }

    // Update one array index
    private void update(int node, int start, int end,
                        int index, int value) {

        if (start == end) {
            minTree[node] = value;
            maxTree[node] = value;
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(2 * node, start, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, end, index, value);
        }

        // Recalculate the current node
        minTree[node] = Math.min(
            minTree[2 * node],
            minTree[2 * node + 1]
        );

        maxTree[node] = Math.max(
            maxTree[2 * node],
            maxTree[2 * node + 1]
        );
    }

    // Return minimum and maximum in range [l, r]
    private int[] query(int node, int start, int end,
                        int l, int r) {

        // No overlap
        if (end < l || start > r) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return new int[]{minTree[node], maxTree[node]};
        }

        // Partial overlap
        int mid = start + (end - start) / 2;

        int[] left = query(2 * node, start, mid, l, r);
        int[] right = query(2 * node + 1, mid + 1, end, l, r);

        return new int[]{
            Math.min(left[0], right[0]),
            Math.max(left[1], right[1])
        };
    }

    public ArrayList<ArrayList<Integer>> rangeMinMaxQueries(
            int[] arr, int[][] queries) {

        int n = arr.length;

        minTree = new int[4 * n];
        maxTree = new int[4 * n];

        build(arr, 1, 0, n - 1);

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                // Type 1: Range minimum and maximum
                int l = q[1];
                int r = q[2];

                int[] result = query(1, 0, n - 1, l, r);

                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(result[0]);
                pair.add(result[1]);

                answer.add(pair);

            } else {

                // Type 2: Point update
                int index = q[1];
                int value = q[2];

                arr[index] = value;

                update(1, 0, n - 1, index, value);
            }
        }

        return answer;
    }
}
```
