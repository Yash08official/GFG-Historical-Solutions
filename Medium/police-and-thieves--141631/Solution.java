class Solution {

    public int catchThieves(char[] arr, int k) {

        int n = arr.length;

        int i = 0;
        int j = 0;

        int caught = 0;

        while (i < n && j < n) {

            // Find the next policeman
            while (i < n && arr[i] != 'P') {
                i++;
            }

            // Find the next thief
            while (j < n && arr[j] != 'T') {
                j++;
            }

            // If either pointer reaches the end
            if (i == n || j == n) {
                break;
            }

            // Check whether they are within distance k
            if (Math.abs(i - j) <= k) {

                caught++;

                // Both are used, so move both pointers
                i++;
                j++;
            }
            else if (i < j) {

                // Policeman is too far left
                i++;
            }
            else {

                // Thief is too far left
                j++;
            }
        }

        return caught;
    }
}
