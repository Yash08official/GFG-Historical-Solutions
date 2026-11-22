# Partitions with Given Difference

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1](https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1)  
**Problem ID:** `712675`  
**Slug:** `partitions-with-given-difference`  
**Accepted Submission Date:** `2026-11-22 20:34:02`  

---

## Problem Statement

Given an array**** arr[]**** and an integer ****diff****, count the number of ways to partition the array into two subsets such that the difference between their sums is equal to diff.

****Note:**** A partition in the array means dividing an array into two subsets say S1 and S2 such that the union of S1 and S2 is equal to the original array and each element is present in only one of the subsets.

**Examples :**

```text
**Input: **arr[] = [5, 2, 6, 4], diff = 3
**Output: **1
**Explanation: **There is only one possible partition of this array. Partition : [6, 4], [5, 2]. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.
```

```text
**Input:** arr[] = [1, 1, 1, 1], diff = 0 
**Output:** 6 
**Explanation: **We can choose two 1's from indices [0,1], [0,2], [0,3], [1,2], [1,3], [2,3] and put them in sum1 and remaining two 1's in sum2.
Thus there are total 6 ways for partition the array arr. 

```

```text
**Input:** arr[] = [3, 2, 5, 1], diff = 4  
**Output:** 0
**Explanation: **There is no possible partition of the array that satisfy the given difference.** **
```

**Constraint:**
1 ≤ arr.size() ≤ 50
0 ≤ diff ≤ 50
0 ≤ arr[i] ≤ 6

---

## Solution & Approach

### Approach Explanation

Subset Sum Dynamic Programming:
1. Let the two partition sums be `s1` and `s2`. We need `s1 - s2 = diff` and `s1 + s2 = sum`.
2. Adding both equations gives `2 * s1 = sum + diff` => `s1 = (sum + diff) / 2`.
3. If `sum < diff` or `(sum + diff)` is odd, return 0.
4. Reduce to finding the count of subsets with sum equal to `target = (sum + diff) / 2` using a 1D space-optimized DP array.

### Complexity Analysis
- **Time Complexity:** O(n * target) where target = (sum + diff) / 2
- **Auxiliary Space:** O(target) 1D dynamic programming array

---

## Source Code

```java
class Solution {
    public int countPartitions(int[] arr, int diff) {

        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        // No valid partition possible
        if (sum < diff || (sum + diff) % 2 != 0) {
            return 0;
        }

        int target = (sum + diff) / 2;

        // dp[s] = number of ways to make sum s
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int num : arr) {

            for (int s = target; s >= num; s--) {

                dp[s] += dp[s - num];
            }
        }

        return dp[target];
    }
}
```
