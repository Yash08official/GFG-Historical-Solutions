import java.util.*;

class Solution {

    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {

        int n = l.length;

        // Store cumulative number of valid marks
        long[] prefix = new long[n];

        for (int i = 0; i < n; i++) {

            long count = (long) r[i] - l[i] + 1;

            prefix[i] = count;

            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        // Process each requested rank
        for (int k : rank) {

            int low = 0;
            int high = n - 1;

            // Find the first interval whose prefix count >= k
            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Invalid rank
            if (low == n) {
                answer.add(-1);
                continue;
            }

            // Marks counted before this interval
            long previousCount = (low == 0) ? 0 : prefix[low - 1];

            // Position inside the selected interval
            long offset = k - previousCount - 1;

            int mark = (int) (l[low] + offset);

            answer.add(mark);
        }

        return answer;
    }
}