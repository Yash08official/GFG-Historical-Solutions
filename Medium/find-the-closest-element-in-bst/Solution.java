class Solution {

    public int minDiff(Node root, int k) {

        int minDiff = Integer.MAX_VALUE;

        Node curr = root;

        while (curr != null) {

            // Calculate absolute difference
            int diff = Math.abs(curr.data - k);

            // Update minimum difference
            minDiff = Math.min(minDiff, diff);

            // Exact match found
            if (diff == 0) {
                return 0;
            }

            // Move according to BST property
            if (k < curr.data) {

                curr = curr.left;

            } else {

                curr = curr.right;
            }
        }

        return minDiff;
    }
}
