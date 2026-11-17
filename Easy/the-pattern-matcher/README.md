# Repeated Pattern Check

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/the-pattern-matcher/1](https://www.geeksforgeeks.org/problems/the-pattern-matcher/1)  
**Problem ID:** `700823`  
**Slug:** `the-pattern-matcher`  
**Accepted Submission Date:** `2026-11-17 21:54:18`  

---

## Problem Statement

Given a string `s` made of two characters `'x'` and `'y'`. The task is to verify whether `s` is made by concatenating substrings that follow the pattern $x^n y^n$ (equal number of `'y'`'s follow equal number of `'x'`'s).

**Examples:**
```text
Input: s = "xxyyxy"
Output: true
Explanation: The string can be split into "xxyy" + "xy". Both substrings contain an equal number of consecutive 'x' and 'y' characters.
```
```text
Input: s = "xyx"
Output: false
Explanation: The string cannot be split into valid substrings following the pattern x^n y^n.
```

**Constraints:**
- $1 \le |s| \le 10^5$

---

## Solution & Approach

### Approach Explanation

Linear scan validating alternating groups:
1. Traverse the string while maintaining a pointer `i`.
2. Each block must begin with character `'x'`. If `s.charAt(i) != 'x'`, return `false`.
3. Count the number of consecutive `'x'` characters (`countX`).
4. Count the number of consecutive `'y'` characters (`countY`).
5. If `countX != countY`, the substring does not follow the $x^n y^n$ pattern; return `false`.
6. Repeat until the end of the string is reached. If all segments are valid, return `true`.

### Complexity Analysis
- **Time Complexity:** O(n) where n is the length of string s
- **Auxiliary Space:** O(1) auxiliary space

---

## Source Code

```java
class Solution {

    public boolean findPattern(String s) {

        int i = 0;
        int n = s.length();

        while (i < n) {

            // Every group must start with x
            if (s.charAt(i) != 'x') {
                return false;
            }

            // Count consecutive x's
            int countX = 0;

            while (i < n && s.charAt(i) == 'x') {
                countX++;
                i++;
            }

            // Count consecutive y's
            int countY = 0;

            while (i < n && s.charAt(i) == 'y') {
                countY++;
                i++;
            }

            // Both counts must be equal
            if (countX != countY) {
                return false;
            }
        }

        return true;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: ca3ad3f8da4d60b61f736ee0dfe034e748dc45fe277146a2cee5e70f1f1e5f41`)
