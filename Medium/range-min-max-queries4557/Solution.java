import java.util.*;

class Solution {

    int[] minTree;
    int[] maxTree;

    // Build the segment tree
    private void build(int[] arr, int node, int start, int end) {

        if (start == end) {
            minTree[node] = arr[start];
            maxTree[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);

        minTree[node] = Math.min(
            minTree[2 * node],
            minTree[2 * node + 1]
        );

        maxTree[node] = Math.max(
            maxTree[2 * node],
            maxTree[2 * node + 1]
        );
    }

    // Update one array index
    private void update(int node, int start, int end,
                        int index, int value) {

        if (start == end) {
            minTree[node] = value;
            maxTree[node] = value;
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(2 * node, start, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, end, index, value);
        }

        // Recalculate the current node
        minTree[node] = Math.min(
            minTree[2 * node],
            minTree[2 * node + 1]
        );

        maxTree[node] = Math.max(
            maxTree[2 * node],
            maxTree[2 * node + 1]
        );
    }

    // Return minimum and maximum in range [l, r]
    private int[] query(int node, int start, int end,
                        int l, int r) {

        // No overlap
        if (end < l || start > r) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return new int[]{minTree[node], maxTree[node]};
        }

        // Partial overlap
        int mid = start + (end - start) / 2;

        int[] left = query(2 * node, start, mid, l, r);
        int[] right = query(2 * node + 1, mid + 1, end, l, r);

        return new int[]{
            Math.min(left[0], right[0]),
            Math.max(left[1], right[1])
        };
    }

    public ArrayList<ArrayList<Integer>> rangeMinMaxQueries(
            int[] arr, int[][] queries) {

        int n = arr.length;

        minTree = new int[4 * n];
        maxTree = new int[4 * n];

        build(arr, 1, 0, n - 1);

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                // Type 1: Range minimum and maximum
                int l = q[1];
                int r = q[2];

                int[] result = query(1, 0, n - 1, l, r);

                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(result[0]);
                pair.add(result[1]);

                answer.add(pair);

            } else {

                // Type 2: Point update
                int index = q[1];
                int value = q[2];

                arr[index] = value;

                update(1, 0, n - 1, index, value);
            }
        }

        return answer;
    }
}