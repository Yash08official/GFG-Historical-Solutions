# Count Set Bits in 1 to n

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1](https://www.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1)  
**Problem ID:** `701158`  
**Slug:** `count-total-set-bits-1587115620`  
**Accepted Submission Date:** `2026-11-22 20:34:41`  

---

## Problem Statement

Given a number** n**. Return the total count of set bits for all numbers from 1 to n (both inclusive).

**Examples :
**

```text
**Input**: n = 4
**Output**: 5
**Explanation**: For numbers from 1 to 4. for 1: 0 0 1 => 1 set bit, for 2: 0 1 0 => 1 set bit, for 3: 0 1 1 => 2 set bits, for 4: 1 0 0 => 1 set bit. Therefore, the total set bits are 5.

```

```text
**Input**: n = 17
**Output**: 35
**Explanation**: From numbers 1 to 17(both inclusive), the total number of set bits are 35.
```

---

## Solution & Approach

### Approach Explanation

Divide & Conquer via Powers of 2:
1. Find the largest power of 2, say `2^x <= n`.
2. Numbers from `1` to `2^x - 1` have `x * 2^(x - 1)` set bits.
3. For numbers from `2^x` to `n`, the most significant bit (MSB at position `x`) is set for all `n - 2^x + 1` numbers.
4. Recursively count the remaining bits in `n - 2^x`.
5. Sum all three components.

### Complexity Analysis
- **Time Complexity:** O(log n) recursive calls
- **Auxiliary Space:** O(log n) for recursion stack

---

## Source Code

```java
class Solution {
    public static int countSetBits(int n) {

        if (n == 0) {
            return 0;
        }

        // Find the largest power of 2 <= n
        int x = 0;

        while ((1 << (x + 1)) <= n) {
            x++;
        }

        // Set bits from 1 to (2^x - 1)
        int bits = x * (1 << (x - 1));

        // Remaining numbers after 2^x
        int remaining = n - (1 << x) + 1;

        // Set bits in the most significant position
        int msb = remaining;

        // Recursively count remaining set bits
        int rest = countSetBits(n - (1 << x));

        return bits + msb + rest;
    }
}
```
