class Solution {

    public int findIndex(int[] a, int[] b, int p, int q) {

        int left = 0;
        int right = a.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Compare numerator first
            if (a[mid] < p) {

                left = mid + 1;

            } else if (a[mid] > p) {

                right = mid - 1;

            } else {

                // Numerator matches, compare denominator
                if (b[mid] < q) {

                    left = mid + 1;

                } else if (b[mid] > q) {

                    right = mid - 1;

                } else {

                    // Both numerator and denominator match
                    answer = mid;

                    // Search left for the first occurrence
                    right = mid - 1;
                }
            }
        }

        return answer;
    }
}
