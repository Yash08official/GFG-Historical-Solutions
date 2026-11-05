# Undirected Graph Cycle

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1](https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)  
**Problem ID:** `700219`  
**Slug:** `detect-cycle-in-an-undirected-graph`  
**Topic Tags:** `DFS`, `Graph`, `union-find`  
**Accepted Submission Date:** `2026-11-05 21:48:33`  
**Language:** `Java`  

---

## Problem Statement

Given an undirected graph with `V` vertices, represented by an adjacency list `adj[][]`, where `adj[u]` contains all vertices adjacent to vertex `u`, check whether the graph contains a cycle.

**Note:** The graph may have multiple connected components.

### Examples

```
Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
Output: true
Explanation: The vertices 0, 1, and 2 form a cycle (0 -> 1 -> 2 -> 0).
```

```
Input: adj[][] = [[1], [0, 2], [1]]
Output: false
Explanation: The graph does not contain any cycle.
```

---

## Approach

- **Breadth-First Search (BFS):**
  - Iterate through all vertices `0` to `V - 1` to ensure all disconnected components are handled.
  - For each unvisited vertex, initiate a BFS queue storing pairs of `(current_node, parent_node)`.
  - Mark the starting node as visited with a parent of `-1`.
  - While the queue is non-empty, dequeue `(node, parent)`. For each adjacent neighbor:
    - If the neighbor has not been visited, mark it visited and push `(neighbor, node)` to the queue.
    - If the neighbor is already visited and is not the immediate parent, a back-edge exists, meaning a cycle is detected; return `true`.
  - If BFS completes across all components without finding a cycle, return `false`.
- **Time Complexity:** `O(V + E)` where `V` is the number of vertices and `E` is the number of edges.
- **Space Complexity:** `O(V)` for the visited array and BFS queue.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 655997aa38de1f45dd3426e93a4a1d6b359000a9228a7757865ac8cb8557b20d`
