# Minimum Platforms

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1](https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1)  
**Problem ID:** `701368`  
**Slug:** `minimum-platforms-1587115620`  
**Topic Tags:** `Arrays`, `Greedy`, `Sorting`, `Binary Search`  
**Accepted Submission Date:** `2026-11-05 21:49:20`  
**Language:** `Java`  

---

## Problem Statement

Given arrival `arr[]` and departure `dep[]` times of trains on the same day, find the minimum number of platforms needed so that no train waits. A platform cannot serve two trains at the same time; if a train arrives before another departs, an extra platform is needed.

**Note:** Time intervals are in the 24-hour format (`0000` to `2359`), where earlier times occur first.

### Examples

```
Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
Output: 3
Explanation:
Minimum 3 platforms are required to safely accommodate all trains without collision:
- Train 1: arrives 9:00, departs 9:10
- Train 2: arrives 9:40, departs 12:00
- Train 3: arrives 9:50, departs 11:20 (overlap with Train 2 -> requires Platform 2)
- Train 4: arrives 11:00, departs 11:30 (overlap with Trains 2 and 3 -> requires Platform 3)
```

```
Input: arr[] = [900, 1235, 1100], dep[] = [1000, 1240, 1200]
Output: 1
Explanation: All train intervals are mutually non-overlapping. Only 1 platform is needed.
```

---

## Approach

- **Two-Pointer / Chronological Sweeping:**
  - Sort both `arr[]` and `dep[]` independently in non-decreasing order.
  - Maintain two pointers `i` and `j` to scan arrival and departure events.
  - Track active trains `platforms` and peak simultaneous trains `maxPlatforms`.
  - At each step:
    - If `arr[i] <= dep[j]`: A train arrives before the earliest departing train leaves. Increment `platforms`, update `maxPlatforms = max(maxPlatforms, platforms)`, and advance `i`.
    - Else (`arr[i] > dep[j]`): A train departs. Free a platform by decrementing `platforms` and advance `j`.
  - Continue until all trains have arrived (`i < n`).
- **Time Complexity:** `O(n log n)` due to sorting arrival and departure arrays.
- **Space Complexity:** `O(1)` auxiliary space (in-place sort).

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 6a6244625928a6bcc8fff28f86077129e87599cba1e2b180042b6eabcbcc183a`
