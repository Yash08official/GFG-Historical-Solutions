# Smith Number

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/smith-number4132/1](https://www.geeksforgeeks.org/problems/smith-number4132/1)  
**Problem ID:** `705123`  
**Slug:** `smith-number4132`  
**Accepted Submission Date:** `2026-11-22 20:38:44`  

---

## Problem Statement

Given a number n, find out whether this number is a Smith number or not. A Smith number is a composite number whose sum of digits is equal to the sum of digits of its prime factorization.

**Examples:**

```text
**Input: **n = 648
**Output: **true
**Explanation: **648 = 23*34, 6+4+8 = 2+2+2+3+3+3+3. And 648 is composite.
```

```text
**Input: **n = 762
**Output: **true
**Explanation: **762 = 21*31*1271 is a Smith number because 7+6+2 = 2+3+(1+2+7) is composite.
```

```text
**Input: **n = 7
**Output: **false
**Explanation: **7 is not a Smith number because 7 is not a composite.
```

**Constraints:**
1 <= n <= 109

---

## Solution & Approach

### Approach Explanation

Prime Factorization and Digit Sum Verification:
1. A Smith number is a composite number whose sum of digits equals the sum of digits of its prime factors (with multiplicity).
2. Compute the digit sum of `n`.
3. Factorize `n` by checking divisors `i` from 2 up to `sqrt(temp)`.
4. For each prime factor `i`, repeatedly divide and add `digitSum(i)` to `factorsDigitSum`.
5. If remaining `temp > 1`, add `digitSum(temp)` to factors sum.
6. Verify that `n` is composite and `digitSum(n) == factorsDigitSum`.

### Complexity Analysis
- **Time Complexity:** O(sqrt(n)) for prime factorization
- **Auxiliary Space:** O(1) constant auxiliary space

---

## Source Code

```java
class Solution {

    int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public boolean smithNum(int n) {

        int temp = n;
        int factorsDigitSum = 0;
        boolean isComposite = false;

        for (int i = 2; i * i <= temp; i++) {

            while (temp % i == 0) {

                factorsDigitSum += digitSum(i);
                temp /= i;
                isComposite = true;
            }
        }

        if (temp > 1) {
            factorsDigitSum += digitSum(temp);
        }

        return isComposite && digitSum(n) == factorsDigitSum;
    }
}
```
