# Max Equal Sum in 3 Stacks

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-maximum-equal-sum-of-three-stacks/1](https://www.geeksforgeeks.org/problems/find-maximum-equal-sum-of-three-stacks/1)  
**Problem ID:** `709993`  
**Slug:** `find-maximum-equal-sum-of-three-stacks`  
**Accepted Submission Date:** `2026-11-14 09:08:12`  

---

## Problem Statement

Given three stacks `s1`, `s2`, and `s3`, represented by arrays where the first element of each array represents the top of the corresponding stack. Find the maximum possible equal sum (sum of all elements) of all three stacks by removing zero or more elements from the top of each stack. If it is not possible to make the sum of all three stacks equal, return `0`.

**Examples:**
```text
Input: s1 = [3, 2, 1, 1, 1], s2 = [4, 3, 2], s3 = [1, 1, 4, 1]
Output: 5
Explanation: Remove s1[0] (3), remaining sum = 5.
Remove s2[0] (4), remaining sum = 5.
Remove s3[0] (1) and s3[1] (1), remaining sum = 5.
```
```text
Input: s1 = [1, 1], s2 = [2], s3 = [3]
Output: 0
```

**Constraints:**
- $1 \le s1.	ext{size}(), s2.	ext{size}(), s3.	ext{size}() \le 10^5$
- $1 \le s1[i], s2[i], s3[i] \le 10^3$

---

## Solution & Approach

### Approach Explanation

Greedy Three-Pointer Sum Reduction:
1. Compute the total sum of each stack (`sum1`, `sum2`, `sum3`).
2. Use three index pointers `i`, `j`, `k` starting at 0 (the top of each stack).
3. While all pointers are within bounds:
   - If `sum1 == sum2 && sum2 == sum3`, we have achieved maximum equal sum; return `sum1`.
   - Identify the stack with the largest current sum and pop its top element by subtracting its value and incrementing that stack's pointer.
4. If any stack becomes empty without reaching equality, return `0`.

### Complexity Analysis
- **Time Complexity:** O(n1 + n2 + n3) where n1, n2, n3 are stack sizes
- **Auxiliary Space:** O(1) auxiliary space

---

## Source Code

```java
import java.util.*;

class Solution {

    public int maxEqualSum(ArrayList<Integer> s1,
                           ArrayList<Integer> s2,
                           ArrayList<Integer> s3) {

        // Calculate initial sums
        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;

        for (int x : s1) {
            sum1 += x;
        }

        for (int x : s2) {
            sum2 += x;
        }

        for (int x : s3) {
            sum3 += x;
        }

        // Top pointers (first element is top)
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < s1.size() &&
               j < s2.size() &&
               k < s3.size()) {

            // All three sums are equal
            if (sum1 == sum2 && sum2 == sum3) {
                return (int) sum1;
            }

            // Remove from stack with largest sum
            if (sum1 >= sum2 && sum1 >= sum3) {

                sum1 -= s1.get(i);
                i++;

            } else if (sum2 >= sum1 && sum2 >= sum3) {

                sum2 -= s2.get(j);
                j++;

            } else {

                sum3 -= s3.get(k);
                k++;
            }
        }

        return 0;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: fedbf5fce78e06eb03068cf451978208d11f7b5e1152cc170c8ae8aad1c00b1d`)
