class Solution {
    public int getMinimumDays(String s, int[] p) {
        int n = s.length();

        // Check if the string is already valid
        boolean valid = true;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                valid = false;
                break;
            }
        }

        if (valid) {
            return 0;
        }

        int low = 1, high = n;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean[] removed = new boolean[n];

            for (int i = 0; i < mid; i++) {
                removed[p[i]] = true;
            }

            valid = true;

            for (int i = 0; i < n - 1; i++) {
                if (!removed[i] && !removed[i + 1] &&
                    s.charAt(i) == s.charAt(i + 1)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
