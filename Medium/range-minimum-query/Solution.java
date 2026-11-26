import java.util.*;

class Solution {

    int[] tree;

    // Build the segment tree
    private void build(int[] arr, int node, int start, int end) {

        if (start == end) {

            tree[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, 2 * node, start, mid);

        build(arr, 2 * node + 1, mid + 1, end);

        tree[node] = Math.min(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Find minimum in a given range
    private int query(int node, int start, int end,
                      int l, int r) {

        // Case 1: No overlap
        if (end < l || start > r) {
            return Integer.MAX_VALUE;
        }

        // Case 2: Complete overlap
        if (start >= l && end <= r) {
            return tree[node];
        }

        // Case 3: Partial overlap
        int mid = start + (end - start) / 2;

        int leftMin = query(
            2 * node, start, mid, l, r
        );

        int rightMin = query(
            2 * node + 1, mid + 1, end, l, r
        );

        return Math.min(leftMin, rightMin);
    }

    public ArrayList<Integer> rangeMinQuery(int[] arr, int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = arr.length;

        tree = new int[4 * n];

        // Build segment tree
        build(arr, 1, 0, n - 1);

        // Process all queries
        for (int[] q : queries) {

            int l = q[0];
            int r = q[1];

            int minimum = query(1, 0, n - 1, l, r);

            result.add(minimum);
        }

        return result;
    }
}