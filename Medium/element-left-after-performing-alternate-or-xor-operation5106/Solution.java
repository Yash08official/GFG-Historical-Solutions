import java.util.*;

class Solution {

    int[] tree;

    // Calculate ceil(log2(length))
    private int ceilLog2(int length) {

        if (length <= 1) {
            return 0;
        }

        return 32 - Integer.numberOfLeadingZeros(length - 1);
    }

    // Combine two child values
    private int combine(int left, int right, int length) {

        int k = ceilLog2(length);

        if (k % 2 == 1) {
            return left | right;
        } else {
            return left ^ right;
        }
    }

    // Build segment tree
    private void build(int[] arr, int node, int l, int r) {

        if (l == r) {
            tree[node] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;

        build(arr, 2 * node, l, mid);
        build(arr, 2 * node + 1, mid + 1, r);

        tree[node] = combine(
            tree[2 * node],
            tree[2 * node + 1],
            r - l + 1
        );
    }

    // Update one array element
    private void update(int node, int l, int r,
                        int index, int value) {

        if (l == r) {
            tree[node] = value;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {

            update(2 * node, l, mid, index, value);

        } else {

            update(2 * node + 1, mid + 1, r, index, value);
        }

        // Recalculate the current node
        tree[node] = combine(
            tree[2 * node],
            tree[2 * node + 1],
            r - l + 1
        );
    }

    public ArrayList<Integer> left(int[] arr, int[][] query) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = arr.length;

        tree = new int[4 * n];

        // Build the initial segment tree
        build(arr, 1, 0, n - 1);

        // Process queries in order
        for (int[] q : query) {

            int index = q[0];
            int value = q[1];

            // Invalid index: do not update
            if (index >= n) {
                result.add(-1);
                continue;
            }

            // Update the original array
            arr[index] = value;

            // Update segment tree
            update(1, 0, n - 1, index, value);

            // Root stores the complete array's value
            result.add(tree[1]);
        }

        return result;
    }
}