# Longest Substring with K Uniques

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1](https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1)  
**Problem ID:** `703219`  
**Slug:** `longest-k-unique-characters-substring0853`  
**Accepted Submission Date:** `2026-11-12 09:39:26`  

---

## Problem Statement

You are given a string `s` consisting only of lowercase alphabets and an integer `k`. Your task is to find the length of the longest substring that contains exactly `k` distinct characters. If no such substring exists, return `-1`.

**Examples:**
```text
Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
```
```text
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
```

**Constraints:**
- $1 \le |s| \le 10^5$
- $1 \le k \le 26$

---

## Solution & Approach

### Approach Explanation

Use a two-pointer sliding window technique:
1. Maintain a frequency array of size 26 and a variable `distinct` to count unique characters currently in the window `[left, right]`.
2. Expand the window by incrementing `right`. If the character's frequency becomes 1, increment `distinct`.
3. If `distinct > k`, shrink the window from the `left` until `distinct <= k`.
4. Whenever `distinct == k`, update `maxLength = max(maxLength, right - left + 1)`.
5. Return `maxLength` (defaults to -1 if no valid substring is found).

### Complexity Analysis
- **Time Complexity:** O(n) where n is the length of string s
- **Auxiliary Space:** O(1) auxiliary space (fixed-size array of 26 integers)

---

## Source Code

```java
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
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: d7905a6dfaac780392bf58f227c1de50dd67375e55e9ce7ef82d91eb43d6c460`)
