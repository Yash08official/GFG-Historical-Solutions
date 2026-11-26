import java.util.*;

class Solution {

    int[][] tree;
    int n;

    // Build the segment tree
    private void build(String s, int node, int start, int end) {

        if (start == end) {

            tree[node][s.charAt(start) - 'a'] = 1;

            return;
        }

        int mid = start + (end - start) / 2;

        build(s, 2 * node, start, mid);
        build(s, 2 * node + 1, mid + 1, end);

        // Merge character frequencies
        for (int i = 0; i < 26; i++) {

            tree[node][i] =
                tree[2 * node][i] +
                tree[2 * node + 1][i];
        }
    }

    // Update one character
    private void update(int node, int start, int end,
                        int index, char oldChar, char newChar) {

        if (start == end) {

            tree[node][oldChar - 'a'] = 0;
            tree[node][newChar - 'a'] = 1;

            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {

            update(2 * node, start, mid,
                   index, oldChar, newChar);

        } else {

            update(2 * node + 1, mid + 1, end,
                   index, oldChar, newChar);
        }

        // Recalculate parent frequencies
        for (int i = 0; i < 26; i++) {

            tree[node][i] =
                tree[2 * node][i] +
                tree[2 * node + 1][i];
        }
    }

    // Get character frequencies in a range
    private int[] query(int node, int start, int end,
                        int l, int r) {

        int[] result = new int[26];

        // No overlap
        if (end < l || start > r) {
            return result;
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return tree[node].clone();
        }

        int mid = start + (end - start) / 2;

        int[] left = query(
            2 * node, start, mid, l, r
        );

        int[] right = query(
            2 * node + 1, mid + 1, end, l, r
        );

        // Merge frequencies
        for (int i = 0; i < 26; i++) {
            result[i] = left[i] + right[i];
        }

        return result;
    }

    public ArrayList<String> processQueries(String s, String[][] queries) {

        ArrayList<String> answer = new ArrayList<>();

        n = s.length();

        tree = new int[4 * n][26];

        // Build initial segment tree
        build(s, 1, 0, n - 1);

        // StringBuilder allows efficient character updates
        StringBuilder str = new StringBuilder(s);

        for (String[] q : queries) {

            int type = Integer.parseInt(q[0]);

            if (type == 1) {

                int index = Integer.parseInt(q[1]);

                char newChar = q[2].charAt(0);

                char oldChar = str.charAt(index);

                // No work needed if character is unchanged
                if (oldChar != newChar) {

                    update(1, 0, n - 1,
                           index, oldChar, newChar);

                    str.setCharAt(index, newChar);
                }

            } else {

                int l = Integer.parseInt(q[1]);
                int r = Integer.parseInt(q[2]);
                int k = Integer.parseInt(q[3]);

                // Get frequencies for the requested substring
                int[] freq = query(1, 0, n - 1, l, r);

                // Find kth largest character
                for (int i = 25; i >= 0; i--) {

                    if (k > freq[i]) {

                        k -= freq[i];

                    } else {

                        answer.add(
                            String.valueOf((char)('a' + i))
                        );

                        break;
                    }
                }
            }
        }

        return answer;
    }
}