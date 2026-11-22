# Friends Pairing Problem

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1](https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1)  
**Problem ID:** `703687`  
**Slug:** `friends-pairing-problem5425`  
**Accepted Submission Date:** `2026-11-23 01:13:33`  

---

## Problem Statement

Given **n **friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.

**Examples :**
```text
**Input: **n = 3
**Output:** 4
**Explanation**:
{1}, {2}, {3} : All single
{1}, {2,3} : 2 and 3 paired but 1 is single.
{1,2}, {3} : 1 and 2 are paired but 3 is single.
{1,3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1,2} and {2,1} are considered same.

```

```text
**Input**: n = 2
**Output:** 2
**Explanation**:
{1} & {2}: All single.
{1,2}: 1 and 2 are paired.

```

```text
**Input**: n = 1
**Output:** 1
```

**Constraints:**
1 ≤ n ≤ 18

---

## Solution & Approach

### Approach Explanation

Dynamic Programming with Space Optimization:
1. Each person `i` has two choices:
   - Stay single: reduces to `f(i - 1)`.
   - Pair with any of the other `i - 1` friends: reduces to `(i - 1) * f(i - 2)`.
2. Recurrence relation: `f(i) = f(i - 1) + (i - 1) * f(i - 2)`.
3. Compute iteratively with two variables `prev1` and `prev2` in O(1) auxiliary space.

### Complexity Analysis
- **Time Complexity:** O(n) single pass
- **Auxiliary Space:** O(1) space optimized

---

## Source Code

```java
class Solution {

    public int countFriendsPairings(int n) {

        // Base cases
        if (n <= 2) {
            return n;
        }

        int prev2 = 1; // f(1)
        int prev1 = 2; // f(2)

        for (int i = 3; i <= n; i++) {

            int current = prev1 + (i - 1) * prev2;

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
```
