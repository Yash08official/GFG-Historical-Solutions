import java.util.*;

class Solution {
    public ArrayList<Integer> commonSlot(int[][] slots1, int[][] slots2, int d) {

        ArrayList<Integer> result = new ArrayList<>();

        // Sort both arrays by starting time
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int j = 0;

        while (i < slots1.length && j < slots2.length) {

            // Find overlapping interval
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);

            // Check whether overlap is sufficient
            if ((long) end - start >= d) {
                result.add(start);
                result.add(start + d);
                return result;
            }

            // Move the interval that ends earlier
            if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}