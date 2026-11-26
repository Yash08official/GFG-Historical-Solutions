# Count Edges in Graph

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-number-of-edges-in-an-undirected-graph/1](https://www.geeksforgeeks.org/problems/count-number-of-edges-in-an-undirected-graph/1)  
**Problem ID:** `913857`  
**Slug:** `count-number-of-edges-in-an-undirected-graph`  
**Accepted Submission Date:** `2026-11-27 00:12:57`  

---

## Problem Statement

Given an undirected graph with **V** vertices numbered from **0** to **V - 1**, represented by an adjacency list **adj[][]**, where **adj[i]** contains the vertices adjacent to vertex **i. **

Return the total number of edges present in the graph.

**Examples:**
```text
**Input:** adj[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/913857/Web/Other/blobid0_1761566038.jpg" />

**Output: **4**
Explanation: **The edges in the graph are: (0-1), (0-2), (2-3), (1-2). Hence, total number of edges = 4.**
**
```

```text
**Input: **adj[][] = [[1], [0, 2], [1, 3], [2]]

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/913857/Web/Other/blobid1_1761566117.jpg" />

**Output: **3
**Explanation: **The edges in the graph are: (0-1), (1-2), (2-3). Hence, total number of edges = 3.
```

---

## Solution & Approach

### Approach Explanation

Sum of Degrees in Undirected Graph (Handshaking Lemma):
1. In an undirected graph, every edge (u, v) contributes twice to the total sum of degrees: once in the adjacency list of u and once in the adjacency list of v.
2. Iterate through all vertices 0 to |V| - 1 and sum the sizes of their adjacency lists: sum adj[i].size().
3. According to the Handshaking Lemma, sum deg(v) = 2 * |E|. Therefore, the total number of edges is count / 2.

### Complexity Analysis
- **Time Complexity:** O(V)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {

        int count = 0;

        for (int i = 0; i < adj.size(); i++) {
            count += adj.get(i).size();
        }

        return count / 2;
    }
}
```
