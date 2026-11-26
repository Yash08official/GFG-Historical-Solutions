import java.util.*;

class Solution {

    public ArrayList<Integer> findRepeating(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = arr.length;

        // Step 1: Find the first index where
        // arr[i] != arr[0] + i

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long expected = (long) arr[0] + mid;

            if (arr[mid] == expected) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // No repeated element
        if (low == n) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        // Step 2: Find the repeated element
        int repeated = arr[low - 1];

        // Step 3: Find the first index
        // where element is greater than repeated
        int left = low;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= repeated) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Frequency of repeated element
        int frequency = left - (low - 1);

        result.add(repeated);
        result.add(frequency);

        return result;
    }
}