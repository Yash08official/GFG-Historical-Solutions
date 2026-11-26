# Minimum Distance in Grid

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/minimum-distance-on-a-grid/1](https://www.geeksforgeeks.org/problems/minimum-distance-on-a-grid/1)  
**Problem ID:** `701718`  
**Slug:** `minimum-distance-on-a-grid`  
**Accepted Submission Date:** `2026-11-27 00:22:07`  

---

## Problem Statement

Given a starting point **(sx, sy)** and a destination point **(dx, dy)** on a special grid. From any point (x, y), you may move only right to **(x + 1, y)** or up to **(x, y + 1)**, and each move costs 1 unit of distance.

Find the minimum distance required to reach (dx, dy) from (sx, sy). If it is impossible to reach the destination using only right or up moves, return -1.
```text
**Input:** sx = 1, sy  = 1, dx = 2, dy = 2
**Output:** 2
**Explanation:** The starting coordinate is (1,1) and ending (2,2). We can move either up or right. So, we move right to (2,1) then move up to (2,2). So a minimum of 2 steps.
```

```text
**Input:** sx = 3, sy = 5, dx = 2, dy = 7
**Output:** -1
**Explanation:** The starting point is (3,5) and the destination is (2,7). Since we can move only right (increase x) or up (increase y), we can never reduce x from 3 to 2. Therefore, reaching (2,7) is impossible, and the answer is -1.
```

---

## Solution & Approach

### Approach Explanation

Manhattan Distance Verification:
1. In a grid where moves are restricted to non-negative steps along coordinates (right and down/up only towards destination):
2. If dx < sx or dy < sy, the destination cannot be reached; return -1.
3. Otherwise, the minimum steps required is the Manhattan distance: (dx - sx) + (dy - sy).

### Complexity Analysis
- **Time Complexity:** O(1)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {
    public int minDistance(int sx, int sy, int dx, int dy) {
        
        // Check if destination is reachable
        if (dx < sx || dy < sy) {
            return -1;
        }

        // Calculate total number of moves
        return (dx - sx) + (dy - sy);
    }
}
```
