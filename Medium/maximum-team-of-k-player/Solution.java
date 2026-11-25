class Solution {

    int countOfTeams(int k, int[] arr) {

        int left = 0;
        int right = 0;

        // Maximum possible teams cannot exceed total players / k
        long totalPlayers = 0;

        for (int players : arr) {
            totalPlayers += players;
        }

        right = (int)(totalPlayers / k);

        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long available = 0;

            // Calculate available contributions
            for (int players : arr) {
                available += Math.min(players, mid);
            }

            // Check whether mid teams can be formed
            if (available >= (long) mid * k) {

                answer = mid;
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return answer;
    }
}
