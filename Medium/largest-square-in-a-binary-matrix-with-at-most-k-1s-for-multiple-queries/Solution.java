import java.util.*;

class Solution {

    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {

        int n = mat.length;
        int m = mat[0].length;

        // Build 2D prefix sum
        int[][] prefix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                prefix[i][j] =
                    mat[i - 1][j - 1]
                    + prefix[i - 1][j]
                    + prefix[i][j - 1]
                    - prefix[i - 1][j - 1];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Process each query
        for (int[] query : queries) {

            int i = query[0];
            int j = query[1];

            // Maximum possible radius
            int maxRadius = Math.min(
                Math.min(i, n - 1 - i),
                Math.min(j, m - 1 - j)
            );

            int low = 0;
            int high = maxRadius;

            int answer = -1;

            // Binary search for the largest valid square
            while (low <= high) {

                int mid = low + (high - low) / 2;

                // Square boundaries
                int top = i - mid;
                int bottom = i + mid;
                int left = j - mid;
                int right = j + mid;

                // Count ones inside the square
                int ones =
                    prefix[bottom + 1][right + 1]
                    - prefix[top][right + 1]
                    - prefix[bottom + 1][left]
                    + prefix[top][left];

                if (ones <= k) {

                    answer = 2 * mid + 1;

                    // Try a larger square
                    low = mid + 1;

                } else {

                    // Try a smaller square
                    high = mid - 1;
                }
            }

            result.add(answer);
        }

        return result;
    }
}