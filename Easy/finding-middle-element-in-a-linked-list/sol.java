class Solution {
    /* Should return data of middle node. If linked list is empty, then  -1*/
    int getMiddle(Node node) {
        Node slow = node;
        Node fast = node;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return  slow.data;
    }
}