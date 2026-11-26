# Stream First Non-Repeating

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1](https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1)  
**Problem ID:** `705333`  
**Slug:** `first-non-repeating-character-in-a-stream1216`  
**Accepted Submission Date:** `2026-11-27 00:16:12`  

---

## Problem Statement

Given a string **s** consisting of only lowercase alphabets, for each index** i** in the string (0 ≤ i < n), find the first non-repeating character in the prefix **s[0..i]**. If no such character exists, use **'#'**.

**Examples:**
```text
**Input: **s = "aabc"
**Output: **a#bb
**Explanation: 
**At i=0 ("a"): First non-repeating character is 'a'.
At i=1 ("aa"): No non-repeating character, so '#'.
At i=2 ("aab"): First non-repeating character is 'b'.
At i=3 ("aabc"): Non-repeating characters are 'b' and 'c'; 'b' appeared first, so 'b'. 
```

```text
**Input: **s = "bb" 
**Output: **"b#" 
**Explanation: 
**At i=0 ("b"): First non-repeating character is 'b'.
At i=1 ("bb"): No non-repeating character, so '#'.
```

---

## Solution & Approach

### Approach Explanation

Frequency Array with Queue:
1. Maintain a frequency array of size 26 and a queue storing characters in arrival order.
2. For each incoming character ch, increment its frequency in freq and append it to the queue.
3. Pop characters from the front of the queue while the character at the front has frequency > 1 (repeating).
4. If the queue is empty, append '#' to the result string; otherwise append queue.peek().

### Complexity Analysis
- **Time Complexity:** O(n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    public String firstNonRepeating(String s) {

        int[] freq = new int[26];

        Queue<Character> queue = new LinkedList<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Step 1: Update frequency
            freq[ch - 'a']++;

            // Step 2: Add current character to queue
            queue.add(ch);

            // Step 3: Remove repeating characters from the front
            while (!queue.isEmpty() &&
                   freq[queue.peek() - 'a'] > 1) {

                queue.poll();
            }

            // Step 4: Get the first non-repeating character
            if (queue.isEmpty()) {
                result.append('#');
            } else {
                result.append(queue.peek());
            }
        }

        return result.toString();
    }
}
```
