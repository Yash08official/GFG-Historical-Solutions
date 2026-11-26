# Earliest Common Slot

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/earliest-common-slot/1](https://www.geeksforgeeks.org/problems/earliest-common-slot/1)  
**Problem ID:** `891315`  
**Slug:** `earliest-common-slot`  
**Accepted Submission Date:** `2026-11-27 00:30:15`  

---

## Problem Statement

Given two lists of availability slots, **slots1[][]** and **slots2[][]**, for two people. Each slot is represented as** [start, end]**, and no two slots overlap within the same list. Given an integer **d** representing the required meeting duration, return the earliest common time slot having a length of at least d. If no such slot exists, return an empty array.

**Examples:**
```text
**Input: **slots1[][] = [[10, 50], [60, 120], [140, 210]], slots2[][] = [[0, 15], [60, 70]], d = 8
**Output:** [60, 68]
**Explanation: **The earliest overlapping slot is [60, 70], which is long enough for an 8-minute meeting. 
Hence, the answer is [60, 68].
```

```text
**Input: **slots1[][] = [[10, 50], [60, 120], [140, 210]], slots2[][] = [[0, 15], [60, 70]], d = 12
**Output:** []
**Explanation:** The only overlapping slot is [60, 70], whose length is 10. 
Since a 12-minute meeting cannot be scheduled, no valid slot exists.
```

**Constraints:**
1 ≤ slots1.size(), slots2.size()  ≤ 105
-109 ≤ start < end ≤ 109
1 ≤ d ≤ 106

---

## Solution & Approach

### Approach Explanation

Two-Pointer Interval Intersection:
1. Sort both availability lists slots1 and slots2 by start time.
2. Maintain two pointers i and j. Compute overlapping interval `start = Math.max(slots1[i][0], slots2[j][0])` and `end = Math.min(slots1[i][1], slots2[j][1])`.
3. If `end - start >= d`, a valid meeting slot of duration d is found: return [start, start + d].
4. Otherwise, advance the pointer of the slot that ends earlier (slots1[i][1] < slots2[j][1] ? i++ : j++).
5. If no overlapping window of duration d is found after checking all intervals, return an empty list.

### Complexity Analysis
- **Time Complexity:** O(n * log n + m * log m)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> commonSlot(int[][] slots1, int[][] slots2, int d) {

        ArrayList<Integer> result = new ArrayList<>();

        // Sort both arrays by starting time
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int j = 0;

        while (i < slots1.length && j < slots2.length) {

            // Find overlapping interval
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);

            // Check whether overlap is sufficient
            if ((long) end - start >= d) {
                result.add(start);
                result.add(start + d);
                return result;
            }

            // Move the interval that ends earlier
            if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
```
