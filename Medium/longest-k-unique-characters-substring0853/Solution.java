class Solution {

    public int longestKSubstr(String s, int k) {

        int n = s.length();

        int[] freq = new int[26];

        int left = 0;
        int distinct = 0;
        int maxLength = -1;

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            // Add current character
            if (freq[ch - 'a'] == 0) {
                distinct++;
            }

            freq[ch - 'a']++;

            // Shrink window if distinct > k
            while (distinct > k) {

                char leftChar = s.charAt(left);

                freq[leftChar - 'a']--;

                if (freq[leftChar - 'a'] == 0) {
                    distinct--;
                }

                left++;
            }

            // Update answer when exactly k distinct characters
            if (distinct == k) {

                maxLength = Math.max(
                    maxLength,
                    right - left + 1
                );
            }
        }

        return maxLength;
    }
}
