# Count Substrings with a, b and c

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-substring/1](https://www.geeksforgeeks.org/problems/count-substring/1)  
**Problem ID:** `712150`  
**Slug:** `count-substring`  
**Accepted Submission Date:** `2026-11-27 00:29:15`  

---

## Problem Statement

Given a string **s** consisting only a, b, c. return the number of substrings containing **at least** one occurrence of all characters a, b, and c.

**Examples:**

```text
**Input: **s =** **"abcabc"
**Output: **10
**Explanation: **The required substrings  are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc"*.*
```

```text
**Input: **s = "aaacb"
**Output: **3
**Explanation: **The required substring are "acb", "aacb", "aaacb". 
```

**Constraint:**
3 ≤ s.length ≤ 5 x 104  
s only contains a, b, c.

---

## Solution & Approach

### Approach Explanation

Sliding Window / Two Pointers:
1. Maintain a frequency array of size 3 for characters 'a', 'b', and 'c'.
2. Expand the window by moving the right pointer and incrementing the frequency of s.charAt(right).
3. While all three characters 'a', 'b', and 'c' are present in the window (`freq[0] > 0 && freq[1] > 0 && freq[2] > 0`):
   - Any substring starting at left and ending at right or any index up to n - 1 contains at least one of each character. Therefore, add n - right to the total count.
   - Shrink the window from the left by decrementing `freq[s.charAt(left) - 'a']` and incrementing left.

### Complexity Analysis
- **Time Complexity:** O(n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
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
```
