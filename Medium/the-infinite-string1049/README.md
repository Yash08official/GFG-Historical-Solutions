# Character at Position in Infinite String

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/the-infinite-string1049/1](https://www.geeksforgeeks.org/problems/the-infinite-string1049/1)  
**Problem ID:** `705694`  
**Slug:** `the-infinite-string1049`  
**Accepted Submission Date:** `2026-11-23 00:51:05`  

---

## Problem Statement

Given a string **s** and an integer **pos**, an infinite string is constructed by repeatedly applying the following operation. In the i-th step, append i consecutive $ characters, followed by the reverse of the current string, to the current string.

Formally, if the current string is s, update it as:
- s = s + ('$' repeated i times) + reverse(s)

The initial string is the given s, and the process continues indefinitely. 

Find and return the character at the pos(1-based indexing) in the resulting infinite string.

**Examples:**
```text
**Input:** s = "12345", pos = 3
**Output: **3
**Explanation:** In "12345...", the character at pos 3 is 3.

```

```text
**Input: **s = "12345", pos = 10
**Output: **2
**Explanation:** In "12345$54321...", the character at pos 10 is 2.

```

```text
**Input: **s = "abc", pos = 7
**Output: **a
**Explanation:** In "abc$cba...", the character at pos 7 is a.
```

---

## Solution & Approach

### Approach Explanation

Generational Growth & Backward Coordinate Mapping:
1. Find the generation step where the expanded string length is at least `pos`. At step `k`, length becomes `2 * length + k`.
2. Trace backwards from the outermost generation:
   - If `pos` is in the first half (`<= previousLength`), map into previous generation directly.
   - If `pos` is in the middle separator of `step` '$' characters, return '$'.
   - If `pos` is in the second half (reversed part), reflect `p = length - p + 1` and map into previous generation.
3. Once back at generation 0, index directly into original string `s`.

### Complexity Analysis
- **Time Complexity:** O(log pos) logarithmic backward steps
- **Auxiliary Space:** O(1) constant auxiliary space

---

## Source Code

```java
class Solution {

    public char posInfinite(String s, int pos) {

        long length = s.length();
        long p = pos;

        int step = 0;

        // Find the generation containing the required position
        while (length < p) {
            step++;
            length = 2 * length + step;
        }

        // Trace the position backwards
        while (step > 0) {

            long previousLength = (length - step) / 2;

            if (p <= previousLength) {
                // Position belongs to the original part
                length = previousLength;
            }
            else if (p <= previousLength + step) {
                // Position belongs to the '$' section
                return '$';
            }
            else {
                // Position belongs to the reversed part
                p = length - p + 1;
                length = previousLength;
            }

            step--;
        }

        return s.charAt((int) p - 1);
    }
}
```
