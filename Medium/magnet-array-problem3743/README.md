# Equilibrium Points

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/magnet-array-problem3743/1](https://www.geeksforgeeks.org/problems/magnet-array-problem3743/1)  
**Problem ID:** `703198`  
**Slug:** `magnet-array-problem3743`  
**Accepted Submission Date:** `2026-11-26 10:53:57`  

---

## Problem Statement

Magnets are placed on X axis, the coordinates of which are given in sorted order, you need to find out the X-co-ordinates of all the equilibrium points (i.e. the point where net force is zero). 
- The polarity of the magnet is such that exerts +ve force in its right side and -ve force in left side, (here +ve is considered in +ve direction of x-axis). 
- Forces are inversely proportional to the distance, thus there lies an equilibrium point between every two magnetic points.

You are mainly given a sorted integer array **arr[]** of size n, where arr[i] denotes the coordinate of the i-th point on the X-axis, you need to find all the points x for which the net force of all magnets (or the below expression) is 0.

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/703198/Web/Other/blobid0_1783495909.png" />

- It is guaranteed that there exists exactly one such point in every open interval (arr[i], arr[i + 1]) for 0 ≤ i < n - 1. 
- Return an array containing all n - 1 points, each accurate to 2 decimal places.

**Examples:**
```text
**Input: **arr[] = [1, 2]
**Output: **[1.50]
**Explanation: **The mid point of two points will have net force zero, thus answer = 1.50

```

```text
**Input: **arr[] = [0, 10, 20, 30]
**Output: **[3.82, 15.00, 26.18]
**Explanation:** 
Between 0 and 10: The points at 20 and 30 also contribute to the force, so the equilibrium point shifts toward 0, giving 3.82 instead of the midpoint (5).
Between 10 and 20: The arrangement is symmetric about 15, so the forces balance exactly at 15.00.
Between 20 and 30: By symmetry with the first interval, the equilibrium point is 26.18, shifted toward 30.
```

**Constraints:**
2 ≤ n ≤ 103
0 ≤  arr[1] < ....arr[i] < arr[i+1] < ....arr[n] ≤ 106

---

## Solution & Approach

### Approach Explanation

Binary Search on Continuous Real Domain (Bisection Method):
1. Between every adjacent pair of magnets arr[i] and arr[i+1], the net magnetic force changes sign monotonically (from +inf at arr[i]^+ to -inf at arr[i+1]^-).
2. Therefore, exactly one null point (equilibrium point where net force is 0) exists in each interval (arr[i], arr[i+1]).
3. For each of the n-1 intervals, perform binary search (bisection) on the real coordinate x in [arr[i], arr[i+1]] to find x where net force sum 1/(x - arr[j]) = 0.
4. Terminate when |high - low| < 10^-6 or after fixed iterations (e.g. 50-100 iterations) for numerical precision.

### Complexity Analysis
- **Time Complexity:** O(n^2 * log(1/eps))
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    List<Double> nullPoints(List<Integer> arr) {

        List<Double> result = new ArrayList<>();

        int n = arr.size();

        // Find one equilibrium point between
        // every pair of consecutive magnets
        for (int i = 0; i < n - 1; i++) {

            double low = arr.get(i);
            double high = arr.get(i + 1);

            // Binary search for accurate precision
            for (int iteration = 0; iteration < 100; iteration++) {

                double mid = low + (high - low) / 2.0;

                double force = 0.0;

                // Calculate net force at mid
                for (int j = 0; j < n; j++) {

                    force += 1.0 / (mid - arr.get(j));
                }

                // Positive force means equilibrium
                // point lies towards the right
                if (force > 0) {

                    low = mid;

                } else {

                    high = mid;
                }
            }

            // Store the equilibrium point
            result.add(low + (high - low) / 2.0);
        }

        return result;
    }
}
```
