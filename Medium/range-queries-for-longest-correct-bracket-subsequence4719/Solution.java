import java.util.*;

class Solution {

    static class Node {
        int open;
        int close;

        Node(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    Node[] tree;

    // Merge two segment tree nodes
    private Node merge(Node left, Node right) {

        int matched = Math.min(left.open, right.close);

        int open = left.open + right.open - matched;

        int close = left.close + right.close - matched;

        return new Node(open, close);
    }

    // Build segment tree
    private void build(String str, int node, int start, int end) {

        if (start == end) {

            if (str.charAt(start) == '(') {
                tree[node] = new Node(1, 0);
            } else {
                tree[node] = new Node(0, 1);
            }

            return;
        }

        int mid = start + (end - start) / 2;

        build(str, 2 * node, start, mid);

        build(str, 2 * node + 1, mid + 1, end);

        tree[node] = merge(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Range query
    private Node query(int node, int start, int end,
                       int l, int r) {

        // No overlap
        if (end < l || start > r) {
            return new Node(0, 0);
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;

        Node left = query(
            2 * node, start, mid, l, r
        );

        Node right = query(
            2 * node + 1, mid + 1, end, l, r
        );

        return merge(left, right);
    }

    ArrayList<Integer> longestSeq(String str, int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = str.length();

        tree = new Node[4 * n];

        // Build the segment tree
        build(str, 1, 0, n - 1);

        // Process each query
        for (int[] q : queries) {

            int l = q[0];
            int r = q[1];

            Node ans = query(1, 0, n - 1, l, r);

            int length = (r - l + 1) - ans.open - ans.close;

            result.add(length);
        }

        return result;
    }
}