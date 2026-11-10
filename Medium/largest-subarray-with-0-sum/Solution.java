import java.util.*;

class Solution {
    int maxLength(int arr[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // Subarray from index 0 has sum 0
            if (sum == 0) {
                maxLength = i + 1;
            }

            // Prefix sum already exists
            if (map.containsKey(sum)) {

                int length = i - map.get(sum);

                maxLength = Math.max(maxLength, length);
            }
            else {
                // Store only the first occurrence
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
