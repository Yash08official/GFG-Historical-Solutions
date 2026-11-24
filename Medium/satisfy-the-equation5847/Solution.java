import java.util.*;

class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;

        HashMap<Long, ArrayList<int[]>> map = new HashMap<>();

        // Store every pair grouped by its sum.
        // Pairs are inserted in lexicographical order.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = (long) arr[i] + arr[j];

                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new int[]{i, j});
            }
        }

        // Try first pairs in lexicographical order.
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {

                long sum = (long) arr[a] + arr[b];

                ArrayList<int[]> pairs = map.get(sum);

                // Find the earliest later pair with the same sum.
                for (int[] pair : pairs) {
                    int c = pair[0];
                    int d = pair[1];

                    // Ensure (a,b) comes before (c,d).
                    if (c < a || (c == a && d <= b)) {
                        continue;
                    }

                    // All four indices must be distinct.
                    if (a != c && a != d &&
                        b != c && b != d) {

                        ArrayList<Integer> result = new ArrayList<>();

                        result.add(a);
                        result.add(b);
                        result.add(c);
                        result.add(d);

                        return result;
                    }
                }
            }
        }

        return new ArrayList<>(
            Arrays.asList(-1, -1, -1, -1)
        );
    }
}
