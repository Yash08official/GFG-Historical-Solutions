class Solution {

    // Reverse the linked list
    Node reverse(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node nextNode = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public Node addOne(Node head) {

        // Step 1: Reverse the linked list
        head = reverse(head);

        Node curr = head;
        Node prev = null;

        int carry = 1;

        // Step 2: Add 1 and handle carry
        while (curr != null && carry > 0) {

            int sum = curr.data + carry;

            curr.data = sum % 10;

            carry = sum / 10;

            prev = curr;
            curr = curr.next;
        }

        // Step 3: If carry remains, add new node
        if (carry > 0) {

            prev.next = new Node(carry);
        }

        // Step 4: Reverse again
        head = reverse(head);

        return head;
    }
}
