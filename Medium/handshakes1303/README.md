# Non-Crossing Handshakes in Circle

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/handshakes1303/1](https://www.geeksforgeeks.org/problems/handshakes1303/1)  
**Problem ID:** `704623`  
**Slug:** `handshakes1303`  
**Accepted Submission Date:** `2026-11-23 01:15:59`  

---

## Problem Statement

There are **n** people sitting around a circular table. Any two people can shake hands with each other. Find the number of ways to perform handshakes such that no two handshakes intersect or cross each other when the handshakes are represented as straight lines between the corresponding people.

A handshake is considered crossing if the line segments representing two handshakes intersect at a point other than a common endpoint.

**Examples:**

```text
**Input: **n = 4
**Output: **2
**Explanation: **The two possible non-crossing handshake arrangements are: {{1, 2}, {3, 4}} and {{1, 4}, {2, 3}}.

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/933103/Web/Other/blobid1_1787219048.png" />

```

```text
**I****nput: **n = 2
**Output: **1
**Explanation: **The only possible handshake is {1, 2}.
```

---

## Solution & Approach

### Approach Explanation

Catalan Number Dynamic Programming:
1. When person 1 pairs with person `j + 2` in a circle of `i` people, the circle is partitioned into two disjoint subsets of size `j` and `i - 2 - j`.
2. Both subsets must have an even number of people to allow valid pairwise handshakes without crossing.
3. Compute transitions `dp[i] += dp[j] * dp[i - 2 - j]` for all even `j`, which corresponds to Catalan numbers C(n/2).

### Complexity Analysis
- **Time Complexity:** O(n^2) DP transitions
- **Auxiliary Space:** O(n) for DP array

---

## Source Code

```java
class Solution {

    static int count(int n) {

        int[] dp = new int[n + 1];

        // Base case
        dp[0] = 1;

        // Calculate for even number of people
        for (int i = 2; i <= n; i += 2) {

            for (int j = 0; j < i; j += 2) {

                dp[i] += dp[j] * dp[i - 2 - j];
            }
        }

        return dp[n];
    }
}
```
