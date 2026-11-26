# Nine Divisors

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/nine-divisors3751/1](https://www.geeksforgeeks.org/problems/nine-divisors3751/1)  
**Problem ID:** `703523`  
**Slug:** `nine-divisors3751`  
**Accepted Submission Date:** `2026-11-26 10:56:18`  

---

## Problem Statement

Given a positive integer **n**, you need to **count **the numbers less than or equal to **n** having **exactly 9 divisors**.

**Examples :**
```text
**Input: **n = 100**
Output: **2**
Explanation: **Numbers which have exactly 9 divisors are 36 and 100.
```

```text
**Input: **n = 200**
Output: **3**
Explanation: **Numbers which have exactly 9 divisors are 36, 100, 196. 
```

**Constraints:**
1 ≤ n ≤ 109

---

## Solution & Approach

### Approach Explanation

Prime Factorization Structure & Sieve:
1. A number x has exactly 9 divisors if and only if its prime factorization is either p^8 (where p is prime) or p^2 * q^2 (where p, q are distinct primes), since (8+1) = 9 and (2+1)(2+1) = 9.
2. Generate all primes up to floor(sqrt(n)) using the Sieve of Eratosthenes.
3. Case 1: Count primes p such that p^8 <= n.
4. Case 2: Count distinct prime pairs (p, q) with p < q such that p^2 * q^2 <= n <=> p * q <= sqrt(n).
5. Use a two-pointer approach over the primes list up to sqrt(n) to count valid pairs in O(primes).

### Complexity Analysis
- **Time Complexity:** O(sqrt(n) * log log sqrt(n) + pi(sqrt(n)))
- **Auxiliary Space:** O(sqrt(n))

---

## Source Code

```java
import java.util.*;

class Solution {

    public static int countNumbers(int n) {

        int limit = (int) Math.sqrt(n);

        // Step 1: Generate primes using Sieve
        boolean[] isPrime = new boolean[limit + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;

        if (limit >= 1) {
            isPrime[1] = false;
        }

        for (int i = 2; i * i <= limit; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Store all primes
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= limit; i++) {

            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int count = 0;

        // Step 3: Count numbers of form p^8
        for (int p : primes) {

            long value = 1;

            for (int i = 0; i < 8; i++) {
                value *= p;
            }

            if (value <= n) {
                count++;
            } else {
                break;
            }
        }

        // Step 4: Count numbers of form p^2 * q^2
        for (int i = 0; i < primes.size(); i++) {

            long pSquare = (long) primes.get(i) * primes.get(i);

            for (int j = i + 1; j < primes.size(); j++) {

                long qSquare = (long) primes.get(j) * primes.get(j);

                if (pSquare * qSquare <= n) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
```
