# Sum of All Digit Subsequences

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/sum-of-all-sub-sequences-of-a-number3437/1](https://www.geeksforgeeks.org/problems/sum-of-all-sub-sequences-of-a-number3437/1)  
**Problem ID:** `703079`  
**Slug:** `sum-of-all-sub-sequences-of-a-number3437`  
**Accepted Submission Date:** `2026-11-15 12:55:31`  

---

## Problem Statement

Given a string `s` which consists of digits, find the sum of all digits across all non-empty subsequences of `s`.

**Note:** Since the answer can be very large, return it modulo $10^9 + 7$.

**Examples:**
```text
Input: s = "123"
Output: 24
Explanation: The non-empty subsequences are: [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3].
Sum of all digits = 1 + 2 + 3 + (1+2) + (1+3) + (2+3) + (1+2+3) = 24.
```
```text
Input: s = "5"
Output: 5
```

**Constraints:**
- $1 \le |s| \le 10^5$

---

## Solution & Approach

### Approach Explanation

Combinatorial Contribution Counting:
1. In a string of length $n$, each character appears in exactly $2^{n-1}$ subsequences.
2. Therefore, each digit contributes its value times $2^{n-1}$ to the total sum.
3. Total sum = $(\sum_{i=0}^{n-1} 	ext{digit}_i) 	imes 2^{n-1} \pmod{10^9 + 7}$.
4. Compute total digit sum and $2^{n-1} \pmod{10^9+7}$, multiply and return.

### Complexity Analysis
- **Time Complexity:** O(n) where n is the length of string s
- **Auxiliary Space:** O(1) auxiliary space

---

## Source Code

```java
class Solution {
    public int subsequenceSum(String s) {

        long MOD = 1000000007L;
        int n = s.length();

        long sum = 0;
        long power = 1;

        // Calculate sum of all digits
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - '0';
        }

        // Calculate 2^(n-1) % MOD
        for (int i = 1; i < n; i++) {
            power = (power * 2) % MOD;
        }

        // Final answer
        return (int) ((sum * power) % MOD);
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: 5d789376f07f38131555f2b9ee15ead7b2009fbea89667f22e073ec98a5a6418`)
