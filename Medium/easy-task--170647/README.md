# Kth Largest and Update Queries on Substrings

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/easy-task--170647/1](https://www.geeksforgeeks.org/problems/easy-task--170647/1)  
**Problem ID:** `714277`  
**Slug:** `easy-task--170647`  
**Accepted Submission Date:** `2026-11-26 13:36:37`  

---

## Problem Statement

Given a lowercase string **s** of length **n** and **q** queries, process the queries in order. 

There are two types of queries numbered as 1 and 2: 

- ["**1**", **index**, **ch**]: Update the character at position index in s to ch.

- ["**2**", **left**, **right**, **k**]:  Consider the substring s[left...right] (both inclusive). Return the k-th lexicographically largest character in the substring after sorting its characters in descending order. Duplicate characters are counted separately (i.e., find the k-th character, not the k-th distinct character).

Return an array containing the answers to all Type 2 queries in the order they appear.

**Note:** All indices are 0-based.

**Examples:**

```text
**Input:** s** **= "abab", queries[][] = [["1", "2", "d"], ["2", "1", "3", "1"]]
**Output:** ["d"]
**Explanation: **After the first query, s becomes "abdb".
The substring from index 1 to 3 is "bdb". 
Sorting it in descending order gives "dbb", so the 1st largest character is 'd'.
```

```text
**Input:** s** **= "aaa", queries[][] = [["1", "1", "e"], ["1", "2", "c"], ["2", "1", "2", "2"]]
**Output: **["c"]
**Explanation: **After the updates, s becomes "aec".
The substring from index 1 to 2 is "ec". 
Sorting it in descending order gives "ec", so the 2nd largest character is 'c'.
```

**Constraints:
**1 ≤ n ≤ 5 * 104
1 ≤ q ≤ 105
0 ≤ left ≤ right < n
0 ≤ index < n
1 ≤ k ≤ right - left + 1
'a' ≤ s[i], ch ≤ 'z'
The sum of n over all test cases does not exceed 5 * 104

---

## Solution & Approach

### Approach Explanation

Segment Tree of Alphabet Frequency Buckets:
1. Since the alphabet size |Sigma| = 26 is small, each node in the segment tree stores a frequency count array `int[26]` representing character counts in that segment.
2. Point update (Type 1): Decrement frequency of old character and increment frequency of new character along the path from root to leaf in O(26 * log n).
3. Range frequency query (Type 2): Query total character frequencies in range `[l, r]` in O(26 * log n).
4. Find k-th largest character: Traverse frequency array from 'z' down to 'a', decrementing k until k <= freq[c], yielding the k-th largest character in O(26).

### Complexity Analysis
- **Time Complexity:** O(26 * (n + q * log n))
- **Auxiliary Space:** O(26 * n)

---

## Source Code

```java
import java.util.*;

class Solution {

    int[][] tree;
    int n;

    // Build the segment tree
    private void build(String s, int node, int start, int end) {

        if (start == end) {

            tree[node][s.charAt(start) - 'a'] = 1;

            return;
        }

        int mid = start + (end - start) / 2;

        build(s, 2 * node, start, mid);
        build(s, 2 * node + 1, mid + 1, end);

        // Merge character frequencies
        for (int i = 0; i < 26; i++) {

            tree[node][i] =
                tree[2 * node][i] +
                tree[2 * node + 1][i];
        }
    }

    // Update one character
    private void update(int node, int start, int end,
                        int index, char oldChar, char newChar) {

        if (start == end) {

            tree[node][oldChar - 'a'] = 0;
            tree[node][newChar - 'a'] = 1;

            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {

            update(2 * node, start, mid,
                   index, oldChar, newChar);

        } else {

            update(2 * node + 1, mid + 1, end,
                   index, oldChar, newChar);
        }

        // Recalculate parent frequencies
        for (int i = 0; i < 26; i++) {

            tree[node][i] =
                tree[2 * node][i] +
                tree[2 * node + 1][i];
        }
    }

    // Get character frequencies in a range
    private int[] query(int node, int start, int end,
                        int l, int r) {

        int[] result = new int[26];

        // No overlap
        if (end < l || start > r) {
            return result;
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return tree[node].clone();
        }

        int mid = start + (end - start) / 2;

        int[] left = query(
            2 * node, start, mid, l, r
        );

        int[] right = query(
            2 * node + 1, mid + 1, end, l, r
        );

        // Merge frequencies
        for (int i = 0; i < 26; i++) {
            result[i] = left[i] + right[i];
        }

        return result;
    }

    public ArrayList<String> processQueries(String s, String[][] queries) {

        ArrayList<String> answer = new ArrayList<>();

        n = s.length();

        tree = new int[4 * n][26];

        // Build initial segment tree
        build(s, 1, 0, n - 1);

        // StringBuilder allows efficient character updates
        StringBuilder str = new StringBuilder(s);

        for (String[] q : queries) {

            int type = Integer.parseInt(q[0]);

            if (type == 1) {

                int index = Integer.parseInt(q[1]);

                char newChar = q[2].charAt(0);

                char oldChar = str.charAt(index);

                // No work needed if character is unchanged
                if (oldChar != newChar) {

                    update(1, 0, n - 1,
                           index, oldChar, newChar);

                    str.setCharAt(index, newChar);
                }

            } else {

                int l = Integer.parseInt(q[1]);
                int r = Integer.parseInt(q[2]);
                int k = Integer.parseInt(q[3]);

                // Get frequencies for the requested substring
                int[] freq = query(1, 0, n - 1, l, r);

                // Find kth largest character
                for (int i = 25; i >= 0; i--) {

                    if (k > freq[i]) {

                        k -= freq[i];

                    } else {

                        answer.add(
                            String.valueOf((char)('a' + i))
                        );

                        break;
                    }
                }
            }
        }

        return answer;
    }
}
```
