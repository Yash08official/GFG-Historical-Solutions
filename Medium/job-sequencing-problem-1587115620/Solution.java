import java.util.*;

class Solution {

    // Find the latest available slot
    int find(int[] parent, int x) {

        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;

        // Store jobs: [profit, deadline]
        int[][] jobs = new int[n][2];

        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {

            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];

            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        // No more than n jobs can be scheduled
        maxDeadline = Math.min(maxDeadline, n);

        // Sort jobs by descending profit
        Arrays.sort(jobs, (a, b) ->
            Integer.compare(b[0], a[0])
        );

        // Initialize DSU
        int[] parent = new int[maxDeadline + 1];

        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int count = 0;
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {

            int jobProfit = jobs[i][0];
            int jobDeadline = Math.min(jobs[i][1], maxDeadline);

            // Find latest available slot
            int availableSlot = find(parent, jobDeadline);

            if (availableSlot > 0) {

                count++;
                totalProfit += jobProfit;

                // Mark this slot as occupied
                parent[availableSlot] =
                    find(parent, availableSlot - 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        result.add(count);
        result.add(totalProfit);

        return result;
    }
}
