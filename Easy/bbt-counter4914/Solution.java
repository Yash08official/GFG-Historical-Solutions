class Solution {
    public int countBT(int h) {
        long MOD = 1000000007L;

        if (h == 0 || h == 1) {
            return 1;
        }

        long a = 1; // dp[0]
        long b = 1; // dp[1]

        for (int i = 2; i <= h; i++) {

            long c = (b * b) % MOD;

            c = (c + (2 * b % MOD) * a % MOD) % MOD;

            a = b;
            b = c;
        }

        return (int) b;
    }
}
