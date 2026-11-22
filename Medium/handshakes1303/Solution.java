class Solution {

    static int count(int n) {

        int[] dp = new int[n + 1];

        // Base case
        dp[0] = 1;

        // Calculate for even number of people
        for (int i = 2; i <= n; i += 2) {

            for (int j = 0; j < i; j += 2) {

                dp[i] += dp[j] * dp[i - 2 - j];
            }
        }

        return dp[n];
    }
}
