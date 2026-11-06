# Balanced Binary Tree Counter

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/bbt-counter4914/1](https://www.geeksforgeeks.org/problems/bbt-counter4914/1)  
**Problem ID:** `704986`  
**Slug:** `bbt-counter4914`  
**Topic Tags:** `Mathematics`, `Tree`  
**Accepted Submission Date:** `2026-11-06 09:55:15`  
**Language:** `Java`  

---

## Problem Statement

Given a height `h`, find the maximum number of distinct balanced binary trees of height exactly `h`.

A binary tree is balanced if, for every node, the heights of its left and right subtrees differ by at most 1. A tree with a single node has height 1. An empty tree has height 0.

**Note:** Since the answer can be very large, return it modulo $10^9 + 7$.

### Examples

```
Input: h = 1
Output: 1
Explanation: Only one tree of height 1 exists i.e. a single node.
```

```
Input: h = 2
Output: 3
Explanation: 3 distinct balanced trees of height 2 exist.
```

```
Input: h = 3
Output: 15
Explanation: 15 distinct balanced trees of height 3 exist.
```

---

## Approach

- **Dynamic Programming (Recurrence Relation):**
  - For a balanced binary tree of height `h`, the heights of its left and right subtrees `(h_left, h_right)` can be:
    1. Both of height `h - 1`: $count(h - 1) \times count(h - 1)$
    2. Left of height `h - 1`, right of height `h - 2`: $count(h - 1) \times count(h - 2)$
    3. Left of height `h - 2`, right of height `h - 1`: $count(h - 2) \times count(h - 1)$
  - Combining these cases gives the recurrence:
    $$count(h) = count(h - 1)^2 + 2 \times count(h - 1) \times count(h - 2) \pmod{10^9 + 7}$$
  - **Base Cases:**
    - $h = 0 \implies 1$
    - $h = 1 \implies 1$
  - **Space Optimization:** Since calculating $count(h)$ only requires the values of the previous two states ($count(h - 1)$ and $count(h - 2)$), we maintain two variables `a` and `b` instead of an array.
- **Time Complexity:** $O(h)$ single loop from 2 to $h$.
- **Space Complexity:** $O(1)$ constant auxiliary space.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 86bd47996b4aacde088932fbef56c7a41769c846402d324ca30d759c466fa6a2`
