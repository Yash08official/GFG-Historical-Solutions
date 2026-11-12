# Validate IP Address

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1](https://www.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1)  
**Problem ID:** `700325`  
**Slug:** `validate-an-ip-address-1587115621`  
**Accepted Submission Date:** `2026-11-12 09:42:04`  

---

## Problem Statement

You are given a string `s` in the form of an IPv4 Address. Your task is to validate whether it is a valid IPv4 Address. If it is valid return `true`, otherwise return `false`.

A valid IPv4 Address is of the form `x1.x2.x3.x4` where $0 \le x_i \le 255$ and each number cannot have leading zeroes unless the number itself is `0`.

**Examples:**
```text
Input: s = "222.111.111.111"
Output: true
Explanation: Here, the IPv4 address is as per the criteria.
```
```text
Input: s = "5555..555"
Output: false
Explanation: "5555..555" is not a valid IPv4 address.
```
```text
Input: s = "0.0.0.0"
Output: true
```
```text
Input: s = "0.0.01.255"
Output: false
Explanation: Leading zeroes are not allowed.
```

**Constraints:**
- $1 \le |s| \le 50$

---

## Solution & Approach

### Approach Explanation

Strict parsing and validation of the four dot-separated segments:
1. Split the string with `s.split("\\.", -1)` to preserve empty trailing tokens.
2. Check that there are exactly 4 parts.
3. For each part:
   - Must not be empty.
   - Must not have leading zeros if length > 1 (e.g. "01" is invalid, but "0" is valid).
   - Must contain only numeric digits ('0'-'9').
   - Must have length $\le 3$.
   - Must parse to an integer within the range `[0, 255]`.
4. If all four segments satisfy all conditions, return `true`; otherwise return `false`.

### Complexity Analysis
- **Time Complexity:** O(|s|) where |s| is the length of the string (at most 50 characters)
- **Auxiliary Space:** O(1) auxiliary space

---

## Source Code

```java
class Solution {

    public boolean isValid(String s) {

        // Step 1: Split using dot
        String[] parts = s.split("\\.", -1);

        // Exactly 4 parts required
        if (parts.length != 4) {
            return false;
        }

        // Step 2: Validate each part
        for (String part : parts) {

            // Empty part is invalid
            if (part.length() == 0) {
                return false;
            }

            // Leading zero is invalid
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }

            // Check only digits
            for (int i = 0; i < part.length(); i++) {

                if (part.charAt(i) < '0' || part.charAt(i) > '9') {
                    return false;
                }
            }

            // Maximum 3 digits
            if (part.length() > 3) {
                return false;
            }

            // Convert to integer
            int num = Integer.parseInt(part);

            // Check range
            if (num < 0 || num > 255) {
                return false;
            }
        }

        return true;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: aeb223f2064ea004a1bc8aaa714ddbea3a3d84dc63c6beb1091fd5fa9e293cef`)
