# Closest in BST

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1](https://www.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1)  
**Problem ID:** `700423`  
**Slug:** `find-the-closest-element-in-bst`  
**Accepted Submission Date:** `2026-11-12 09:38:03`  

---

## Problem Statement

Given the root of a Binary Search Tree (BST) and an integer `k`, find the minimum absolute difference between `k` and the value of any node in the BST.

**Examples:**
```text
Input: root = [10, 2, 11, 1, 5, N, N, N, N, 3, 6, N, 4], k = 13
Output: 2
Explanation: The node with value 11 is closest to k = 13. So, the minimum absolute difference is |11 - 13| = 2.
```
```text
Input: root = [8, 1, 9, N, 4, N, 10, 3], k = 9
Output: 0
Explanation: The node with value 9 has minimum absolute difference with 9, which is 0.
```

**Constraints:**
- $1 \le 	ext{number of nodes} \le 10^5$
- $1 \le 	ext{node}->	ext{data} \le 10^5$
- $1 \le k \le 10^5$

---

## Solution & Approach

### Approach Explanation

Leverage the Binary Search Tree property to search for the value closest to `k`:
1. Start at `root` and track `minDiff = Integer.MAX_VALUE`.
2. At each node, compute `|curr.data - k|` and update `minDiff`.
3. If `diff == 0`, return `0` immediately (an exact match cannot be improved).
4. If `k < curr.data`, the closest node could be in the left subtree, so move left.
5. If `k > curr.data`, move right.
6. Return `minDiff` once the traversal ends.

### Complexity Analysis
- **Time Complexity:** O(h) where h is the height of the BST (O(log n) average, O(n) worst case)
- **Auxiliary Space:** O(1) auxiliary space (iterative traversal)

---

## Source Code

```java
class Solution {

    public int minDiff(Node root, int k) {

        int minDiff = Integer.MAX_VALUE;

        Node curr = root;

        while (curr != null) {

            // Calculate absolute difference
            int diff = Math.abs(curr.data - k);

            // Update minimum difference
            minDiff = Math.min(minDiff, diff);

            // Exact match found
            if (diff == 0) {
                return 0;
            }

            // Move according to BST property
            if (k < curr.data) {

                curr = curr.left;

            } else {

                curr = curr.right;
            }
        }

        return minDiff;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: 490c757c45f9e5b3bf7226f3a9e6db3bbf06b22667f4d378f00fbecc5a22cdf6`)
