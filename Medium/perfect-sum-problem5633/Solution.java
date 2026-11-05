class Solution {
    static int perfectSum(int[] arr, int target) {
        int n = arr.length;

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 0; i < n; i++) {

            for (int j = target; j >= arr[i]; j--) {

                dp[j] += dp[j - arr[i]];
            }
        }

        return dp[target];
    }
}
