class Solution {

    public boolean isSumTree(Node node) {
        return checkSumTree(node).isSumTree;
    }

    static class Result {
        boolean isSumTree;
        int sum;

        Result(boolean isSumTree, int sum) {
            this.isSumTree = isSumTree;
            this.sum = sum;
        }
    }

    private Result checkSumTree(Node node) {

        // Empty tree
        if (node == null) {
            return new Result(true, 0);
        }

        // Leaf node
        if (node.left == null && node.right == null) {
            return new Result(true, node.data);
        }

        Result left = checkSumTree(node.left);
        Result right = checkSumTree(node.right);

        // Check whether both subtrees are Sum Trees
        boolean valid = left.isSumTree &&
                        right.isSumTree &&
                        node.data == left.sum + right.sum;

        // Return current subtree's total sum
        int totalSum = node.data + left.sum + right.sum;

        return new Result(valid, totalSum);
    }
}
