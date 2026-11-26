class Solution {
    static boolean pairInSortedRotated(int arr[], int target) {

        int n = arr.length;
        int pivot = -1;

        // Find the pivot
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no pivot exists, array is not rotated
        if (pivot == -1) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            return false;
        }

        // Smallest and largest elements
        int left = (pivot + 1) % n;
        int right = pivot;

        while (left != right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left = (left + 1) % n;
            } else {
                right = (right - 1 + n) % n;
            }
        }

        return false;
    }
}