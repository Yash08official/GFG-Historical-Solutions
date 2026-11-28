# Path Exists Between Two Vertices

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/path-exists/1](https://www.geeksforgeeks.org/problems/path-exists/1)  
**Problem ID:** `913763`  
**Slug:** `path-exists`  
**Accepted Submission Date:** `2026-11-28 10:41:21`  

---

## Problem Statement

Given an undirected graph with **V** vertices numbered from 0 to V - 1, represented by an adjacency list **adj[][]**, where adj[i] contains all vertices adjacent to vertex** i**. Also given two vertices **u **and **v**, check whether a path exists between them.

Return true if a path exists, otherwise return false.

**Examples:**

 
```text
**Input:** adj[][] = [[2, 3], [2], [0, 1], [0], [5], [4]], u = 1, v = 5

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20251014110602842995/420046859.webp" />

**Output: **false
**Explanation: **There is no path from vertex 1 to vertex 5.
```

```text
**Input: **adj[][] = [[2, 3], [2], [0, 1], [0], [5], [4]], u = 2, v = 3

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20251014110602842995/420046859.webp" />

**Output: **true
**Explanation: **We can reach vertex 3 from vertex 2 via vertex 0.

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20251014110602797647/1.webp" />

```

---

## Solution & Approach

### Approach Explanation

Breadth-First Search (BFS):
1. Initialize a boolean array `visited` of size V and a FIFO queue.
2. Enqueue the starting vertex u and mark it as visited.
3. While the queue is non-empty, dequeue vertex `current`. If `current == v`, destination is reachable; return true.
4. For every unvisited neighbor of `current`, mark as visited and enqueue.
5. If traversal exhausts without reaching v, return false.

### Complexity Analysis
- **Time Complexity:** O(V + E)
- **Auxiliary Space:** O(V)

---

## Source Code

```java
import java.util.*;

class Solution {
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {

        int V = adj.size();

        // Track which vertices have been visited.
        boolean[] visited = new boolean[V];

        // Queue stores vertices waiting to be visited.
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from vertex u.
        queue.add(u);
        visited[u] = true;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            // Destination reached.
            if (current == v) {
                return true;
            }

            // Visit all adjacent vertices.
            for (int neighbor : adj.get(current)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
}
```
