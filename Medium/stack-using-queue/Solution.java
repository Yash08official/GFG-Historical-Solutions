import java.util.*;

class myStack {

    Queue<Integer> q = new LinkedList<>();

    // Inserts an element at the top
    void push(int x) {

        q.add(x);

        int size = q.size();

        // Move previous elements behind the new element
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
    }

    // Removes the top element
    void pop() {

        if (!q.isEmpty()) {
            q.poll();
        }
    }

    // Returns the top element
    int top() {

        if (q.isEmpty()) {
            return -1;
        }

        return q.peek();
    }

    // Returns the current stack size
    int size() {

        return q.size();
    }
}