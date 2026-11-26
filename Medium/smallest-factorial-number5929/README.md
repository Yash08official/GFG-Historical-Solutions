# Smallest With At Least n Trailing 0s in Factorial

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/smallest-factorial-number5929/1](https://www.geeksforgeeks.org/problems/smallest-factorial-number5929/1)  
**Problem ID:** `702829`  
**Slug:** `smallest-factorial-number5929`  
**Accepted Submission Date:** `2026-11-26 10:57:55`  

---

## Problem Statement

Given an integer **n**, find the smallest positive integer **x** such that the factorial of **x** (i.e.,  x! ) contains at least n trailing zeroes.

**Examples:**
```text
**Input:** n = 6
**Output:** 25
**Explanation:** 25! = 15511210043330985984000000, It ends with 6 trailing zeroes, which is the minimum required.
```

```text
**Input:** n = 1
**Output:** 5
**Explanation:** 5! = 120, It ends with 1 trailing zero, which meets the requirement.

```

---

## Solution & Approach

### Approach Explanation

Binary Search on Answer with Legendre's Formula:
1. The number of trailing zeros in x! is given by Legendre's formula: sum_{k=1}^{inf} floor(x / 5^k).
2. The number of trailing zeros is monotonically non-decreasing with respect to x.
3. Binary search for x in range [0, 5 * n]. For each midpoint `mid`, compute the count of factors of 5 in `mid!`.
4. If count >= n, search left (`high = mid - 1`), else search right (`low = mid + 1`).

### Complexity Analysis
- **Time Complexity:** O(log^2 n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {

    // Calculate trailing zeroes in x!
    private int countZeroes(int x) {

        int count = 0;

        while (x > 0) {

            x /= 5;
            count += x;
        }

        return count;
    }

    public int findNum(int n) {

        int low = 1;
        int high = 5 * n;

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int zeroes = countZeroes(mid);

            if (zeroes >= n) {

                answer = mid;

                // Try to find a smaller number
                high = mid - 1;

            } else {

                // Need a larger number
                low = mid + 1;
            }
        }

        return answer;
    }
}
```
