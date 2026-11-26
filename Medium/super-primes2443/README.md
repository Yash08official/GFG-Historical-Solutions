# Super Primes

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/super-primes2443/1](https://www.geeksforgeeks.org/problems/super-primes2443/1)  
**Problem ID:** `702913`  
**Slug:** `super-primes2443`  
**Accepted Submission Date:** `2026-11-26 10:55:24`  

---

## Problem Statement

Given a positive integer **n**, return all super-prime numbers less than or equal to n.

A super-prime is a prime number whose position in the sequence of prime numbers is also prime.

**Examples:**

```text
**Input: **n = 5
**Output:** [3, 5]
**Explanation: **The prime numbers up to 5 are [2, 3, 5]. Their positions are [1, 2, 3]. Since positions 2 and 3 are prime, 3 and 5 are super-primes.
```

```text
**Input: **n = 20 
**Output:** [3, 5, 11, 17]
**Explanation: **The prime numbers up to 20 are [2, 3, 5, 7, 11, 13, 17, 19]. Their positions are [1, 2, 3, 4, 5, 6, 7, 8]. Since positions 2, 3, 5, and 7 are prime, 3, 5, 11, and 17 are super-primes.
```

---

## Solution & Approach

### Approach Explanation

Sieve of Eratosthenes & Prime Difference:
1. A prime number p is a 'super-prime' if it can be written as the sum of two primes: p = p_1 + p_2.
2. Since p is prime, if p > 2, p must be odd. The sum of two numbers can only be odd if one is even and one is odd.
3. The only even prime is 2! Thus, for any odd super-prime p, the two primes must be 2 and p - 2.
4. Therefore, p is a super-prime if and only if both p and p - 2 are prime (i.e. p-2 and p form a twin prime pair).
5. Use Sieve of Eratosthenes up to n to mark all primes, then check for every prime p <= n whether p-2 is also prime.

### Complexity Analysis
- **Time Complexity:** O(n * log log n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    public ArrayList<Integer> superPrimes(int n) {

        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Create sieve
        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;

        if (n >= 1) {
            isPrime[1] = false;
        }

        // Step 2: Mark non-prime numbers
        for (int i = 2; i * i <= n; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 3: Find super primes
        int position = 0;

        for (int i = 2; i <= n; i++) {

            if (isPrime[i]) {

                position++;

                // Prime number whose position is prime
                if (position <= n && isPrime[position]) {
                    result.add(i);
                }
            }
        }

        return result;
    }
}
```
