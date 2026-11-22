# Tower Of Hanoi

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1](https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1)  
**Problem ID:** `701190`  
**Slug:** `tower-of-hanoi-1587115621`  
**Accepted Submission Date:** `2026-11-23 01:11:59`  

---

## Problem Statement

Given **n** disks, consider three rods: the starting rod(from), the target rod (to), and an auxiliary** **rod (aux).  Initially disks are  placed on the starting rod. The smallest disk is placed on top and the largest at the bottom. 

Calculate the minimum number** **of** moves** required to transfer all **n** disks from the starting rod to the target rod, following these rules:
- Only one disk can be moved at a time.
- A disk can only be placed on top of a larger disk or on an empty rod.

Find the minimum** **number of moves needed to complete the task.

**Examples:**
```text
**Input: **n = 2
**Output: **3**
Explanation: **For n = 2, total 3 steps will be taken. Steps are as follows -
move disk 1 from rod 1 to rod 2
move disk 2 from rod 1 to rod 3
move disk 1 from rod 2 to rod 3

```

```text
**Input: **n = 3
**Output: **7**
Explanation: **For n = 3, total 7 steps will be taken.Steps are as follows -
move disk 1 from rod 1 to rod 3
move disk 2 from rod 1 to rod 2
move disk 1 from rod 3 to rod 2
move disk 3 from rod 1 to rod 3
move disk 1 from rod 2 to rod 1
move disk 2 from rod 2 to rod 3
move disk 1 from rod 1 to rod 3

```

```text
**Input: **n = 0
**Output: **0**
Explanation: **Total 0 steps will be taken.
```

---

## Solution & Approach

### Approach Explanation

Classic Divide and Conquer Recursion:
1. Move `n - 1` disks from `from` peg to `aux` peg using `to` peg.
2. Move the `n`-th disk directly from `from` peg to `to` peg (1 move).
3. Move `n - 1` disks from `aux` peg to `to` peg using `from` peg.
4. Total moves formula evaluates to 2^n - 1.

### Complexity Analysis
- **Time Complexity:** O(2^n)
- **Auxiliary Space:** O(n) for recursion stack

---

## Source Code

```java
class Solution {

    public int towerOfHanoi(int n, int from, int to, int aux) {

        // Base case
        if (n == 0) {
            return 0;
        }

        // Move n-1 disks from source to auxiliary
        int first = towerOfHanoi(n - 1, from, aux, to);

        // Move the largest disk (1 move)
        int move = 1;

        // Move n-1 disks from auxiliary to destination
        int second = towerOfHanoi(n - 1, aux, to, from);

        return first + move + second;
    }
}
```
