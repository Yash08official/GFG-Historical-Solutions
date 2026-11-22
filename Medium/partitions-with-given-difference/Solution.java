class Solution {
    public int countPartitions(int[] arr, int diff) {

        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        // No valid partition possible
        if (sum < diff || (sum + diff) % 2 != 0) {
            return 0;
        }

        int target = (sum + diff) / 2;

        // dp[s] = number of ways to make sum s
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int num : arr) {

            for (int s = target; s >= num; s--) {

                dp[s] += dp[s - num];
            }
        }

        return dp[target];
    }
}
