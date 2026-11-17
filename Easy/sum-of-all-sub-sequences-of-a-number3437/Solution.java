class Solution {
    public int subsequenceSum(String s) {

        long MOD = 1000000007L;
        int n = s.length();

        long sum = 0;
        long power = 1;

        // Calculate sum of all digits
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - '0';
        }

        // Calculate 2^(n-1) % MOD
        for (int i = 1; i < n; i++) {
            power = (power * 2) % MOD;
        }

        // Final answer
        return (int) ((sum * power) % MOD);
    }
}
