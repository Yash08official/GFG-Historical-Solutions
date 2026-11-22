class Solution {
    public boolean isSumProperty(Node root) {

        // Empty tree or leaf node is valid
        if (root == null ||
            (root.left == null && root.right == null)) {
            return true;
        }

        int leftValue = (root.left != null) ? root.left.data : 0;
        int rightValue = (root.right != null) ? root.right.data : 0;

        // Check current node
        if (root.data != leftValue + rightValue) {
            return false;
        }

        // Check left and right subtrees
        return isSumProperty(root.left) &&
               isSumProperty(root.right);
    }
}
