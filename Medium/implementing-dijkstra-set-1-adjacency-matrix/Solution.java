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
