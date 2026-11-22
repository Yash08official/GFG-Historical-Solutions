import java.util.*;

class Solution {
    public int maximizeCuts(int n, int x, int y, int z) {

        // dp[i] = maximum cuts possible for length i
        int[] dp = new int[n + 1];

        // Initially, mark all lengths as impossible
        Arrays.fill(dp, -1);

        // Length 0 requires zero cuts
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            // Try cut length x
            if (i >= x && dp[i - x] != -1) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }

            // Try cut length y
            if (i >= y && dp[i - y] != -1) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }

            // Try cut length z
            if (i >= z && dp[i - z] != -1) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }

        // If no valid combination exists, return 0
        return Math.max(0, dp[n]);
    }
}
