class Solution {

    public int findMissing(int[] arr) {

        int n = arr.length;

        // Find the common difference
        int d = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            d = Math.min(d, Math.abs(arr[i] - arr[i - 1]));
        }

        // Preserve ascending or descending direction
        if (arr[n - 1] < arr[0]) {
            d = -d;
        }

        // Binary search for the first incorrect position
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int expected = arr[0] + mid * d;

            if (arr[mid] == expected) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Missing element, or next element if AP is complete
        return arr[0] + low * d;
    }
}