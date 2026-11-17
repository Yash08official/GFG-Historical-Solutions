# XOR of Number Range

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1](https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1)  
**Problem ID:** `712176`  
**Slug:** `find-xor-of-numbers-from-l-to-r`  
**Accepted Submission Date:** `2026-11-18 00:19:40`  

---

## Problem Statement

Given two integers `l` and `r`, find the bitwise XOR of all integers in the range `[l, r]` (both inclusive).

**Examples:**
```text
Input: l = 4, r = 8
Output: 8
Explanation: The XOR of all integers from 4 to 8 is (4 ^ 5 ^ 6 ^ 7 ^ 8) = 8.
```
```text
Input: l = 2, r = 4
Output: 5
Explanation: The XOR of all integers from 2 to 4 is (2 ^ 3 ^ 4) = 5.
```
```text
Input: l = 5, r = 9
Output: 5
Explanation: The XOR of all integers from 5 to 9 is (5 ^ 6 ^ 7 ^ 8 ^ 9) = 5.
```

**Constraints:**
- $1 \le l \le r \le 10^9$

---

## Solution & Approach

### Approach Explanation

Mathematical Prefix XOR Pattern in $O(1)$ Time:
1. The XOR of all numbers from $1$ to $n$ follows a periodic pattern with period 4:
   - If $n \pmod 4 == 0$: `xorUpto(n) = n`
   - If $n \pmod 4 == 1$: `xorUpto(n) = 1`
   - If $n \pmod 4 == 2$: `xorUpto(n) = n + 1`
   - If $n \pmod 4 == 3$: `xorUpto(n) = 0`
2. Using the prefix XOR property:
   $$	ext{XOR}(l, r) = 	ext{XOR}(1, r) \oplus 	ext{XOR}(1, l - 1)$$
3. Compute `xorUpto(r) ^ xorUpto(l - 1)` directly in $O(1)$ time and $O(1)$ space.

### Complexity Analysis
- **Time Complexity:** O(1)
- **Auxiliary Space:** O(1) auxiliary space

---

## Source Code

```java
class Solution {

    private int xorUpto(int n) {

        if (n % 4 == 0) {
            return n;
        }
        else if (n % 4 == 1) {
            return 1;
        }
        else if (n % 4 == 2) {
            return n + 1;
        }
        else {
            return 0;
        }
    }

    public int findXOR(int l, int r) {

        return xorUpto(r) ^ xorUpto(l - 1);
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: 691533f6678aa2f4cec114898d2ae97e79deb1241bfe158745a1834d36d01923`)
