# Minimum Time with 2 Scanners

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-the-minimum-time0253/1](https://www.geeksforgeeks.org/problems/find-the-minimum-time0253/1)  
**Problem ID:** `704889`  
**Slug:** `find-the-minimum-time0253`  
**Topic Tags:** `Mathematics`, `Binary Search`  
**Accepted Submission Date:** `2026-11-08 11:46:28`  
**Language:** `Java`  

---

## Problem Statement

Geek has `n` documents that need to be scanned using two scanners. 

- Scanner 1 takes `s1` units of time to scan one document.
- Scanner 2 takes `s2` units of time to scan one document.

Both scanners can operate simultaneously, and each scanner can scan only one document at a time. A scanner can start scanning its next document immediately after finishing the current one.

Find the minimum time required to scan all `n` documents.

### Examples

```
Input: n = 2, s1 = 2, s2 = 4
Output: 4
Explanation: We can either scan both documents using scanner 1, which takes 2 * 2 = 4 units of time, or scan one document using each scanner simultaneously, which takes max(2, 4) = 4 units of time. Both approaches require 4 units of time.
```

```
Input: n = 2, s1 = 1, s2 = 3
Output: 2
Explanation: The optimal approach is to scan both documents using scanner 1, which takes 2 * 1 = 2 units of time.
```

---

## Approach

- **Linear Search over Document Partitions:**
  - If scanner 1 scans $i$ documents ($0 \le i \le n$), then scanner 2 must scan the remaining $(n - i)$ documents.
  - Since both scanners operate in parallel, the total time required for partition $i$ is:
    $$\text{totalTime} = \max(i \times s1, (n - i) \times s2)$$
  - Iterate $i$ from $0$ to $n$ and find the minimum possible value of $\text{totalTime}$.
- **Time Complexity:** $O(n)$ single iteration loop from $0$ to $n$.
- **Space Complexity:** $O(1)$ constant auxiliary space.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 99a4791344af3d86f049396c03b6601d877bae9d73454f775449a7a8908f2245`
