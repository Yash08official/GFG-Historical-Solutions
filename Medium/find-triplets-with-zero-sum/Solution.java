import java.util.*;

class Solution {

    public boolean findTriplets(int[] arr) {

        int n = arr.length;

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Fix the first element
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            // Step 3: Two pointer approach
            while (left < right) {

                long sum = (long) arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    return true;
                }

                else if (sum < 0) {
                    left++;
                }

                else {
                    right--;
                }
            }
        }

        return false;
    }
}
