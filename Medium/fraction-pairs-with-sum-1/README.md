# Fraction Pairs with Sum 1

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/fraction-pairs-with-sum-1/1](https://www.geeksforgeeks.org/problems/fraction-pairs-with-sum-1/1)  
**Problem ID:** `716016`  
**Slug:** `fraction-pairs-with-sum-1`  
**Accepted Submission Date:** `2026-11-22 20:39:49`  

---

## Problem Statement

Given a list of fractions, represented as two lists** **numerator and denominator, the task is to determine the count of pairs of fractions whose sum equals 1.

**Example 1:**

```text
**I****nput: **numerator[] = [1, 2, 2, 8], denominator[] = [2, 4, 6, 12]
**Output: **2
**Explanation: **Fractions 1/2 and 2/4 sum to 1. Similarly fractions 2/6 and 8/12 sum to 1. So there are 2 pairs of fractions which sum to 1.

```

```text
**Input: **numerator[] = [3, 1, 12, 81, 2], denominator[] = [9, 10, 18, 90, 5]
**Output: **2
**Explanation: **Fractions 3/9 and 12/18 sum to 1. Similarly fractions 1/10 and 81/90 sum to 1. So there are 2 pairs of fractions which sum to 1.
```

**Constraints:**
1 ≤ numerator.size() ≤ 105
1 ≤ numerator[i] ≤ denominator[i] ≤ 109

---

## Solution & Approach

### Approach Explanation

Hash Map with Fraction Simplification via GCD:
1. For two fractions `a/b + c/d = 1`, the required complement for fraction `num/den` is `(den - num)/den`.
2. Reduce both the complement fraction and the current fraction to their lowest terms using the Greatest Common Divisor (GCD).
3. Use a frequency map storing string keys of irreducible fractions `"num/den"`.
4. Look up the count of existing matching complements in the map, add to result, and insert current fraction into the map.

### Complexity Analysis
- **Time Complexity:** O(n * log(min(num, den))) where n is number of fractions
- **Auxiliary Space:** O(n) for the hash map

---

## Source Code

```java
import java.util.*;

class Solution {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int countFractions(int[] numerator, int[] denominator) {

        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < numerator.length; i++) {

            int num = numerator[i];
            int den = denominator[i];

            // Find complementary fraction: (den - num) / den
            int complementNum = den - num;
            int complementDen = den;

            // Simplify complementary fraction
            int g = gcd(complementNum, complementDen);

            complementNum /= g;
            complementDen /= g;

            String key = complementNum + "/" + complementDen;

            // Check if complementary fraction exists
            count += map.getOrDefault(key, 0);

            // Simplify current fraction
            g = gcd(num, den);

            num /= g;
            den /= g;

            String currentKey = num + "/" + den;

            // Store current fraction
            map.put(currentKey, map.getOrDefault(currentKey, 0) + 1);
        }

        return count;
    }
}
```
