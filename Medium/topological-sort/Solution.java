import java.util.*;

class Solution {

    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        int[] indegree = new int[V];

        // Step 1: Calculate indegree
        for (int i = 0; i < V; i++) {

            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        // Step 2: Create Queue
        Queue<Integer> queue = new LinkedList<>();

        // Add vertices having indegree 0
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Step 3: BFS
        while (!queue.isEmpty()) {

            int node = queue.poll();

            result.add(node);

            // Visit neighbours
            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return result;
    }
}
