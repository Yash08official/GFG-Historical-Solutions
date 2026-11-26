# Max Prefix Sum For Range

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/maximum-prefix-sum-for-a-given-range0227/1](https://www.geeksforgeeks.org/problems/maximum-prefix-sum-for-a-given-range0227/1)  
**Problem ID:** `703668`  
**Slug:** `maximum-prefix-sum-for-a-given-range0227`  
**Accepted Submission Date:** `2026-11-26 13:43:17`  

---

## Problem Statement

Given an integer array **arr[]** and a 2D array **queries[][],** where each query consists of two indices [left, right], defining a range in the array (inclusive).

For each query, find the maximum prefix sum within the given range arr[left..right].

**Examples:**
```text
**Input:** arr[] = [-1, 2, 3, -5], queries[][] = [[0, 3], [1, 3]]
**Output:**[4, 5]
**Explanation: **For the range [0, 3], the prefix sums are [-1, 1, 4, -1]. The maximum is 4.
For the range [1, 3], the prefix sums are [2, 5, 0]. The maximum is 5.
```

```text
**Input:** arr[] = [1, -2, 3, 4, -5], queries[][] = [[0, 4], [2, 3], [1, 3]]
**Output: **[6, 7, 5]
**Explanation: **For the range [0, 4], the prefix sums are [1, -1, 2, 6, 1]. The maximum is 6. 
For the range [2, 3], the prefix sums are [3, 7]. The maximum is 7. 
For the range [1, 3], the prefix sums are [-2, 1, 5]. The maximum is 5.
```

**Constraints:
**1 ≤ n ≤ 105, where n is the size of the array
-104 ≤ arr[i] ≤ 104
1 ≤ q ≤ 104
0 ≤ leftIndex[i] ≤ rightIndex[i] < arr.size()

---

## Solution & Approach

### Approach Explanation

Segment Tree with Prefix and Total Sum Tracking:
1. Construct a segment tree where each node stores two properties: `sum` (total sum of the segment) and `maxPrefix` (maximum prefix sum within the segment).
2. When merging child nodes `left` and `right`:
   - `parent.sum = left.sum + right.sum`
   - `parent.maxPrefix = Math.max(left.maxPrefix, left.sum + right.maxPrefix)`
3. For each range query `[l, r]`, query the segment tree in O(log n) to find the merged node over range `[l, r]`. The result is given by `result.maxPrefix`.

### Complexity Analysis
- **Time Complexity:** O(n + q * log n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    static class Node {
        int sum;
        int maxPrefix;

        Node(int sum, int maxPrefix) {
            this.sum = sum;
            this.maxPrefix = maxPrefix;
        }
    }

    Node[] tree;

    // Merge two child nodes
    private Node merge(Node left, Node right) {

        int totalSum = left.sum + right.sum;

        int maxPrefix = Math.max(
            left.maxPrefix,
            left.sum + right.maxPrefix
        );

        return new Node(totalSum, maxPrefix);
    }

    // Build segment tree
    private void build(int[] arr, int node, int start, int end) {

        if (start == end) {
            tree[node] = new Node(arr[start], arr[start]);
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);

        tree[node] = merge(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Query maximum prefix sum in [l, r]
    private Node query(int node, int start, int end,
                       int l, int r) {

        // No overlap
        if (end < l || start > r) {
            return null;
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return tree[node];
        }

        // Partial overlap
        int mid = start + (end - start) / 2;

        Node left = query(2 * node, start, mid, l, r);

        Node right = query(2 * node + 1, mid + 1, end, l, r);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return merge(left, right);
    }

    public ArrayList<Integer> maxPrefixSumQueries(
            int[] arr, int[][] queries) {

        int n = arr.length;

        tree = new Node[4 * n];

        build(arr, 1, 0, n - 1);

        ArrayList<Integer> answer = new ArrayList<>();

        for (int[] q : queries) {

            int left = q[0];
            int right = q[1];

            Node result = query(1, 0, n - 1, left, right);

            answer.add(result.maxPrefix);
        }

        return answer;
    }
}
```
