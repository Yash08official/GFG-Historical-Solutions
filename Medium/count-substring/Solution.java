class Solution {
    public static int countSubstring(String s) {

        int n = s.length();

        int[] freq = new int[3];

        int left = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {

            // Add current character to the window
            freq[s.charAt(right) - 'a']++;

            // Check whether a, b and c are present
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                // Count all valid substrings ending at or after right
                count += n - right;

                // Remove the leftmost character
                freq[s.charAt(left) - 'a']--;

                left++;
            }
        }

        return count;
    }
}