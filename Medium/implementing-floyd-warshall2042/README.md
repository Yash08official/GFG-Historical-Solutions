# Floyd Warshall

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1](https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1)  
**Problem ID:** `705716`  
**Slug:** `implementing-floyd-warshall2042`  
**Accepted Submission Date:** `2026-11-22 20:32:41`  

---

## Problem Statement

Given a weighted** **directed graph, represented by an adjacency matrix **dist[][]**, where **dist[i][j] **represents the weight of the edge from node** i **to node** j**. If there is no direct edge, dist[i][j]** **is set to a large value (i.e., 108) to represent infinity.
The graph may contain negative edge weights, but it does not contain any negative weight cycles.

Find the shortest distance between every pair of nodes i and j in the graph.

**Note:** Modify the distances for every pair in place.

**Examples :**
```text
**Input: **dist[][] = [[0, 4, 108, 5, 108], [108, 0, 1, 108, 6], [2, 108, 0, 3, 108], [108, 108, 1, 0, 2], [1, 108, 108, 4, 0]]

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/893245/Web/Other/blobid0_1744701272.jpg" />

**Output: **[[0, 4, 5, 5, 7], [3, 0, 1, 4, 6], [2, 6, 0, 3, 5], [3, 7, 1, 0, 2], [1, 5, 5, 4, 0]]

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/893245/Web/Other/blobid1_1744701370.jpg" />

**Explanation: **Each cell dist[i][j] in the output shows the shortest distance from node i to node j, computed by considering all possible intermediate nodes. 

```

```text
**Input: **dist[][] = [[0, -1, 2], [1, 0, 108], [3, 1, 0]]

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/893245/Web/Other/blobid2_1744701698.jpg" />

**Output: **[[0, -1, 2], [1, 0, 3], [2, 1, 0]]

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/893245/Web/Other/blobid3_1744701713.jpg" />

**Explanation: **Each cell dist[i][j] in the output shows the shortest distance from node i to node j, computed by considering all possible intermediate nodes.
From 2 to 0 shortest distance should be 2 by following path 2 -> 1 -> 0
From 1 to 2 shortest distance should be 3 by following path 1 -> 0 -> 2
```

**Constraints:**
1 ≤ dist.size() ≤ 100
-1000 ≤ dist[i][j] ≤ 1000
dist[i][j] can be 108 to represent infinity.

---

## Solution & Approach

### Approach Explanation

All-Pairs Shortest Path via Floyd-Warshall:
1. Initialize distance matrix `dist` where unreachable edges are represented by 10^8 (`INF`).
2. Run three nested loops where `k` represents each candidate intermediate vertex.
3. For every pair `(i, j)`, update `dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])` provided paths through `k` are reachable.
4. Operates in-place on the distance matrix.

### Complexity Analysis
- **Time Complexity:** O(V^3) where V is the number of vertices
- **Auxiliary Space:** O(1) in-place modification of distance matrix

---

## Source Code

```java
class Solution {
    public void floydWarshall(int[][] dist) {

        int n = dist.length;

        // Consider every vertex as an intermediate vertex
        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    // Avoid adding infinity values
                    if (dist[i][k] != 100000000 &&
                        dist[k][j] != 100000000) {

                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }
    }
}
```
