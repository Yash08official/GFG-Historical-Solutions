import java.util.*;

class Solution {

    long[] tree;
    int n;

    // Calculate GCD using Euclid's algorithm
    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // Calculate LCM
    private long lcm(long a, long b) {

        if (a == 0 || b == 0) {
            return 0;
        }

        return (a / gcd(a, b)) * b;
    }

    // Build segment tree
    private void build(int[] arr, int node, int start, int end) {

        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, 2 * node, start, mid);

        build(arr, 2 * node + 1, mid + 1, end);

        tree[node] = lcm(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Update array element
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

        // Recalculate parent LCM
        tree[node] = lcm(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Calculate LCM in a given range
    private long query(int node, int start, int end,
                       int l, int r) {

        // No overlap
        if (end < l || start > r) {
            return 1;
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;

        long left = query(
            2 * node, start, mid, l, r
        );

        long right = query(
            2 * node + 1, mid + 1, end, l, r
        );

        return lcm(left, right);
    }

    public ArrayList<Long> rangeLCMQuery(int[] arr, int[][] queries) {

        ArrayList<Long> result = new ArrayList<>();

        n = arr.length;

        tree = new long[4 * n];

        // Build initial segment tree
        build(arr, 1, 0, n - 1);

        // Process queries sequentially
        for (int[] q : queries) {

            int type = q[0];

            if (type == 1) {

                int index = q[1];
                int value = q[2];

                // Update original array
                arr[index] = value;

                // Update segment tree
                update(1, 0, n - 1, index, value);

            } else {

                int l = q[1];
                int r = q[2];

                long answer = query(1, 0, n - 1, l, r);

                result.add(answer);
            }
        }

        return result;
    }
}