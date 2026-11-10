class Solution {

    int maxIndexDiff(int[] arr) {

        int n = arr.length;

        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        // Step 1: Build prefix minimum array
        leftMin[0] = arr[0];

        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        }

        // Step 2: Build suffix maximum array
        rightMax[n - 1] = arr[n - 1];

        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], arr[j]);
        }

        // Step 3: Find maximum index difference
        int i = 0;
        int j = 0;
        int maxDiff = 0;

        while (i < n && j < n) {

            if (leftMin[i] <= rightMax[j]) {

                maxDiff = Math.max(maxDiff, j - i);
                j++;

            } else {
                i++;
            }
        }

        return maxDiff;
    }
}
