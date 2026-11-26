class Solution {

    // Calculate trailing zeroes in x!
    private int countZeroes(int x) {

        int count = 0;

        while (x > 0) {

            x /= 5;
            count += x;
        }

        return count;
    }

    public int findNum(int n) {

        int low = 1;
        int high = 5 * n;

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int zeroes = countZeroes(mid);

            if (zeroes >= n) {

                answer = mid;

                // Try to find a smaller number
                high = mid - 1;

            } else {

                // Need a larger number
                low = mid + 1;
            }
        }

        return answer;
    }
}