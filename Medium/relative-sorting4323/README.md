# Sort According to Another Array

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/relative-sorting4323/1](https://www.geeksforgeeks.org/problems/relative-sorting4323/1)  
**Problem ID:** `701722`  
**Slug:** `relative-sorting4323`  
**Accepted Submission Date:** `2026-11-26 13:59:59`  

---

## Problem Statement

Given two integer arrays **a1[] **and **a2[]**. Sort the first array a1[]** **such that all the relative positions of the elements in the first array are the same as the elements in the second array a2[].
**Note**: If elements are repeated in the second array, consider their first occurance only. Elements not in a2[] should appear in a1[] at the end in ascending order.

**Examples :**
```text
**Input: **a1[] = [2, 1, 2, 3, 4], a2[] = [2, 1, 2]
**Output: **[2, 2, 1, 3, 4]**
Explanation: **Array elements of a1[] are sorted according to a2[]. So 2 comes first then 1 comes, now we append remaining elements of a1[] in sorted order.

```

```text
**Input: **a1[] = [4, 1, 3, 3, 2], a2[] = [3, 1]
**Output: **[3, 3, 1, 2, 4]**
Explanation: **Elements 3 and 1 come first as per a2[]. Others (2, 4) are sorted and placed after.
```

---

## Solution & Approach

### Approach Explanation

Frequency Array / Counting Sort:
1. Count frequencies of all elements in a1 using a frequency array `freq` sized up to the maximum possible element value (10^6).
2. Iterate through a2. For each element present in a1, write it into a1 according to its count in `freq` and reset count to 0.
3. Iterate through `freq` from 1 to max in ascending order to append remaining elements that did not appear in a2.

### Complexity Analysis
- **Time Complexity:** O(n + m + max(val))
- **Auxiliary Space:** O(max(val))

---

## Source Code

```java
class Solution {

    static void relativeSort(int[] a1, int[] a2) {

        int max = 1000000;

        // Store frequency of elements in a1
        int[] freq = new int[max + 1];

        for (int num : a1) {
            freq[num]++;
        }

        int index = 0;

        // Process elements according to a2
        for (int num : a2) {

            // Ignore repeated elements in a2
            if (freq[num] == 0) {
                continue;
            }

            // Add all occurrences of this element
            while (freq[num] > 0) {
                a1[index++] = num;
                freq[num]--;
            }
        }

        // Add remaining elements in ascending order
        for (int num = 1; num <= max; num++) {

            while (freq[num] > 0) {
                a1[index++] = num;
                freq[num]--;
            }
        }
    }
}
```
