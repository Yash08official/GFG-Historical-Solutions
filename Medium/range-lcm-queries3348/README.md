# Range LCM Queries

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/range-lcm-queries3348/1](https://www.geeksforgeeks.org/problems/range-lcm-queries3348/1)  
**Problem ID:** `701713`  
**Slug:** `range-lcm-queries3348`  
**Accepted Submission Date:** `2026-11-26 13:37:49`  

---

## Problem Statement

Given an array **arr[]**  and a list of queries **queries[][]**. Each query can be one of the following two types:
- **Update Query:** [1, index, value] --> Update the element at position index in the array to the given value.
- **Range Query:** [2, L, R] --> Compute and return the Least Common Multiple (LCM) of all elements in the subarray from index **L** to **R** (inclusive).

Process all queries sequentially and return a list containing the results of all Type 2 queries.

**Note:** All operations follow 0-based indexing.

**Examples :**
```text
**Input: **arr[] = [2, 3, 4, 6, 8, 16], queries[][] = [[2, 0, 2], [1, 3, 8], [2, 2, 5]]
**Output:** [12, 16]**
Explanation: **The queries are processed sequentially, updating the array when required.
[2, 0, 2]: LCM of [2, 3, 4] = 12
[1, 3, 8]: array becomes [2, 3, 4, 8, 8, 16]
[2, 2, 5]: LCM of [4, 8, 8, 16] = 16
```

```text
**Input: **arr[] = [1, 2, 3, 4],  queries[][] = [[2, 0, 3], [1, 0, 5], [2, 0, 1]]
**Output:** [12, 10]**
Explanation: **The queries are processed sequentially, updating the array when required.
[2, 0, 3]: LCM of [1, 2, 3, 4] = 12
[1, 0, 5]: array becomes [5, 2, 3, 4]
[2, 0, 1]: LCM of [5, 2] = 10

```

**Constraints:**
1 ≤ arr.size() ≤ 104
1 ≤ queries.size() ≤ 105
0 ≤ L ≤ R ≤ arr.size() - 1
0 ≤ index ≤ arr.size() - 1
1 ≤ arr[i], value** **≤ 104

---

## Solution & Approach

### Approach Explanation

Segment Tree with Associative LCM Operation:
1. Least Common Multiple (LCM) is associative: lcm(a, b, c) = lcm(lcm(a, b), c).
2. Implement `gcd(a, b)` using Euclid's algorithm and `lcm(a, b) = (a / gcd(a, b)) * b`.
3. Construct a segment tree where `tree[node] = lcm(tree[2*node], tree[2*node+1])`.
4. Point updates update the leaf and pull LCM values upward in O(log n * log(max A)).
5. Range queries combine child LCM values over `[l, r]` in O(log n * log(max A)).

### Complexity Analysis
- **Time Complexity:** O((n + q) * log n * log(max A))
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    long[] tree;
    int n;

    // Calculate GCD using Euclid's algorithm
    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // Calculate LCM
    private long lcm(long a, long b) {

        if (a == 0 || b == 0) {
            return 0;
        }

        return (a / gcd(a, b)) * b;
    }

    // Build segment tree
    private void build(int[] arr, int node, int start, int end) {

        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, 2 * node, start, mid);

        build(arr, 2 * node + 1, mid + 1, end);

        tree[node] = lcm(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Update array element
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

        // Recalculate parent LCM
        tree[node] = lcm(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Calculate LCM in a given range
    private long query(int node, int start, int end,
                       int l, int r) {

        // No overlap
        if (end < l || start > r) {
            return 1;
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;

        long left = query(
            2 * node, start, mid, l, r
        );

        long right = query(
            2 * node + 1, mid + 1, end, l, r
        );

        return lcm(left, right);
    }

    public ArrayList<Long> rangeLCMQuery(int[] arr, int[][] queries) {

        ArrayList<Long> result = new ArrayList<>();

        n = arr.length;

        tree = new long[4 * n];

        // Build initial segment tree
        build(arr, 1, 0, n - 1);

        // Process queries sequentially
        for (int[] q : queries) {

            int type = q[0];

            if (type == 1) {

                int index = q[1];
                int value = q[2];

                // Update original array
                arr[index] = value;

                // Update segment tree
                update(1, 0, n - 1, index, value);

            } else {

                int l = q[1];
                int r = q[2];

                long answer = query(1, 0, n - 1, l, r);

                result.add(answer);
            }
        }

        return result;
    }
}
```
