class Solution {
    public int minTime(int n, int s1, int s2) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            int time1 = i * s1;
            int time2 = (n - i) * s2;

            int totalTime = Math.max(time1, time2);

            ans = Math.min(ans, totalTime);
        }

        return ans;
    }
}
