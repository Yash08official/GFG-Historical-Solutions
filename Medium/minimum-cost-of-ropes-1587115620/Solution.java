import java.util.*;

class Solution {
    public int minCost(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all rope lengths into Min Heap
        for (int rope : arr) {
            pq.add(rope);
        }

        int totalCost = 0;

        // Connect ropes until only one remains
        while (pq.size() > 1) {

            int first = pq.poll();
            int second = pq.poll();

            int cost = first + second;

            totalCost += cost;

            // Add the newly connected rope
            pq.add(cost);
        }

        return totalCost;
    }
}
