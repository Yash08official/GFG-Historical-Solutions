import java.util.Arrays;

class Solution {

    public int findKthSmall(int[] arr, int k) {

        int n = arr.length;

        // Sort the array
        Arrays.sort(arr);

        // Binary Search
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Calculate kth missing number
        return low + k;
    }
}
