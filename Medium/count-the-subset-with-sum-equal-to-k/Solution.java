import java.util.*;

class Solution {

    HashMap<Long, Integer> map = new HashMap<>();

    // Generate subset sums of the right half
    void generateRight(int[] arr, int index, int end, long sum) {

        if (index == end) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }

        // Include current element
        generateRight(arr, index + 1, end, sum + arr[index]);

        // Exclude current element
        generateRight(arr, index + 1, end, sum);
    }

    // Generate subset sums of the left half and find matches
    long generateLeft(int[] arr, int index, int end,
                      long sum, long k) {

        if (index == end) {
            return map.getOrDefault(k - sum, 0);
        }

        // Include current element
        long include = generateLeft(
            arr, index + 1, end, sum + arr[index], k
        );

        // Exclude current element
        long exclude = generateLeft(
            arr, index + 1, end, sum, k
        );

        return include + exclude;
    }

    public int countSubset(int[] arr, int k) {

        map.clear();

        int n = arr.length;
        int mid = n / 2;

        // Generate all subset sums of right half
        generateRight(arr, mid, n, 0);

        // Find matching subset sums from left half
        long answer = generateLeft(arr, 0, mid, 0, k);

        return (int) answer;
    }
}
