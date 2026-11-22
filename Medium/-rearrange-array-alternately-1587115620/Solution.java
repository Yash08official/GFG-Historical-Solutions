import java.util.*;

class Solution {
    public void rearrange(int arr[]) {

        Arrays.sort(arr);

        int n = arr.length;

        int left = 0;
        int right = n - 1;

        int[] temp = new int[n];

        int index = 0;

        while (left <= right) {

            // First take maximum
            temp[index++] = arr[right--];

            // Then take minimum
            if (left <= right) {
                temp[index++] = arr[left++];
            }
        }

        // Copy rearranged elements into original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}
