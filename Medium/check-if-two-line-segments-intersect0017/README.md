# Check If Two Segments Intersect

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/check-if-two-line-segments-intersect0017/1](https://www.geeksforgeeks.org/problems/check-if-two-line-segments-intersect0017/1)  
**Problem ID:** `705344`  
**Slug:** `check-if-two-line-segments-intersect0017`  
**Accepted Submission Date:** `2026-11-22 20:37:37`  

---

## Problem Statement

Given the endpoints of two line segments, (**p1, q1)** and (**p2, q2)**, find if the two line segments intersect. An intersection is considered valid only if it lies on both line segments (including their endpoints).

**Examples:**
```text
**Input: **p1[] = [1, 1], q1[] = [10, 1], p2[] = [1, 2], q2[] = [10, 2]
**Output: **false
**Explanation:** The two line segments formed by p1-q1 and p2-q2 do not intersect.
```

```text
**Input: **p1[] = [10, 0], q1[] = [0, 10], p2[] = [0, 0], q2[] = [10, 10]
**Output: **true
**Explanation: **The two line segments formed by p1-q1 and p2-q2 intersect.
```

```text
**Input: **p1[] = [5, -2], q1[] = [13, 2], p2[] = [2, -3], q2[] = [3, 0]
**Output: **false
**Explanation: **The two line formed by p1-q1 and p2-q2 are intersecting beyond endpoints, so it is not considerable.
```

---

## Solution & Approach

### Approach Explanation

Computational Geometry - Orientation Test & Collinear Check:
1. Determine the orientation (collinear, clockwise, counterclockwise) of point triplets using 2D cross product.
2. Two line segments (p1, q1) and (p2, q2) intersect if:
   - General case: (p1, q1, p2) and (p1, q1, q2) have different orientations AND (p2, q2, p1) and (p2, q2, q1) have different orientations.
   - Collinear case: Points are collinear and project onto the segments (`onSegment`).

### Complexity Analysis
- **Time Complexity:** O(1) constant time geometric formulas
- **Auxiliary Space:** O(1) constant auxiliary space

---

## Source Code

```java
class Solution {

    // Find orientation of three points
    // 0 = Collinear
    // 1 = Clockwise
    // 2 = Counterclockwise
    int orientation(int[] p, int[] q, int[] r) {

        long val = (long)(q[1] - p[1]) * (r[0] - q[0])
                 - (long)(q[0] - p[0]) * (r[1] - q[1]);

        if (val == 0) return 0;

        return (val > 0) ? 1 : 2;
    }

    // Check whether point q lies on segment pr
    boolean onSegment(int[] p, int[] q, int[] r) {

        return q[0] <= Math.max(p[0], r[0]) &&
               q[0] >= Math.min(p[0], r[0]) &&
               q[1] <= Math.max(p[1], r[1]) &&
               q[1] >= Math.min(p[1], r[1]);
    }

    public boolean doIntersect(int[] p1, int[] q1,
                               int[] p2, int[] q2) {

        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // General case
        if (o1 != o2 && o3 != o4) {
            return true;
        }

        // Special cases: collinear points
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;

        if (o2 == 0 && onSegment(p1, q2, q1)) return true;

        if (o3 == 0 && onSegment(p2, p1, q2)) return true;

        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false;
    }
}
```
