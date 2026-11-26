import java.util.*;

class Solution {

    ArrayList<Integer> smallestDiff(int a[], int b[], int c[]) {

        int n = a.length;

        // Sort all three arrays
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;

        int bestDiff = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;

        int bestMax = 0;
        int bestMid = 0;
        int bestMin = 0;

        while (i < n && j < n && k < n) {

            int x = a[i];
            int y = b[j];
            int z = c[k];

            int min = Math.min(x, Math.min(y, z));
            int max = Math.max(x, Math.max(y, z));

            int diff = max - min;
            int sum = x + y + z;

            // Check whether this triplet is better
            if (diff < bestDiff ||
                (diff == bestDiff && sum < bestSum)) {

                bestDiff = diff;
                bestSum = sum;

                bestMax = max;
                bestMin = min;
                bestMid = sum - max - min;
            }

            // Move the pointer having the minimum value
            if (x == min) {
                i++;
            } else if (y == min) {
                j++;
            } else {
                k++;
            }
        }

        // Return in descending order
        ArrayList<Integer> result = new ArrayList<>();

        result.add(bestMax);
        result.add(bestMid);
        result.add(bestMin);

        return result;
    }
}