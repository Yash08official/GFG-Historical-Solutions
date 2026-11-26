import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> findIntersection(int[][] a, int[][] b) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {

            // Find the overlapping range
            int start = Math.max(a[i][0], b[j][0]);
            int end = Math.min(a[i][1], b[j][1]);

            // Check if an intersection exists
            if (start <= end) {

                ArrayList<Integer> intersection = new ArrayList<>();

                intersection.add(start);
                intersection.add(end);

                result.add(intersection);
            }

            // Move the interval that ends earlier
            if (a[i][1] < b[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}