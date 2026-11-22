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
