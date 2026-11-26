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

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // Update an element at a given index
    private void update(int node, int start, int end,
                        int index, int value) {

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(2 * node, start, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, end, index, value);
        }

        // Recalculate the parent sum
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // Find sum in range [l, r]
    private int query(int node, int start, int end,
                      int l, int r) {

        // No overlap
        if (end < l || start > r) {
            return 0;
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return tree[node];
        }

        // Partial overlap
        int mid = start + (end - start) / 2;

        int leftSum = query(2 * node, start, mid, l, r);
        int rightSum = query(2 * node + 1, mid + 1, end, l, r);

        return leftSum + rightSum;
    }

    public ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {

        int n = arr.length;

        tree = new int[4 * n];

        build(arr, 1, 0, n - 1);

        ArrayList<Integer> answer = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                // Type 1: Range sum query
                int l = q[1];
                int r = q[2];

                int sum = query(1, 0, n - 1, l, r);

                answer.add(sum);

            } else {

                // Type 2: Update array element
                int index = q[1];
                int value = q[2];

                arr[index] = value;

                update(1, 0, n - 1, index, value);
            }
        }

        return answer;
    }
}