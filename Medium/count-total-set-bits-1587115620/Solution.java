class Solution {
    public static int countSetBits(int n) {

        if (n == 0) {
            return 0;
        }

        // Find the largest power of 2 <= n
        int x = 0;

        while ((1 << (x + 1)) <= n) {
            x++;
        }

        // Set bits from 1 to (2^x - 1)
        int bits = x * (1 << (x - 1));

        // Remaining numbers after 2^x
        int remaining = n - (1 << x) + 1;

        // Set bits in the most significant position
        int msb = remaining;

        // Recursively count remaining set bits
        int rest = countSetBits(n - (1 << x));

        return bits + msb + rest;
    }
}
