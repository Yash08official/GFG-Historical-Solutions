import java.util.*;

class Solution {

    static List<Integer> firstNegInt(int arr[], int k) {

        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            // Step 1: Store index if current element is negative
            if (arr[i] < 0) {
                dq.addLast(i);
            }

            // Step 2: Remove negative elements outside the window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // Step 3: Process window once its size becomes k
            if (i >= k - 1) {

                if (dq.isEmpty()) {
                    result.add(0);
                } else {
                    result.add(arr[dq.peekFirst()]);
                }
            }
        }

        return result;
    }
}