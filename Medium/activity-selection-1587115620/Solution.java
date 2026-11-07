import java.util.*;

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;

        int[][] activities = new int[n][2];

        // Store start and finish times
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }

        // Sort according to finish time
        Arrays.sort(activities, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int count = 1;
        int lastFinish = activities[0][1];

        // Select non-overlapping activities
        for (int i = 1; i < n; i++) {

            if (activities[i][0] > lastFinish) {
                count++;
                lastFinish = activities[i][1];
            }
        }

        return count;
    }
}
