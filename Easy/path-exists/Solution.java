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