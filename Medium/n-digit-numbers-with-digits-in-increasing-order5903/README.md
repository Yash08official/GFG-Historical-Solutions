# N-Digit Numbers with Increasing Digits

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1](https://www.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1)  
**Problem ID:** `704744`  
**Slug:** `n-digit-numbers-with-digits-in-increasing-order5903`  
**Accepted Submission Date:** `2026-11-23 01:15:14`  

---

## Problem Statement

Given an integer **n**, return all the **n** digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).

**Examples :**

```text
**Input: **n = 1
**Output: **[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
**Explanation: **Single digit numbers are considered to be strictly increasing order.

```

```text
**Input: **n = 2
**Output: **[12, 13, 14, 15, 16, 17, 18, 19, 23....79, 89]
**Explanation: **For n = 2, the correct sequence is 12 13 14 15 16 17 18 19 23 and so on up to 89.
```

```text
**Input:** n = 15
**Output:** []
**Explanation:** No such number exist. 
```

**Constraints:**
1 ≤ n ≤ 105

---

## Solution & Approach

### Approach Explanation

Backtracking / Combinatorial Generation:
1. For `n = 1`, all single digits 0 through 9 are strictly valid increasing numbers.
2. For `n > 1`, the first digit can range from 1 to 9.
3. Recursively append each subsequent digit strictly greater than the previous digit (`digit + 1` to 9).
4. When `n` digits are placed, add the generated number to the result list.

### Complexity Analysis
- **Time Complexity:** O(9 C n) = O(2^9) which is constant bounded (at most C(9, n) numbers)
- **Auxiliary Space:** O(n) for recursion call stack

---

## Source Code

```java
import java.util.*;

class Solution {

    static ArrayList<Integer> result;

    public static ArrayList<Integer> increasingNumbers(int n) {

        result = new ArrayList<>();

        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }

        if (n > 10) {
            return result;
        }

        generate(0, 1, n);

        return result;
    }

    static void generate(int num, int start, int n) {

        // Required number of digits generated
        if (n == 0) {
            result.add(num);
            return;
        }

        // Try digits from start to 9
        for (int digit = start; digit <= 9; digit++) {

            generate(num * 10 + digit, digit + 1, n - 1);
        }
    }
}
```
