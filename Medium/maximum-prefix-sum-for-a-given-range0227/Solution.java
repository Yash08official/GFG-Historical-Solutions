import java.util.*;

class Solution {

    static class Node {
        int sum;
        int maxPrefix;

        Node(int sum, int maxPrefix) {
            this.sum = sum;
            this.maxPrefix = maxPrefix;
        }
    }

    Node[] tree;

    // Merge two child nodes
    private Node merge(Node left, Node right) {

        int totalSum = left.sum + right.sum;

        int maxPrefix = Math.max(
            left.maxPrefix,
            left.sum + right.maxPrefix
        );

        return new Node(totalSum, maxPrefix);
    }

    // Build segment tree
    private void build(int[] arr, int node, int start, int end) {

        if (start == end) {
            tree[node] = new Node(arr[start], arr[start]);
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);

        tree[node] = merge(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Query maximum prefix sum in [l, r]
    private Node query(int node, int start, int end,
                       int l, int r) {

        // No overlap
        if (end < l || start > r) {
            return null;
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return tree[node];
        }

        // Partial overlap
        int mid = start + (end - start) / 2;

        Node left = query(2 * node, start, mid, l, r);

        Node right = query(2 * node + 1, mid + 1, end, l, r);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return merge(left, right);
    }

    public ArrayList<Integer> maxPrefixSumQueries(
            int[] arr, int[][] queries) {

        int n = arr.length;

        tree = new Node[4 * n];

        build(arr, 1, 0, n - 1);

        ArrayList<Integer> answer = new ArrayList<>();

        for (int[] q : queries) {

            int left = q[0];
            int right = q[1];

            Node result = query(1, 0, n - 1, left, right);

            answer.add(result.maxPrefix);
        }

        return answer;
    }
}