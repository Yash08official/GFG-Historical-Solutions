# Activity Selection

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1](https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1)  
**Problem ID:** `701362`  
**Slug:** `activity-selection-1587115620`  
**Topic Tags:** `Greedy`, `Heap`  
**Accepted Submission Date:** `2026-11-07 10:33:43`  
**Language:** `Java`  

---

## Problem Statement

Given two arrays `start[]` and `finish[]`, where `start[i]` and `finish[i]` represent the start time and finish time of the $i$-th activity, find the maximum number of activities that a single person can perform.

A person can perform only one activity at a time, and no two selected activities can overlap. If an activity finishes at time $x$, the next selected activity must start at a time greater than $x$.

### Examples

```
Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: One possible selection is activities {0, 1, 3, 4} with time intervals (1, 2), (3, 4), (5, 7), and (8, 9). Each activity starts after the previous one finishes, so a total of 4 activities can be performed.
```

```
Input: start[] = [10, 12, 20], finish[] = [20, 25, 30]
Output: 1
Explanation: Activity 0 finishes at time 20, and activity 2 also starts at time 20. Since the next activity must start strictly after the previous one finishes (start > finish), they cannot both be selected. Hence, only 1 activity can be performed.
```

---

## Approach

- **Greedy Earliest-Deadline-First Strategy:**
  - Pair each activity's `start[i]` with `finish[i]`.
  - Sort all activities in non-decreasing order of their finish times:
    - Choosing an activity that finishes earliest leaves the maximal remaining time for subsequent activities.
  - Always select the first activity after sorting, setting `count = 1` and `lastFinish = activities[0][1]`.
  - Iterate through the remaining activities:
    - If `activities[i][0] > lastFinish`: This activity does not overlap with the previously scheduled one. Increment `count` and update `lastFinish = activities[i][1]`.
  - Return the total `count` of selected activities.
- **Time Complexity:** $O(n \log n)$ due to sorting the activities by finish time.
- **Space Complexity:** $O(n)$ auxiliary array to store activity pairs.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 878224432fa14771b1e28a0734a9f74a12ae22abb980167668ca1ad41080b5a0`
