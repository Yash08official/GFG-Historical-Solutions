# Directed Graph Cycle

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1](https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1)  
**Problem ID:** `700218`  
**Slug:** `detect-cycle-in-a-directed-graph`  
**Topic Tags:** `Graph`  
**Accepted Submission Date:** `2026-11-07 10:32:57`  
**Language:** `Java`  

---

## Problem Statement

Given a directed graph with `V` vertices, numbered from `0` to `V - 1`, represented by an adjacency list `adj[][]`, where `adj[u]` contains all vertices reachable from vertex `u` through a directed edge, check whether the graph contains a cycle.

**Note:** The graph may have multiple connected components. Self-loops are allowed, but repeated edges are not allowed.

### Examples

```
Input: adj = [[1], [2], [0, 3], []]
Output: true
Explanation: The graph contains a cycle 0 -> 1 -> 2 -> 0.
```

```
Input: adj = [[1], [2], [3], []]
Output: false
Explanation: The graph does not contain any cycle.
```

---

## Approach

- **Depth-First Search (DFS) with Path Tracking (3-Coloring Pattern):**
  - Maintain two boolean arrays:
    - `visited[V]`: Tracks whether a node has been fully explored across any DFS run.
    - `pathVisited[V]`: Tracks whether a node is currently part of the active DFS recursion stack (current path).
  - Iterate through all vertices `0` to `V - 1` to handle disconnected components.
  - If a vertex `i` is not yet visited, initiate `dfs(i)`.
  - In `dfs(node)`:
    - Mark `visited[node] = true` and `pathVisited[node] = true`.
    - For each outgoing neighbor in `adj.get(node)`:
      - If the neighbor is unvisited, recurse with `dfs(neighbour)`. If it returns `true`, propagate `true`.
      - Else if `pathVisited[neighbour] == true`: A back-edge pointing to an ancestor in the active recursion stack has been detected, which confirms a cycle. Return `true`.
    - Unmark `pathVisited[node] = false` (backtracking) upon returning from the node.
  - Return `false` if all components are traversed without detecting a back-edge.
- **Time Complexity:** $O(V + E)$ where $V$ is the number of vertices and $E$ is the number of directed edges.
- **Space Complexity:** $O(V)$ for the recursion call stack and boolean arrays.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 2aed9365221c803b3f76385089e09a4bc1b84b75b7f2ad3ec1eecb3b5483baa6`
