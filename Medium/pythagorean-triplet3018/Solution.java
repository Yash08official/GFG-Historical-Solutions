class Solution {
    boolean pythagoreanTriplet(int[] arr) {

        int n = arr.length;

        // Find the maximum element
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }

        // Store frequency of each number
        int[] freq = new int[max + 1];

        for (int num : arr) {
            freq[num]++;
        }

        // Consider every possible hypotenuse c
        for (int c = 1; c <= max; c++) {

            if (freq[c] == 0) {
                continue;
            }

            // Consider a and b such that a² + b² = c²
            for (int a = 1; a < c; a++) {

                int bSquared = c * c - a * a;
                int b = (int) Math.sqrt(bSquared);

                if (b < a || b > max) {
                    continue;
                }

                if (b * b == bSquared &&
                    freq[a] > 0 &&
                    freq[b] > 0) {

                    // Ensure different indexes
                    if (a != b || freq[a] >= 2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
