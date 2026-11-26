# Kth Smallest in Subarray Queries

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/easy-query3301/1](https://www.geeksforgeeks.org/problems/easy-query3301/1)  
**Problem ID:** `705483`  
**Slug:** `easy-query3301`  
**Accepted Submission Date:** `2026-11-26 10:59:56`  

---

## Problem Statement

Given an integer array **arr[]** and a 2D array **queries[][]**, where each query is represented as [l, r, k], find the kth smallest element in the subarray nums[l...r] (using 1-based indexing). 

Return an array containing the answer for each query in the same order.

**Examples:**
```text
**Input: **arr[] = [4, 1, 2, 2, 3], queries[][] = [[1, 5, 2], [3, 5, 3]]
**Output: **[2, 3]
**Explanation: **For the 1st query 2nd smallest in [1, 5] is 2. For the 2nd query 3rd smallest in [3, 5] is 3.

```

```text
**Input: **arr[] = [1, 2, 3, 4, 5], queries[][] = [[2, 5, 1]]
**Output: **[2]
**Explanation: **The 1st smallest in [2, 5] is 2. 
```

**Constraints:**
1 ≤ n ≤ 15000
1 ≤ arr[i] ≤ n
1 ≤ no. of queries ≤ 104
1 ≤ l ≤ r ≤ n
1 ≤ k ≤ r-l+1

---

## Solution & Approach

### Approach Explanation

Square Root Decomposition (Mo's Algorithm) with Frequency / Fenwick Tree:
1. Answer offline range queries asking for the k-th smallest element in subarray `arr[L..R]`.
2. Coordinate compress the array values. Sort queries using Mo's ordering based on block decomposition `(L / BLOCK_SIZE, R)`.
3. Maintain active element frequencies in the current sliding window `[curL, curR]` using a Fenwick Tree (Binary Indexed Tree) or frequency buckets.
4. For each query, binary search on the Fenwick Tree to find the smallest value whose prefix frequency is >= k, then map back to original value.

### Complexity Analysis
- **Time Complexity:** O((n + q) * sqrt(n) * log n)
- **Auxiliary Space:** O(n + q)

---

## Source Code

```java
import java.util.*;

class Solution {

    int[] leftChild;
    int[] rightChild;
    int[] treeCount;

    int nodeCount;

    // Create a new version after inserting value
    int update(int previous, int start, int end, int value) {

        int current = ++nodeCount;

        // Copy information from previous version
        leftChild[current] = leftChild[previous];
        rightChild[current] = rightChild[previous];

        treeCount[current] = treeCount[previous] + 1;

        if (start == end) {
            return current;
        }

        int mid = start + (end - start) / 2;

        if (value <= mid) {

            leftChild[current] = update(
                leftChild[previous], start, mid, value
            );

        } else {

            rightChild[current] = update(
                rightChild[previous], mid + 1, end, value
            );
        }

        return current;
    }

    // Find kth smallest using two prefix versions
    int findKth(int rootR, int rootL,
                int start, int end, int k) {

        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;

        // Frequency of values in the left half
        int leftCount =
            treeCount[leftChild[rootR]]
            - treeCount[leftChild[rootL]];

        if (k <= leftCount) {

            return findKth(
                leftChild[rootR],
                leftChild[rootL],
                start, mid, k
            );

        } else {

            return findKth(
                rightChild[rootR],
                rightChild[rootL],
                mid + 1, end,
                k - leftCount
            );
        }
    }

    public ArrayList<Integer> findQuery(int[] arr, int[][] queries) {

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        // Calculate the maximum number of nodes per update
        int levels = 0;

        while ((1L << levels) < n) {
            levels++;
        }

        int capacity = n * (levels + 1) + 5;

        leftChild = new int[capacity];
        rightChild = new int[capacity];
        treeCount = new int[capacity];

        nodeCount = 0;

        // root[i] represents the first i elements
        int[] root = new int[n + 1];

        // Build persistent segment tree versions
        for (int i = 1; i <= n; i++) {

            root[i] = update(
                root[i - 1],
                1, n,
                arr[i - 1]
            );
        }

        // Answer all queries
        for (int[] query : queries) {

            int l = query[0];
            int r = query[1];
            int k = query[2];

            int answer = findKth(
                root[r],
                root[l - 1],
                1, n, k
            );

            result.add(answer);
        }

        return result;
    }
}
```
