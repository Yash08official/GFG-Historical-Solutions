# Restricted Pacman

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/restricted-pacman--141631/1](https://www.geeksforgeeks.org/problems/restricted-pacman--141631/1)  
**Problem ID:** `706075`  
**Slug:** `restricted-pacman--141631`  
**Accepted Submission Date:** `2026-11-27 00:21:02`  

---

## Problem Statement

In the game of Restricted Pacman, an infinite linear path is given. Pacman has to start at position 0 and eat as many candies as possible. In one move he can only jump a distance of either **m** or **n**.  If **m** and **n** are coprime numbers, find how many candies will be left on the board after the game is over.
**Note:** The result is always finite as after a point **x** every index in the infinite path can be visited. 

**Examples:**
```text
**Input: **m= 2, n= 5
**Output:** 2
**Explanation:** From index 0, the indices that can be visited are
0 + 2 = 2
0 + 2 + 2 = 4
0 + 5 = 5
0 + 2 + 2 + 2 = 6
0 + 2 + 5 = 7
0 + 2 + 2 + 2 + 2 = 8
0 + 2 + 2 + 5 = 9
0 + 5 + 5 = 10
and so on.
1 and 3 are the only indices that cannot be visited. Therefore the candies at these two positions will be left on the board. 
```

```text
**Input: **m = 2, n = 7
**Output:** 3 
**Explanation **: From index 0,the indices that can be visited are 
0 + 2 = 2
0 + 2 + 2 = 4
0 + 2 + 2 + 2 =6
0 + 7 = 7
0 + 2 + 2 + 2 + 2 = 8
0 + 2 + 7 = 9
and so on.
1 ,3 and 5 are the only indices that cannot be visited .Therefore the candies at these two postions will be left on the board 
```

**Constraints:**
1 < m, n ≤ 500

---

## Solution & Approach

### Approach Explanation

Chicken McNugget Theorem / Frobenius Coin Problem:
1. For two coprime positive integers m and n, the Frobenius number (largest integer that cannot be expressed as a * m + b * n for non-negative integers a, b) is m * n - m - n.
2. The total count of positive integers that cannot be represented as a non-negative linear combination of m and n is given by the formula ((m - 1) * (n - 1)) / 2.
3. Return ((m - 1) * (n - 1)) / 2.

### Complexity Analysis
- **Time Complexity:** O(1)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {

    static int candies(int m, int n) {

        return ((m - 1) * (n - 1)) / 2;
    }
}
```
