class Solution {

    public int longestSubstr(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character to the window
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // Find maximum character frequency in current window
            int maxFreq = 0;

            for (int i = 0; i < 26; i++) {
                maxFreq = Math.max(maxFreq, freq[i]);
            }

            // Shrink window if replacements exceed k
            while ((right - left + 1) - maxFreq > k) {

                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;

                left++;

                // Recalculate maximum frequency
                maxFreq = 0;

                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }
            }

            // Update maximum valid window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
