class Solution {

    static void relativeSort(int[] a1, int[] a2) {

        int max = 1000000;

        // Store frequency of elements in a1
        int[] freq = new int[max + 1];

        for (int num : a1) {
            freq[num]++;
        }

        int index = 0;

        // Process elements according to a2
        for (int num : a2) {

            // Ignore repeated elements in a2
            if (freq[num] == 0) {
                continue;
            }

            // Add all occurrences of this element
            while (freq[num] > 0) {
                a1[index++] = num;
                freq[num]--;
            }
        }

        // Add remaining elements in ascending order
        for (int num = 1; num <= max; num++) {

            while (freq[num] > 0) {
                a1[index++] = num;
                freq[num]--;
            }
        }
    }
}