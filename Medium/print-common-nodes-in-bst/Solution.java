import java.util.*;

class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {

        ArrayList<Integer> result = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        Node curr1 = r1;
        Node curr2 = r2;

        while ((curr1 != null || !s1.isEmpty()) &&
               (curr2 != null || !s2.isEmpty())) {

            // Push left nodes of first BST
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }

            // Push left nodes of second BST
            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.left;
            }

            Node n1 = s1.peek();
            Node n2 = s2.peek();

            if (n1.data == n2.data) {

                result.add(n1.data);

                s1.pop();
                s2.pop();

                curr1 = n1.right;
                curr2 = n2.right;

            } else if (n1.data < n2.data) {

                s1.pop();
                curr1 = n1.right;

            } else {

                s2.pop();
                curr2 = n2.right;
            }
        }

        return result;
    }
}
