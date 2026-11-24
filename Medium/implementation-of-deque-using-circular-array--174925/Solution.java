class myDeque {

    int[] arr;
    int front;
    int size;
    int capacity;

    public myDeque(int n) {
        arr = new int[n];
        capacity = n;
        front = 0;
        size = 0;
    }

    public void insertFront(int x) {

        if (size == capacity) {
            return;
        }

        front = (front - 1 + capacity) % capacity;
        arr[front] = x;
        size++;
    }

    public void insertRear(int x) {

        if (size == capacity) {
            return;
        }

        int rear = (front + size) % capacity;

        arr[rear] = x;
        size++;
    }

    public void deleteFront() {

        if (size == 0) {
            return;
        }

        front = (front + 1) % capacity;
        size--;

        if (size == 0) {
            front = 0;
        }
    }

    public void deleteRear() {

        if (size == 0) {
            return;
        }

        size--;

        if (size == 0) {
            front = 0;
        }
    }

    public int frontEle() {

        if (size == 0) {
            return -1;
        }

        return arr[front];
    }

    public int rearEle() {

        if (size == 0) {
            return -1;
        }

        int rear = (front + size - 1) % capacity;

        return arr[rear];
    }
}
