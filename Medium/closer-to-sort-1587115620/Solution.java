class Solution {

    int closer(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Check middle element
            if (arr[mid] == x) {
                return mid;
            }

            // Check left adjacent element
            if (mid - 1 >= low && arr[mid - 1] == x) {
                return mid - 1;
            }

            // Check right adjacent element
            if (mid + 1 <= high && arr[mid + 1] == x) {
                return mid + 1;
            }

            // Search left half
            if (x < arr[mid]) {
                high = mid - 2;
            }

            // Search right half
            else {
                low = mid + 2;
            }
        }

        return -1;
    }
}