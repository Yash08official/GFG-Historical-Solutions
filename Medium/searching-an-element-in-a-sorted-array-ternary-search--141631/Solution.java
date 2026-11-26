class Solution {
    public boolean ternarySearch(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            // Check both middle elements
            if (arr[mid1] == x || arr[mid2] == x) {
                return true;
            }

            // Search left part
            if (x < arr[mid1]) {
                high = mid1 - 1;
            }

            // Search right part
            else if (x > arr[mid2]) {
                low = mid2 + 1;
            }

            // Search middle part
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }

        return false;
    }
}