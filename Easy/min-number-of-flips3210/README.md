# Min Flips for Alternate

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/min-number-of-flips3210/1](https://www.geeksforgeeks.org/problems/min-number-of-flips3210/1)  
**Problem ID:** `703255`  
**Slug:** `min-number-of-flips3210`  
**Accepted Submission Date:** `2026-11-20 10:18:35`  

---

## Problem Statement

Given a binary string `s`, we can flip any bit (change `'0'` to `'1'` or `'1'` to `'0'`) to make the string alternating. A string is called alternating if no two adjacent characters are the same. Find the minimum number of bit flips required to make the string alternating.

**Examples:**
```text
Input: s = "001"
Output: 1
Explanation: Flip the bit at index 0 from '0' to '1' to obtain "101", which is an alternating binary string. Hence, minimum flips = 1.
```
```text
Input: s = "0001010111"
Output: 2
Explanation: Flip the bits at indices 1 and 8 to obtain "0101010101", which is alternating. Hence, minimum flips = 2.
```

**Constraints:**
- $1 \le |s| \le 10^5$

---

## Solution & Approach

### Approach Explanation

Dual Alternating Pattern Comparison:
1. There are only two possible alternating binary patterns for a string of length $n$:
   - Pattern 1: Starting with `'0'` (`010101...`), where expected bit at index $i$ is `'0'` if $i$ is even, else `'1'`.
   - Pattern 2: Starting with `'1'` (`101010...`), where expected bit at index $i$ is `'1'` if $i$ is even, else `'0'`.
2. In a single pass, count the number of mismatches between `s` and Pattern 1 (`flips1`), and between `s` and Pattern 2 (`flips2`).
3. Return `Math.min(flips1, flips2)`.

### Complexity Analysis
- **Time Complexity:** O(n) where n is the length of string s
- **Auxiliary Space:** O(1) auxiliary space

---

## Source Code

```java
class Solution {

    public int minFlips(String s) {

        int flips1 = 0; // Pattern: 010101...
        int flips2 = 0; // Pattern: 101010...

        for (int i = 0; i < s.length(); i++) {

            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected1) {
                flips1++;
            }

            if (s.charAt(i) != expected2) {
                flips2++;
            }
        }

        return Math.min(flips1, flips2);
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: 4092f75499613fc23d7d5c85c8be171b7fd0bce495d773f38f84a62c7a7261ea`)
