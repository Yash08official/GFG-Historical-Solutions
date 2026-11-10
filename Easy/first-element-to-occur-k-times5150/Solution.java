import java.util.*;

class Solution {

    public int firstElementKTime(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int freq = map.getOrDefault(arr[i], 0) + 1;

            map.put(arr[i], freq);

            // Check if k-th occurrence is reached
            if (freq == k) {
                return arr[i];
            }
        }

        return -1;
    }
}
