class Solution {

    public char posInfinite(String s, int pos) {

        long length = s.length();
        long p = pos;

        int step = 0;

        // Find the generation containing the required position
        while (length < p) {
            step++;
            length = 2 * length + step;
        }

        // Trace the position backwards
        while (step > 0) {

            long previousLength = (length - step) / 2;

            if (p <= previousLength) {
                // Position belongs to the original part
                length = previousLength;
            }
            else if (p <= previousLength + step) {
                // Position belongs to the '$' section
                return '$';
            }
            else {
                // Position belongs to the reversed part
                p = length - p + 1;
                length = previousLength;
            }

            step--;
        }

        return s.charAt((int) p - 1);
    }
}
