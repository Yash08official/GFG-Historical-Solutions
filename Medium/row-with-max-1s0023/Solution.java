class Solution {
    public int rowWithMax1s(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        int maxOnes = 0;
        int result = -1;

        for (int i = 0; i < n; i++) {

            int low = 0;
            int high = m - 1;
            int firstOne = m;

            // Binary Search
            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (arr[i][mid] == 1) {
                    firstOne = mid;
                    high = mid - 1;
                } 
                else {
                    low = mid + 1;
                }
            }

            int count = m - firstOne;

            if (count > maxOnes) {
                maxOnes = count;
                result = i;
            }
        }

        return result;
    }
}
