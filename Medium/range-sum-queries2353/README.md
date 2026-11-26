# Range Sum Queries with Update

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/range-sum-queries2353/1](https://www.geeksforgeeks.org/problems/range-sum-queries2353/1)  
**Problem ID:** `701689`  
**Slug:** `range-sum-queries2353`  
**Accepted Submission Date:** `2026-11-26 13:42:06`  

---

## Problem Statement

Given an integer array **arr[]** and a 2D array **queries[][]**, where each query is one of the following two types:
- Type 1: [1, l, r] ->  Return the sum of all elements in the range [l, r] (both inclusive).
- Type 2: [2, index, value] -> Update arr[index] to value.

Return an array containing the answers to all Type 1 queries in the order they appear in queries[][].

**Note:** Use 0-based indexing.

**Examples:**
```text
**Input: **arr[] = [1, 3, 5, 7, 9, 11], queries = [[1, 0, 2], [2, 3, 17], [1, 0, 5]]
**Output: **[9, 46]**
Explanation: 
**Query [1, 0, 2]: The sum of elements from index 0 to 2 is 1 + 3 + 5 = 9.
Query [2, 3, 17]: Update the value at index 3 from 7 to 17.
Query [1, 0, 5]: The sum of elements from index 0 to 5 is 1 + 3 + 5 + 17 + 9 + 11 = 46.

```

```text
**Input: **arr[] = [2, 4, 6, 8], queries[][] = [[1, 1, 3], [2, 2, 10], [1, 0, 2], [2, 0, 5], [1, 0, 3]]
**Output: **[18, 16, 27]**
Explanation: 
**Query [1, 1, 3]: The sum of elements from index 1 to 3 is 4 + 6 + 8 = 18.
Query [2, 2, 10]: Update the value at index 2 from 6 to 10.
Query [1, 0, 2]: The sum of elements from index 0 to 2 is 2 + 4 + 10 = 16.
Query [2, 0, 5]: Update the value at index 0 from 2 to 5.
Query [1, 0, 3]: The sum of elements from index 0 to 3 is 5 + 4 + 10 + 8 = 27.

```

**Constraints:
**1 ≤ n, q ≤ 105, where n is the size of the array
1 ≤ arr[i], value ≤ 104
0 ≤ l ≤ r < n
0 ≤ index < n

---

## Solution & Approach

### Approach Explanation

Segment Tree for Range Sum and Point Updates:
1. Build a segment tree of size 4n where each internal node stores the sum of its child nodes: `tree[node] = tree[2*node] + tree[2*node+1]`.
2. For range sum queries (Type 1), recursively traverse segment tree nodes that overlap with range `[l, r]` in O(log n).
3. For point updates (Type 2), update the leaf node at index `index` with `value` and recalculate all ancestor sums in O(log n).

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

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // Update an element at a given index
    private void update(int node, int start, int end,
                        int index, int value) {

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(2 * node, start, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, end, index, value);
        }

        // Recalculate the parent sum
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // Find sum in range [l, r]
    private int query(int node, int start, int end,
                      int l, int r) {

        // No overlap
        if (end < l || start > r) {
            return 0;
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return tree[node];
        }

        // Partial overlap
        int mid = start + (end - start) / 2;

        int leftSum = query(2 * node, start, mid, l, r);
        int rightSum = query(2 * node + 1, mid + 1, end, l, r);

        return leftSum + rightSum;
    }

    public ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {

        int n = arr.length;

        tree = new int[4 * n];

        build(arr, 1, 0, n - 1);

        ArrayList<Integer> answer = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                // Type 1: Range sum query
                int l = q[1];
                int r = q[2];

                int sum = query(1, 0, n - 1, l, r);

                answer.add(sum);

            } else {

                // Type 2: Update array element
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
