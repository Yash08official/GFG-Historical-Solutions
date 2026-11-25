# Two Repeated Elements

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/two-repeated-elements-1587115621/1](https://www.geeksforgeeks.org/problems/two-repeated-elements-1587115621/1)  
**Problem ID:** `701227`  
**Slug:** `two-repeated-elements-1587115621`  
**Accepted Submission Date:** `2026-11-25 09:49:53`  

---

## Problem Statement

You are given an integer array **arr** of size **n+2**. All elements of the array are in the range from 1 to **n**. Also, all elements occur once except two numbers which occur twice. Find the two repeating numbers.
**Note: **Return the numbers in their order of appearing twice. So, if **x** and **y** are repeating numbers, and **x**'s second appearance comes before the second appearance of **y**, then the order should be (**x**, **y**).

**Examples:**
```text
**Input: **n = 4, arr[] = [1, 2, 1, 3, 4, 3]
**Output: **[1, 3]**
Explanation: **In the given array, 1 and 3 are repeated two times, and as 1's second appearance occurs before 2's second appearance, so the output should be 1 3.
```

```text
**Input: **n = 2, arr[] = [1, 2, 2, 1]
**Output: **[2, 1]**
Explanation: **In the given array, 1 and 2 are repeated two times and second occurence of 2 comes before 1. So the output is 2 1.

```

**Constraints: **
2 ≤ n ≤ 105
1 ≤ arr[i] ≤ n

---

## Solution & Approach

### Approach Explanation

Hash Set Membership Tracking:
1. Iterate through `arr[]` and attempt to add each number into a `HashSet`.
2. If `set.add(num)` returns `false`, `num` is seen for the second time; record it in the result array in order of second appearance.
3. Terminate as soon as both repeating elements are identified.

### Complexity Analysis
- **Time Complexity:** O(n) linear scan
- **Auxiliary Space:** O(n) for hash set

---

## Source Code

```java
import java.util.*;

class Solution {

    public int[] twoRepeated(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        int[] result = new int[2];
        int index = 0;

        for (int num : arr) {

            // If the number is already present,
            // this is its second occurrence.
            if (!set.add(num)) {

                result[index] = num;
                index++;

                // We found both repeating numbers.
                if (index == 2) {
                    break;
                }
            }
        }

        return result;
    }
}
```
