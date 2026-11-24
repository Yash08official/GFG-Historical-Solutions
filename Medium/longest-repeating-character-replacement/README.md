# Longest Repeating Character Replacement

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/longest-repeating-character-replacement/1](https://www.geeksforgeeks.org/problems/longest-repeating-character-replacement/1)  
**Problem ID:** `712141`  
**Slug:** `longest-repeating-character-replacement`  
**Accepted Submission Date:** `2026-11-24 11:21:35`  

---

## Problem Statement

Given a string **s **of length **n** consisting of uppercase English letters and an integer **k**, you are allowed to perform** at most** k operations.  In each operation, you can change any character of the string to any other uppercase English letter.

 Determine the length of the longest substring that can be transformed into a string with all identical characters after performing at most k such operations.

**Examples:**

```text
**Input**: s = "ABBA", k = 2 
**Output:** 4 
**Explanation: **The string "ABBA" can be fully converted into the same character using at most 2 changes. By replacing both 'A' with 'B', it becomes "BBBB". Hence, the maximum length is 4.

```

```text
**Input: **s = "ADBD", k = 1
**Output: **3
**Explanation: **In the string "ADBD", we can make at most 1 change. By changing 'B' to 'D', the string becomes "ADDD", which contains a substring "DDD" of length 3.
```

**Constraints:
**1 ≤ n, k ≤ 105
s consists of only uppercase English letters.

---

## Solution & Approach

### Approach Explanation

Sliding Window with Character Frequency Tracking:
1. In any window of length `windowLen = right - left + 1`, the minimum number of replacements needed to make all characters identical is `windowLen - maxFreq`, where `maxFreq` is the frequency of the most frequent character in that window.
2. If `windowLen - maxFreq > k`, shrink the window from `left` and update frequency table.
3. Track the maximum valid window length found.

### Complexity Analysis
- **Time Complexity:** O(26 * n) = O(n)
- **Auxiliary Space:** O(1) fixed 26-element array

---

## Source Code

```java
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
```
