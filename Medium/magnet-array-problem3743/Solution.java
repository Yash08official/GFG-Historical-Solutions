import java.util.*;

class Solution {

    List<Double> nullPoints(List<Integer> arr) {

        List<Double> result = new ArrayList<>();

        int n = arr.size();

        // Find one equilibrium point between
        // every pair of consecutive magnets
        for (int i = 0; i < n - 1; i++) {

            double low = arr.get(i);
            double high = arr.get(i + 1);

            // Binary search for accurate precision
            for (int iteration = 0; iteration < 100; iteration++) {

                double mid = low + (high - low) / 2.0;

                double force = 0.0;

                // Calculate net force at mid
                for (int j = 0; j < n; j++) {

                    force += 1.0 / (mid - arr.get(j));
                }

                // Positive force means equilibrium
                // point lies towards the right
                if (force > 0) {

                    low = mid;

                } else {

                    high = mid;
                }
            }

            // Store the equilibrium point
            result.add(low + (high - low) / 2.0);
        }

        return result;
    }
}