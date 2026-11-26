# Marks from Ranks

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-marks-from-ranks/1](https://www.geeksforgeeks.org/problems/find-marks-from-ranks/1)  
**Problem ID:** `702846`  
**Slug:** `find-marks-from-ranks`  
**Accepted Submission Date:** `2026-11-26 14:04:35`  

---

## Problem Statement

Consider an input where all marks obtained are divided into intervals of consecutive numbers** **represented as **l[]** and **r[] **where l[i] and r[i] represent the starting and ending marks (inclusive) of the i-th interval. 

- The intervals are sorted in increasing order and do not overlap. 

- The rank of a mark is defined by its position among all valid marks in increasing order, with the smallest mark assigned rank 1, the next smallest rank 2, and so on.

Given an array **rank[]**. for each value in rank[], find the corresponding mark and return as an array.

**Examples:**

```text
**Input: **l[] = [1, 6, 14], r[] = [3, 9, 15], rank[] = [2, 5, 8]**
Output: **[2, 7, 14]**
Explanation: **The valid marks are 1, 2, 3, 6, 7, 8, 9, 14, 15. Their corresponding ranks are 1 to 9 as there are 9 distinct marks. Therefore, rank 2 corresponds to mark 2, rank 5 corresponds to mark 7, and rank 8 corresponds to mark 14.
```

```text
**Input: **l[] = [5, 10], r[] = [7, 12], rank[] = [1, 4, 6]**
Output: **[5, 10, 12]**
Explanation: **The valid marks are 5, 6, 7, 10, 11, 12. Their corresponding ranks are 1 to 6 in increasing order. Hence, rank 1 corresponds to mark 5, rank 4 corresponds to mark 10, and rank 6 corresponds to mark 12.
```

---

## Solution & Approach

### Approach Explanation

Prefix Sum of Interval Lengths with Binary Search:
1. Given n non-overlapping intervals [l[i], r[i]], the number of marks in the i-th interval is r[i] - l[i] + 1.
2. Build a prefix sum array `prefix` where `prefix[i]` stores the cumulative total number of marks across intervals 0 through i.
3. For each query rank k, perform binary search on `prefix` to locate the interval containing the k-th rank.
4. Calculate the offset within that interval: `offset = k - prefix[interval - 1] - 1`. The answer mark is l[interval] + offset.

### Complexity Analysis
- **Time Complexity:** O(n + q * log n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {

        int n = l.length;

        // Store cumulative number of valid marks
        long[] prefix = new long[n];

        for (int i = 0; i < n; i++) {

            long count = (long) r[i] - l[i] + 1;

            prefix[i] = count;

            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        // Process each requested rank
        for (int k : rank) {

            int low = 0;
            int high = n - 1;

            // Find the first interval whose prefix count >= k
            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Invalid rank
            if (low == n) {
                answer.add(-1);
                continue;
            }

            // Marks counted before this interval
            long previousCount = (low == 0) ? 0 : prefix[low - 1];

            // Position inside the selected interval
            long offset = k - previousCount - 1;

            int mark = (int) (l[low] + offset);

            answer.add(mark);
        }

        return answer;
    }
}
```
