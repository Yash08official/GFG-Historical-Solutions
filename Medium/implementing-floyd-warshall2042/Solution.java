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
