# Top View of Binary Tree

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1](https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1)  
**Problem ID:** `700490`  
**Slug:** `top-view-of-binary-tree`  
**Topic Tags:** `Tree`  
**Accepted Submission Date:** `2026-11-09 17:31:12`  
**Language:** `Java`  

---

## Problem Statement

Given a binary tree, return an array of nodes visible when looking at the tree from the top, ordered from leftmost horizontal distance to rightmost.

### Examples

```
Input: root[] = [1, 2, 3]
Output: [2, 1, 3]
Explanation: Looking from top, 2 is at HD -1, 1 is at HD 0, 3 is at HD +1.

Input: root[] = [10, 20, 30, 40, 60, 90, 100]
Output: [40, 20, 10, 30, 100]
Explanation: Top view nodes from left to right are 40, 20, 10, 30, 100.
```

---

## Approach

- **BFS Level-Order with Horizontal Distance (HD):**
  - Assign root HD = 0. Left child has HD - 1; right child has HD + 1.
  - Use a Queue for level-order traversal, storing `(Node, HD)` pairs.
  - Maintain a `TreeMap<Integer, Integer>` mapping HD to node value.
  - The first node encountered at any HD in level-order traversal is the top-most node visible at that HD.
  - Extract values from TreeMap in ascending order of HD.
- **Time Complexity:** $O(n \log n)$ due to TreeMap operations for $n$ nodes.
- **Space Complexity:** $O(n)$ for queue and map.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: e89776f056af90d392eff8f570268f75ea05dc66732e6e068abefc1299346d22`
