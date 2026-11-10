# Topological Sort

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/topological-sort/1](https://www.geeksforgeeks.org/problems/topological-sort/1)  
**Problem ID:** `700255`  
**Slug:** `topological-sort`  
**Topic Tags:** `Graph`, `Topological Sort`  
**Accepted Submission Date:** `2026-11-09 17:43:16`  
**Language:** `Java`  

---

## Problem Statement

Given an adjacency list for a Directed Acyclic Graph (DAG) with V vertices, return an array representing any valid topological sort ordering of the vertices.

### Examples

```
Input: adj = [[], [0], [0], [0]]
Output: [3, 2, 1, 0] or [1, 2, 3, 0]
Explanation: Vertices 1, 2, 3 all have edges pointing to 0 and must precede 0.

Input: adj = [[], [3], [3], [], [0, 1], [0, 2]]
Output: [5, 4, 2, 1, 3, 0]
Explanation: A valid topological ordering satisfying all directed edges.
```

---

## Approach

- **Kahn's Algorithm (BFS with In-Degrees):**
  - Calculate the in-degree of all vertices.
  - Enqueue all vertices with in-degree 0.
  - While queue is not empty, dequeue node `u`, append `u` to result, and decrement in-degree for all neighbors `v` of `u`.
  - If in-degree of `v` becomes 0, enqueue `v`.
- **Time Complexity:** $O(V + E)$ where $V$ is vertices and $E$ is edges.
- **Space Complexity:** $O(V)$ for queue and in-degree array.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: ab2b6fe103f44869f34bbec3fe17e88619a16bcf5240a5d5d3ece2c518694fae`
