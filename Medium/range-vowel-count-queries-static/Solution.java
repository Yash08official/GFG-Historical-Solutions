import java.util.*;

class Solution {

    public ArrayList<Integer> countVowels(String s, int[][] queries) {

        int n = s.length();

        int[] prefix = new int[n];

        // Build prefix sum array
        for (int i = 0; i < n; i++) {

            int isVowel = isVowel(s.charAt(i)) ? 1 : 0;

            if (i == 0) {
                prefix[i] = isVowel;
            } else {
                prefix[i] = prefix[i - 1] + isVowel;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Process each query
        for (int[] query : queries) {

            int l = query[0];
            int r = query[1];

            int count;

            if (l == 0) {
                count = prefix[r];
            } else {
                count = prefix[r] - prefix[l - 1];
            }

            result.add(count);
        }

        return result;
    }

    // Check whether character is a vowel
    private boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' ||
               ch == 'i' || ch == 'o' ||
               ch == 'u';
    }
}
