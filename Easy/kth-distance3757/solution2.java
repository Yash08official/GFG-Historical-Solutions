import java.util.*;

class Solution {

    public boolean checkWithinK(int[] arr, int k) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            // Check whether duplicate exists
            if (set.contains(arr[i])) {
                return true;
            }

            // Add current element
            set.add(arr[i]);

            // Maintain window of size k
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }

        return false;
    }
}
