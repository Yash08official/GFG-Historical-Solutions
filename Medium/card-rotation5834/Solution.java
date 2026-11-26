import java.util.*;

class Solution {

    public ArrayList<Integer> rotation(int n) {

        ArrayList<Integer> result = new ArrayList<>(
            Collections.nCopies(n, 0)
        );

        Queue<Integer> q = new LinkedList<>();

        // Store all available positions
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        for (int k = 1; k <= n; k++) {

            // Move first k positions to the back
            for (int j = 0; j < k; j++) {
                q.add(q.poll());
            }

            // Place card k at the next position
            int position = q.poll();
            result.set(position, k);
        }

        return result;
    }
}