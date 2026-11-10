# Zig-Zag Tree Traversal

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/zigzag-tree-traversal/1](https://www.geeksforgeeks.org/problems/zigzag-tree-traversal/1)  
**Problem ID:** `700688`  
**Slug:** `zigzag-tree-traversal`  
**Topic Tags:** `Traversal`, `Tree`  
**Accepted Submission Date:** `2026-11-09 17:34:11`  
**Language:** `Java`  

---

## Problem Statement

Given a binary tree with n nodes, return the zigzag level order traversal of its nodes' values.

### Examples

```
Input: root[] = [1, 2, 3, 4, 5, 6, 7]
Output: [1, 3, 2, 4, 5, 6, 7]
Explanation: Level 1: [1] (L to R), Level 2: [3, 2] (R to L), Level 3: [4, 5, 6, 7] (L to R).

Input: root[] = [7, 9, 7, 8, 8, 6]
Output: [7, 7, 9, 8, 8, 6]
```

---

## Approach

- **Level-Order BFS with Direction Flag:**
  - Queue-based standard BFS.
  - Maintain boolean `leftToRight = true`.
  - For each level: if `leftToRight`, append to level list; else insert at index 0.
  - Toggle `leftToRight = !leftToRight` after each level.
- **Time Complexity:** $O(n)$ where $n$ is number of nodes.
- **Space Complexity:** $O(n)$ for queue and level storage.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: ac8a8c0505b154733655faa57389d718ca41b3d4ec97ca478b809361d1d1b955`
