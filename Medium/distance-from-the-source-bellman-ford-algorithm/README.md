# Bellman Ford

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1](https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1)  
**Problem ID:** `706218`  
**Slug:** `distance-from-the-source-bellman-ford-algorithm`  
**Accepted Submission Date:** `2026-11-22 19:23:58`  

---

## Problem Statement

Given a weighted graph with **V** vertices numbered from 0 to V-1 and edges, represented by a 2d array **edges[][]**, where** **edges[i] = [u, v, w] represents a direct edge from node** **u to v having w edge weight. You are also given a source vertex **src**.

Compute the shortest distances from the src to all other vertices. If a vertex is unreachable from the src, its distance should be marked as 108. Additionally, if the graph contains a negative weight cycle, return [-1] to indicate that shortest paths cannot be reliably computed.

**Examples:**
```text
**Input: **V = 5, edges[][] = [[1, 3, 2], [4, 3, -1], [2, 4, 1], [1, 2, 1], [0, 1, 5]], src = 0

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/893096/Web/Other/blobid0_1744455175.jpg" />

**Output:** [0, 5, 6, 6, 7]
**Explanation**: Shortest Paths:
For 0 to 1 minimum distance will be 5. By following path 0 -> 1
For 0 to 2 minimum distance will be 6. By following path 0 -> 1 -> 2
For 0 to 3 minimum distance will be 6. By following path 0 -> 1 -> 2 -> 4 -> 3 
For 0 to 4 minimum distance will be 7. By following path 0 -> 1 -> 2 -> 4

```

```text
**Input: **V = 4, edges[][] = [[0, 1, 4], [1, 2, -6], [2, 3, 5], [3, 1, -2]], src = 0

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/893096/Web/Other/blobid1_1744455218.jpg" />

**Output: **[-1]
**Explanation**: The graph contains a negative weight cycle formed by the path 1 -> 2 -> 3 -> 1, where the total weight of the cycle is negative.

```

**Constraints:
**1 ≤ V ≤ 100
1 ≤ E = edges.size() ≤ V*(V-1)
-1000 ≤ w ≤ 1000
0 ≤ src < V

---

## Solution & Approach

### Approach Explanation

Bellman-Ford Algorithm for Shortest Path & Negative Cycle Detection:
1. Initialize distance array with 10^8 (`INF`) and set `dist[src] = 0`.
2. Relax all edges up to `V - 1` times. If no distance is updated in any pass, terminate early.
3. Perform an additional relaxation pass over all edges. If any distance can still be decreased, a negative weight cycle exists; return `[-1]`.
4. Otherwise, return the computed shortest distance array.

### Complexity Analysis
- **Time Complexity:** O(V * E) where V is vertices and E is edges
- **Auxiliary Space:** O(V) for the distance array

---

## Source Code

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        int INF = 100000000;

        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        dist[src] = 0;

        // Step 1: Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {

            boolean updated = false;

            for (int[] edge : edges) {

                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] != INF && dist[u] + w < dist[v]) {

                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }

            // No changes means shortest distances are finalized
            if (!updated) {
                break;
            }
        }

        // Step 2: Check for negative weight cycle
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] != INF && dist[u] + w < dist[v]) {
                return new ArrayList<>(Arrays.asList(-1));
            }
        }

        // Step 3: Convert distance array to ArrayList
        ArrayList<Integer> result = new ArrayList<>();

        for (int d : dist) {
            result.add(d);
        }

        return result;
    }
}
```
