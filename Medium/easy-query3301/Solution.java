import java.util.*;

class Solution {

    int[] leftChild;
    int[] rightChild;
    int[] treeCount;

    int nodeCount;

    // Create a new version after inserting value
    int update(int previous, int start, int end, int value) {

        int current = ++nodeCount;

        // Copy information from previous version
        leftChild[current] = leftChild[previous];
        rightChild[current] = rightChild[previous];

        treeCount[current] = treeCount[previous] + 1;

        if (start == end) {
            return current;
        }

        int mid = start + (end - start) / 2;

        if (value <= mid) {

            leftChild[current] = update(
                leftChild[previous], start, mid, value
            );

        } else {

            rightChild[current] = update(
                rightChild[previous], mid + 1, end, value
            );
        }

        return current;
    }

    // Find kth smallest using two prefix versions
    int findKth(int rootR, int rootL,
                int start, int end, int k) {

        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;

        // Frequency of values in the left half
        int leftCount =
            treeCount[leftChild[rootR]]
            - treeCount[leftChild[rootL]];

        if (k <= leftCount) {

            return findKth(
                leftChild[rootR],
                leftChild[rootL],
                start, mid, k
            );

        } else {

            return findKth(
                rightChild[rootR],
                rightChild[rootL],
                mid + 1, end,
                k - leftCount
            );
        }
    }

    public ArrayList<Integer> findQuery(int[] arr, int[][] queries) {

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        // Calculate the maximum number of nodes per update
        int levels = 0;

        while ((1L << levels) < n) {
            levels++;
        }

        int capacity = n * (levels + 1) + 5;

        leftChild = new int[capacity];
        rightChild = new int[capacity];
        treeCount = new int[capacity];

        nodeCount = 0;

        // root[i] represents the first i elements
        int[] root = new int[n + 1];

        // Build persistent segment tree versions
        for (int i = 1; i <= n; i++) {

            root[i] = update(
                root[i - 1],
                1, n,
                arr[i - 1]
            );
        }

        // Answer all queries
        for (int[] query : queries) {

            int l = query[0];
            int r = query[1];
            int k = query[2];

            int answer = findKth(
                root[r],
                root[l - 1],
                1, n, k
            );

            result.add(answer);
        }

        return result;
    }
}