import java.util.*;

class Solution {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        boolean[] visited = new boolean[V];

        // Check all connected components
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                Queue<int[]> q = new LinkedList<>();

                q.add(new int[]{i, -1});
                visited[i] = true;

                while (!q.isEmpty()) {

                    int[] curr = q.poll();

                    int node = curr[0];
                    int parent = curr[1];

                    for (int neighbour : adj.get(node)) {

                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            q.add(new int[]{neighbour, node});
                        }

                        else if (neighbour != parent) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
