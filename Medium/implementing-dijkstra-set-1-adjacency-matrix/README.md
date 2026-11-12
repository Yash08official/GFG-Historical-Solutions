# Dijkstra Algorithm

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1](https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1)  
**Problem ID:** `700334`  
**Slug:** `implementing-dijkstra-set-1-adjacency-matrix`  
**Accepted Submission Date:** `2026-11-12 09:40:19`  

---

## Problem Statement

Given a connected, weighted, undirected graph with `V` vertices and no negative edge weights, represented by an adjacency list `adj[][][]`, and a source vertex `src`, calculate the shortest distance from `src` to every vertex in the graph.

Each `adj[u]` contains pairs `[v, wt]`, where `v` is an adjacent vertex and `wt` is the weight of the edge connecting vertices `u` and `v`. Return an array of integers where the $i$-th element represents the shortest distance from `src` to vertex $i$.

**Examples:**
```text
Input: V = 3, adj = [[[1, 1], [2, 6]], [[2, 3], [0, 1]], [[1, 3], [0, 6]]], src = 2
Output: [4, 3, 0]
Explanation:
For vertex 0: 2 -> 1 -> 0 (cost: 3 + 1 = 4)
For vertex 1: 2 -> 1 (cost: 3)
For vertex 2: 2 (cost: 0)
```

**Constraints:**
- $1 \le V \le 10^5$
- $0 \le 	ext{weight of each edge} \le 10^5$
- $0 \le src < V$

---

## Solution & Approach

### Approach Explanation

Classic Dijkstra's Shortest Path Algorithm using a Min-Heap (PriorityQueue):
1. Initialize a distance array `dist` of size `V` with `Long.MAX_VALUE`, setting `dist[src] = 0`.
2. Use a `PriorityQueue<long[]>` ordered by distance storing `{distance, vertex}`.
3. Push `{0, src}` into the priority queue.
4. While the queue is not empty, extract the minimum distance node `{currentDist, node}`. Skip if `currentDist != dist[node]` (outdated entry).
5. For each neighbor of `node`, perform edge relaxation: if `currentDist + weight < dist[neighbour]`, update `dist[neighbour]` and insert the new pair into the queue.
6. Convert the distance array to `ArrayList<Integer>` and return.

### Complexity Analysis
- **Time Complexity:** O((V + E) log V) where V is the number of vertices and E is the number of edges
- **Auxiliary Space:** O(V + E) for priority queue and distance array

---

## Source Code

```java
import java.util.*;

class Solution {

    public ArrayList<Integer> dijkstra(
        ArrayList<ArrayList<ArrayList<Integer>>> adj,
        int src) {

        int V = adj.size();

        // Step 1: Initialize distances
        long[] dist = new long[V];

        Arrays.fill(dist, Long.MAX_VALUE);

        // Step 2: Min Heap
        // Each entry: {distance, vertex}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        // Source distance = 0
        dist[src] = 0;

        pq.add(new long[]{0, src});

        // Step 3: Process vertices
        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            long currentDist = current[0];
            int node = (int) current[1];

            // Skip outdated entries
            if (currentDist != dist[node]) {
                continue;
            }

            // Step 4: Visit neighbours
            for (ArrayList<Integer> edge : adj.get(node)) {

                int neighbour = edge.get(0);
                int weight = edge.get(1);

                long newDist = currentDist + weight;

                // Relaxation
                if (newDist < dist[neighbour]) {

                    dist[neighbour] = newDist;

                    pq.add(new long[]{newDist, neighbour});
                }
            }
        }

        // Step 5: Prepare result
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            result.add((int) dist[i]);
        }

        return result;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: 35182a2d42c754fb3547fc64907c1da42221cc146bbda8dff677c42cbd775ceb`)
