import java.util.*;

class SpecialQueue {

    Queue<Integer> queue;
    Deque<Integer> minDeque;
    Deque<Integer> maxDeque;

    public SpecialQueue() {
        queue = new LinkedList<>();
        minDeque = new ArrayDeque<>();
        maxDeque = new ArrayDeque<>();
    }

    public void enqueue(int x) {

        queue.offer(x);

        // Maintain increasing order in minDeque
        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.pollLast();
        }
        minDeque.offerLast(x);

        // Maintain decreasing order in maxDeque
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(x);
    }

    public void dequeue() {

        int removed = queue.poll();

        if (removed == minDeque.peekFirst()) {
            minDeque.pollFirst();
        }

        if (removed == maxDeque.peekFirst()) {
            maxDeque.pollFirst();
        }
    }

    public int getFront() {
        return queue.peek();
    }

    public int getMin() {
        return minDeque.peekFirst();
    }

    public int getMax() {
        return maxDeque.peekFirst();
    }
}
