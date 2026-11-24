# Two Pairs with Same Sum

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/satisfy-the-equation5847/1](https://www.geeksforgeeks.org/problems/satisfy-the-equation5847/1)  
**Problem ID:** `705546`  
**Slug:** `satisfy-the-equation5847`  
**Accepted Submission Date:** `2026-11-24 01:42:37`  

---

## Problem Statement

Given an array **arr[]** of positive integers, find four indices **a**, **b**, **c**, and **d** such that arr[a] + arr[b] = arr[c] + arr[d], where a, b, c, d are all distinct indices.
- If multiple such quadruplets exist, return the one that is lexicographically smallest when the indices are considered in the order a, b, c, d. 
- If no such quadruplet exists, return {-1, -1, -1, -1}.  
- Ensure a < b and c < d, and the pair (a, b) is lexicographically smaller than the pair (c, d).

**Examples:**
```text
**Input: **arr[] = [3, 4, 7, 1, 2, 9, 8]**
Output: **[0, 2, 3, 5]**
Explanation: **arr[0] + arr[2] = 3 + 7 = 10, arr[3] + arr[5] = 1 + 9 = 10. 
This is the lexicographically smallest such quadruplet of indices.
```

```text
**Input: **arr[] = [1, 2, 3, 3]**
Output: **[-1, -1, -1, -1]**
Explanation: **No two distinct pairs of indices produce the same sum.
```

---

## Solution & Approach

### Approach Explanation

Hash Map Grouping & Lexicographical Search:
1. Iterate over all pairs `(i, j)` with `i < j` in lexicographical order and map their sum to a list of pair indices `[i, j]`.
2. Iterate through candidate first pairs `(a, b)` with `a < b` in lexicographical order.
3. For each candidate pair, retrieve the precomputed list of pairs matching `arr[a] + arr[b]`.
4. Scan the matching pairs for the earliest pair `(c, d)` such that `(c, d)` appears after `(a, b)` and all four indices `a, b, c, d` are distinct.
5. The first valid quadruplet encountered is guaranteed to be lexicographically smallest.

### Complexity Analysis
- **Time Complexity:** O(n^2) to generate and check pair sums
- **Auxiliary Space:** O(n^2) for the pair sum hash map

---

## Source Code

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;

        HashMap<Long, ArrayList<int[]>> map = new HashMap<>();

        // Store every pair grouped by its sum.
        // Pairs are inserted in lexicographical order.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = (long) arr[i] + arr[j];

                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new int[]{i, j});
            }
        }

        // Try first pairs in lexicographical order.
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {

                long sum = (long) arr[a] + arr[b];

                ArrayList<int[]> pairs = map.get(sum);

                // Find the earliest later pair with the same sum.
                for (int[] pair : pairs) {
                    int c = pair[0];
                    int d = pair[1];

                    // Ensure (a,b) comes before (c,d).
                    if (c < a || (c == a && d <= b)) {
                        continue;
                    }

                    // All four indices must be distinct.
                    if (a != c && a != d &&
                        b != c && b != d) {

                        ArrayList<Integer> result = new ArrayList<>();

                        result.add(a);
                        result.add(b);
                        result.add(c);
                        result.add(d);

                        return result;
                    }
                }
            }
        }

        return new ArrayList<>(
            Arrays.asList(-1, -1, -1, -1)
        );
    }
}
```
