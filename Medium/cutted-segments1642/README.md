# Maximize The Cut Segments

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/cutted-segments1642/1](https://www.geeksforgeeks.org/problems/cutted-segments1642/1)  
**Problem ID:** `701901`  
**Slug:** `cutted-segments1642`  
**Accepted Submission Date:** `2026-11-22 20:35:23`  

---

## Problem Statement

Given an integer **n** denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either **x** , **y** or **z**. Here x, y, and z are integers.
After performing all the cut operations, your** **total number of cut segments must be maximum. Return the maximum number of cut segments possible.

**Note**: if no segment can be cut then return 0.

**Examples:**
```text
**Input: **n = 4, x = 2, y = 1, z = 1
**Output: **4**
Explanation: **Total length is 4, and the cut lengths are 2, 1 and 1.  We can make maximum 4 segments each of length 1.

```

```text
**Input: **n = 5, x = 5, y = 3, z = 2
**Output: **2**
Explanation: **Here total length is 5, and the cut lengths are 5, 3 and 2. We can make two segments of lengths 3 and 2.

```

```text
**Input: **n = 7, x = 8, y = 9, z = 10
**Output: **0**
Explanation: **Here the total length is 7, and the cut lengths are 8, 9, and 10. We cannot cut the segment into lengths that fully utilize the segment, so the output is 0.
```

---

## Solution & Approach

### Approach Explanation

Dynamic Programming (Unbounded Knapsack style):
1. Define `dp[i]` as the maximum number of cuts for a line segment of length `i`.
2. Initialize `dp` array with -1 to represent unreachable lengths, with base case `dp[0] = 0`.
3. For each length `i` from 1 to `n`, check transitions from `i - x`, `i - y`, and `i - z`. If valid, update `dp[i] = max(dp[i], dp[prev] + 1)`.
4. Return `dp[n]` if reachable, else 0.

### Complexity Analysis
- **Time Complexity:** O(n) linear scan
- **Auxiliary Space:** O(n) for DP table

---

## Source Code

```java
import java.util.*;

class Solution {
    public int maximizeCuts(int n, int x, int y, int z) {

        // dp[i] = maximum cuts possible for length i
        int[] dp = new int[n + 1];

        // Initially, mark all lengths as impossible
        Arrays.fill(dp, -1);

        // Length 0 requires zero cuts
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            // Try cut length x
            if (i >= x && dp[i - x] != -1) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }

            // Try cut length y
            if (i >= y && dp[i - y] != -1) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }

            // Try cut length z
            if (i >= z && dp[i - z] != -1) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }

        // If no valid combination exists, return 0
        return Math.max(0, dp[n]);
    }
}
```
