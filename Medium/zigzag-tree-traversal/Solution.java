import java.util.*;

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node current = queue.poll();

                if (leftToRight) {
                    level.add(current.data);
                } 
                else {
                    level.add(0, current.data);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            result.addAll(level);

            // Change direction
            leftToRight = !leftToRight;
        }

        return result;
    }
}
