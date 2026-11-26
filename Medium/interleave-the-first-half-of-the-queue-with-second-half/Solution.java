import java.util.*;

class Solution {

    public void rearrangeQueue(Queue<Integer> q) {

        int half = q.size() / 2;

        Queue<Integer> firstHalf = new LinkedList<>();

        // Step 1: Store the first half in another queue
        for (int i = 0; i < half; i++) {
            firstHalf.add(q.poll());
        }

        // Step 2: Interleave both halves
        while (!firstHalf.isEmpty()) {

            // Take one element from the first half
            q.add(firstHalf.poll());

            // Take one element from the second half
            q.add(q.poll());
        }
    }
}