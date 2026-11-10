import java.util.*;

class Solution {

    public ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            Node node = current.node;
            int hd = current.hd;

            // Store only the first node at each HD
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            // Left child
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // Right child
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // TreeMap automatically sorts horizontal distances
        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }

    class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
