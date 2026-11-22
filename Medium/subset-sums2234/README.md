# Subset Sums

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/subset-sums2234/1](https://www.geeksforgeeks.org/problems/subset-sums2234/1)  
**Problem ID:** `704723`  
**Slug:** `subset-sums2234`  
**Accepted Submission Date:** `2026-11-23 01:12:52`  

---

## Problem Statement

Given an array **`arr` **of integers, return the sums of all subsets in the list.  Return the sums in any order.

**Examples:
**
```text
**Input: **arr[] = [2, 3]
**Output: **[0, 2, 3, 5]
**Explanation: **When no elements are taken then Sum = 0. When only 2 is taken then Sum = 2. When only 3 is taken then Sum = 3. When elements 2 and 3 are taken then Sum = 2+3 = 5.
```

```text
**Input: **arr[] = [1, 2, 1]
**Output: **[0, 1, 1, 2, 2, 3, 3, 4]
**Explanation: **The possible subset sums are 0 (no elements), 1 (either of the 1's), 2 (the element 2), and their combinations.
```

```text
**Input: **arr[] = [5, 6, 7]
**Output: **[0, 5, 6, 7, 11, 12, 13, 18]
**Explanation: **The possible subset sums are 0 (no elements), 5, 6, 7, and their combinations.
```

---

## Solution & Approach

### Approach Explanation

Recursive Inclusion/Exclusion (Backtracking):
1. For each index from 0 to `arr.length - 1`, make two recursive branches:
   - Include `arr[index]` in the current running sum.
   - Exclude `arr[index]` from the current running sum.
2. When the index reaches `arr.length`, append the accumulated sum to the result list.

### Complexity Analysis
- **Time Complexity:** O(2^n) where n is the number of elements
- **Auxiliary Space:** O(n) for recursion call stack

---

## Source Code

```java
import java.util.*;

class Solution {

    public ArrayList<Integer> subsetSums(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        findSums(arr, 0, 0, result);

        return result;
    }

    private void findSums(int[] arr, int index, int sum,
                          ArrayList<Integer> result) {

        // Base case: all elements are processed
        if (index == arr.length) {
            result.add(sum);
            return;
        }

        // Choice 1: Include current element
        findSums(arr, index + 1, sum + arr[index], result);

        // Choice 2: Exclude current element
        findSums(arr, index + 1, sum, result);
    }
}
```
