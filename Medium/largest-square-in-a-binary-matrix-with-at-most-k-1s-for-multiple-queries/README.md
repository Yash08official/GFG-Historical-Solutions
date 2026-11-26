# Largest Odd Squares  with Limited 1s

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/largest-square-in-a-binary-matrix-with-at-most-k-1s-for-multiple-queries/1](https://www.geeksforgeeks.org/problems/largest-square-in-a-binary-matrix-with-at-most-k-1s-for-multiple-queries/1)  
**Problem ID:** `706309`  
**Slug:** `largest-square-in-a-binary-matrix-with-at-most-k-1s-for-multiple-queries`  
**Accepted Submission Date:** `2026-11-26 14:03:28`  

---

## Problem Statement

Given a binary matrix **mat[][]** of size n*m and an integer **k**, process a list of queries **queries[][]**. Each query contains coordinates [i, j] of the center of a square.

- For every query, find the side length of the largest odd-sized square centered at cell (i, j) such that the square contains at most k ones.

-  A square centered at (i, j) expands outward symmetrically in all four directions by the same number of cells, so its side length is always odd.

**Note:** If no odd-sized square centered at the given cell satisfies the condition of containing at most k ones, return -1 for that query.

**Examples:**

```text
**Input: **mat[][] = [[1, 0, 1, 0, 0], [1, 0, 1, 1, 1], [1, 1, 1, 1, 1], [1, 0, 0, 1, 0]], queries[][] = [[1, 2]], k = 9
**Output:** [3]
**Explanation:** The largest odd-sized square centered at (1, 2) is the 3 × 3 square spanning rows 0 to 2 and columns 1 to 3. 
It contains 6 ones, which is at most k = 9. Hence, the answer is 3.
```

```text
**Input:** mat[][] = [[1, 1, 1], [1, 1, 1], [1, 1, 1]], queries[][] = [[1, 1], [2, 2]], K = 9
**Output: **[3, 1]**
Explanation: **For query (1, 1), the largest valid square is the entire 3 × 3 matrix, which contains 9 ones. Hence, the answer is 3.
For query (2, 2), no expansion is possible without going outside the matrix, so only the 1 × 1 square centered at (2, 2) is valid. Hence, the answer is 1.
```

**Constraints:
**1 ≤ mat.size(), mat[0].size() ≤ 500
1 ≤ queries.size() ≤ 104
0 ≤ queries[q][0] < mat.size()
0 ≤ queries[q][1] < mat[0].size()
0 ≤ k ≤ mat.size() * mat[0].size()

---

## Solution & Approach

### Approach Explanation

2D Prefix Sum with Binary Search on Square Radius:
1. Build a 2D prefix sum table over matrix `mat` of dimensions n x m to query the count of 1s in any rectangular subgrid in O(1) time.
2. For each query centered at (i, j), an odd square with side length 2 * r + 1 has radius r bounded by min(i, n - 1 - i, j, m - 1 - j).
3. The number of 1s is monotonically non-decreasing with respect to radius r. Perform binary search on r in [0, maxRadius].
4. For each midpoint `mid`, calculate total 1s in O(1) using the 2D prefix sum. If count <= k, record side length 2 * mid + 1 and try larger r, else try smaller r.

### Complexity Analysis
- **Time Complexity:** O(n * m + q * log(min(n, m)))
- **Auxiliary Space:** O(n * m)

---

## Source Code

```java
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
```
