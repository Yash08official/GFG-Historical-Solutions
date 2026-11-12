class Solution {

    public int lengthOfLoop(Node head) {

        Node slow = head;
        Node fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {

                // Step 2: Count cycle length
                int count = 1;

                Node temp = slow.next;

                while (temp != slow) {

                    count++;

                    temp = temp.next;
                }

                return count;
            }
        }

        // No cycle found
        return 0;
    }
}
