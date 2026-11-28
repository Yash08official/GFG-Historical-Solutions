# Count Distinct Substrings

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1](https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1)  
**Problem ID:** `700389`  
**Slug:** `count-of-distinct-substrings`  
**Accepted Submission Date:** `2026-11-28 10:53:38`  

---

## Problem Statement

Given a string **s** consisting of lowercase English letters, find the** **total number of distinct non-empty **substrings** of s.

**Note: **A substring is a contiguous sequence of characters within a string. Two substrings are considered distinct if they have different character sequences, regardless of their positions in the string.

**Examples :**
```text
**Input: **s = "ababa"
**Output: **9
**Explanation**: All distinct substrings of "ababa" are: "a", "b", "ab", "ba", "aba", "bab", "abab", "baba", "ababa".

```

```text
**Input: **s = "aaa"
**Output: **3
**Explanation****:** The distinct substrings of "aaa" are: "a", "aa", "aaa".
```

**Constraints:**
1 ≤ s.size() ≤ 3000

---

## Solution & Approach

### Approach Explanation

Suffix Automaton (SAM):
1. Build a Suffix Automaton on string s in O(n) time and O(n) space.
2. Each state i in the SAM represents a set of equivalent substrings whose lengths span range (len[link[i]], len[i]].
3. The number of distinct non-empty substrings contributed by state i is exactly len[i] - len[link[i]].
4. Sum this value across all states i >= 1 to obtain the total count of distinct substrings.

### Complexity Analysis
- **Time Complexity:** O(n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
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
```
