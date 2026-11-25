# Maximum Teams of Size K

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/maximum-team-of-k-player/1](https://www.geeksforgeeks.org/problems/maximum-team-of-k-player/1)  
**Problem ID:** `708475`  
**Slug:** `maximum-team-of-k-player`  
**Accepted Submission Date:** `2026-11-25 09:53:04`  

---

## Problem Statement

Given an array **arr[]** consisting of **n** positive integers and a positive integer **k** such that there are **n** countries, each country has **arr[i]** players. Find the **maximum** number of teams that can be formed by forming teams of size k such that each player in the team is from a different country.

**Examples:**

```text
**Input:** arr[] = [4, 3, 5, 3], k = 3
**Output: **5
**Explanation: **Consider the countries are named A, B, C and D. The possible ways of forming the teams are [A, B, C], [A, C, D], [A, B, C], [B, C, D], [A, C, D] such that in each set there are no more than 1 person from a country. Therefore, the total count teams formed is 5.
```

```text
**Input: **arr[] = [2, 3, 4], k = 2
**Output: **4
**Explanation: **Consider the countries are named A, B, C and D. The possible ways of forming the teams are {B, C}, {B, C}, {A, C}, ({A, B} or {A, C} or {B, C}) such that in each set there are no more than 1 person from a country. Therefore, the total count teams formed is 4.
```

**Constraints:**
1 ≤ n ≤ 105
1 ≤ k ≤ n
1 ≤ arr[i] ≤ 104

---

## Solution & Approach

### Approach Explanation

Binary Search on Answer:
1. To form `mid` teams, each category can contribute at most 1 player per team, meaning a category with `players` can contribute at most `min(players, mid)` players.
2. The total contributed players must satisfy `sum(min(players, mid)) >= mid * k`.
3. Binary search `mid` in range `[0, totalPlayers / k]`. If feasible, try larger `mid` (`left = mid + 1`); otherwise try smaller (`right = mid - 1`).

### Complexity Analysis
- **Time Complexity:** O(n * log(totalPlayers / k))
- **Auxiliary Space:** O(1) constant space

---

## Source Code

```java
class Solution {

    int countOfTeams(int k, int[] arr) {

        int left = 0;
        int right = 0;

        // Maximum possible teams cannot exceed total players / k
        long totalPlayers = 0;

        for (int players : arr) {
            totalPlayers += players;
        }

        right = (int)(totalPlayers / k);

        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long available = 0;

            // Calculate available contributions
            for (int players : arr) {
                available += Math.min(players, mid);
            }

            // Check whether mid teams can be formed
            if (available >= (long) mid * k) {

                answer = mid;
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return answer;
    }
}
```
