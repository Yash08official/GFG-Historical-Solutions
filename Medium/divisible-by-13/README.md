# Divisible by 13

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/divisible-by-13/1](https://www.geeksforgeeks.org/problems/divisible-by-13/1)  
**Problem ID:** `897411`  
**Slug:** `divisible-by-13`  
**Accepted Submission Date:** `2026-11-22 20:41:11`  

---

## Problem Statement

Given a number represented as a string **s** (which may be very large), check whether it is divisible by 13 or not.

**Examples:**

```text
**Input : **s = "2911285"
**Output :** true
**Explanation: **2911285 / 13 = 223945, which is a whole number with no remainder.
```

```text
**Input :** s = "27"
**Output :** false
**Explanation: **27 / 13 ≈ 2.0769..., which is not a whole number (there is a remainder).
```

**Constraints:
**1 ≤  s.size()  ≤ 105

---

## Solution & Approach

### Approach Explanation

Modular Arithmetic with Horner's Rule:
1. Given a large number represented as a string `s`, we evaluate its remainder modulo 13 digit by digit.
2. Initialize `remainder = 0`.
3. For each digit character in the string, compute `remainder = (remainder * 10 + digit) % 13`.
4. Return `true` if final `remainder == 0`, else `false`.

### Complexity Analysis
- **Time Complexity:** O(n) where n is the length of string s
- **Auxiliary Space:** O(1) constant space

---

## Source Code

```java
class Solution {
    public boolean divby13(String s) {

        int remainder = 0;

        for (int i = 0; i < s.length(); i++) {

            int digit = s.charAt(i) - '0';

            remainder = (remainder * 10 + digit) % 13;
        }

        return remainder == 0;
    }
}
```
