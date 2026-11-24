class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

class myDeque {

    Node head;
    Node tail;

    myDeque() {
        head = null;
        tail = null;
    }

    void insertFront(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void insertRear(int data) {

        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void deleteFront() {

        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    void deleteRear() {

        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    int getFront() {

        if (head == null) {
            return -1;
        }

        return head.data;
    }

    int getRear() {

        if (tail == null) {
            return -1;
        }

        return tail.data;
    }
}
