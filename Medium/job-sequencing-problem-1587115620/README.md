# Job Sequencing Problem

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1](https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1)  
**Problem ID:** `701367`  
**Slug:** `job-sequencing-problem-1587115620`  
**Topic Tags:** `Greedy`, `Disjoint Set`  
**Accepted Submission Date:** `2026-11-09 17:36:36`  
**Language:** `Java`  

---

## Problem Statement

Given deadline[] and profit[] for n jobs, find the maximum profit and count of jobs that can be completed assuming each job takes 1 unit of time.

### Examples

```
Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job 3 (profit 40, deadline 1) and Job 1 (profit 20, deadline 4) can be scheduled, yielding count 2 and profit 60.

Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Jobs 1 and 3 can be scheduled with total profit 127.
```

---

## Approach

- **Greedy + Disjoint Set Union (DSU):**
  - Sort jobs in descending order of profit.
  - Find the latest available free time slot $\le \text{deadline}$ using DSU `parent` array with path compression.
  - If an available slot $> 0$ exists, schedule the job and merge slot `s` with `s - 1`.
- **Time Complexity:** $O(n \log n + n \cdot \alpha(m))$ where $m = \min(n, \max(\text{deadline}))$.
- **Space Complexity:** $O(m)$ for DSU parent array.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: c21525743686f959e9b214deb181ff7e5b29c3e5b4bc77430bd50bf18223b299`
