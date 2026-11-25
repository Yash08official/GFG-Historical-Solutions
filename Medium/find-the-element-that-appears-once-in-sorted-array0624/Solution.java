class Solution {

    int single(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Make mid even so we can check its pair
            if (mid % 2 == 1) {
                mid--;
            }

            // Pair is correct: single element is on the right
            if (arr[mid] == arr[mid + 1]) {

                left = mid + 2;

            } else {

                // Pair is broken: single element is here or on the left
                right = mid;
            }
        }

        return arr[left];
    }
}
