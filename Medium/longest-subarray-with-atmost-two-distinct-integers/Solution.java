import java.util.*;

class Solution {

    public int totalElements(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < arr.length; right++) {

            // Add current element to the window
            map.put(arr[right],
                map.getOrDefault(arr[right], 0) + 1);

            // Shrink window if distinct elements exceed 2
            while (map.size() > 2) {

                int leftElement = arr[left];

                map.put(leftElement, map.get(leftElement) - 1);

                // Remove element if its frequency becomes zero
                if (map.get(leftElement) == 0) {
                    map.remove(leftElement);
                }

                left++;
            }

            // Update maximum valid window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
