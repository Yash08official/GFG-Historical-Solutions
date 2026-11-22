# Next Prime Number

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/next-prime-number/1](https://www.geeksforgeeks.org/problems/next-prime-number/1)  
**Problem ID:** `704414`  
**Slug:** `next-prime-number`  
**Accepted Submission Date:** `2026-11-22 20:37:07`  

---

## Problem Statement

Given an integer **n**, find the smallest prime number strictly greater than **n**.

**Examples:** ** **
```text
**Input: **n = 15
**Output: **17
**Explanation: **17 is next prime number.
```

```text
**Input: **n = 7**
Output: **11**
Explanation: **11 is the smallest prime number strictly greater than 7.
```

---

## Solution & Approach

### Approach Explanation

Incremental Primality Testing:
1. Start searching from `num = n + 1`.
2. For each number, test primality by checking divisibility from 2 up to `sqrt(num)`.
3. Return the first integer that passes the primality test.

### Complexity Analysis
- **Time Complexity:** O(k * sqrt(n)) where k is the distance to the next prime (by prime gap estimates, k is very small)
- **Auxiliary Space:** O(1) constant auxiliary space

---

## Source Code

```java
class Solution {

    public static int nextPrime(int n) {

        int num = n + 1;

        while (true) {

            boolean isPrime = true;

            // Check whether num is prime
            for (int i = 2; i * i <= num; i++) {

                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                return num;
            }

            num++;
        }
    }
}
```
