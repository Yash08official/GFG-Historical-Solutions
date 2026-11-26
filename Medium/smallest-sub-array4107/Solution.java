import java.util.*;

class Solution {

    // Calculate GCD using Euclid's algorithm
    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // Add a GCD and its subarray length.
    // Merge consecutive entries having the same GCD.
    private void add(ArrayList<int[]> list, int g, int len) {

        int size = list.size();

        if (size > 0 && list.get(size - 1)[0] == g) {

            list.get(size - 1)[1] =
                Math.min(list.get(size - 1)[1], len);

        } else {

            list.add(new int[]{g, len});
        }
    }

    int findSmallestSubArr(int[] arr, int k) {

        int n = arr.length;

        int answer = Integer.MAX_VALUE;

        // GCD and minimum length of subarrays
        // ending at the previous index
        ArrayList<int[]> prev = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            ArrayList<int[]> curr = new ArrayList<>();

            // Subarray containing only arr[i]
            add(curr, arr[i], 1);

            // Extend all subarrays ending at i-1
            for (int[] pair : prev) {

                int newGcd = gcd(pair[0], arr[i]);

                int newLength = pair[1] + 1;

                add(curr, newGcd, newLength);
            }

            // Check whether any subarray has GCD = k
            for (int[] pair : curr) {

                if (pair[0] == k) {

                    answer = Math.min(answer, pair[1]);
                }
            }

            prev = curr;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}