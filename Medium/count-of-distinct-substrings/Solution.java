import java.util.*;

class Solution {
    public static int countSubs(String s) {

        int n = s.length();
        int maxStates = 2 * n;

        int[][] next = new int[maxStates][26];
        int[] link = new int[maxStates];
        int[] len = new int[maxStates];

        // Initialize transitions with -1.
        for (int i = 0; i < maxStates; i++) {
            Arrays.fill(next[i], -1);
        }

        // Initial state.
        int size = 1;
        int last = 0;

        link[0] = -1;

        // Build the Suffix Automaton.
        for (int i = 0; i < n; i++) {

            int ch = s.charAt(i) - 'a';

            int current = size++;
            len[current] = len[last] + 1;

            int p = last;

            while (p != -1 && next[p][ch] == -1) {
                next[p][ch] = current;
                p = link[p];
            }

            if (p == -1) {
                link[current] = 0;
            } else {

                int q = next[p][ch];

                if (len[p] + 1 == len[q]) {
                    link[current] = q;
                } else {

                    int clone = size++;

                    len[clone] = len[p] + 1;
                    link[clone] = link[q];

                    System.arraycopy(next[q], 0,
                                     next[clone], 0, 26);

                    while (p != -1 && next[p][ch] == q) {
                        next[p][ch] = clone;
                        p = link[p];
                    }

                    link[q] = clone;
                    link[current] = clone;
                }
            }

            last = current;
        }

        // Count distinct non-empty substrings.
        int answer = 0;

        for (int i = 1; i < size; i++) {
            answer += len[i] - len[link[i]];
        }

        return answer;
    }
}