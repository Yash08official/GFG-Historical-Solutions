# Longest Subarray with Atmost Two Distinct

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/longest-subarray-with-atmost-two-distinct-integers/1](https://www.geeksforgeeks.org/problems/longest-subarray-with-atmost-two-distinct-integers/1)  
**Problem ID:** `712123`  
**Slug:** `longest-subarray-with-atmost-two-distinct-integers`  
**Accepted Submission Date:** `2026-11-24 11:24:12`  

---

## Problem Statement

Given an array **arr[] **consisting of positive integers, your task is to find the length** **of the longest subarray that contains at most** **two distinct** **integers.

**Examples:**

```text
**Input: **arr[] = [2, 1, 2]
**Output:** 3
**Explanation**: The entire array [2, 1, 2] contains at most two distinct integers (2 and 1). Hence, the length of the longest subarray is 3.
```

```text
**Input**: arr[] = [3, 1, 2, 2, 2, 2]
**Output: **5
**Explanation**: The longest subarray containing at most two distinct integers is [1, 2, 2, 2, 2], which has a length of 5.
```

---

## Solution & Approach

### Approach Explanation

Sliding Window with Frequency Map:
1. Maintain a sliding window `[left, right]` and a frequency hash map of elements inside the window.
2. Expand `right` and increment frequency of `arr[right]`.
3. Whenever `map.size() > 2`, shrink window from `left` by decrementing frequencies until at most 2 distinct elements remain.
4. Update `maxLength = max(maxLength, right - left + 1)` at each step.

### Complexity Analysis
- **Time Complexity:** O(n) each element is processed at most twice
- **Auxiliary Space:** O(1) hash map stores at most 3 distinct keys

---

## Source Code

```java
import java.util.*;

class Solution {

    public int totalElements(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < arr.length; right++) {

            // Add current element to the window
            map.put(arr[right],
                map.getOrDefault(arr[right], 0) + 1);

            // Shrink window if distinct elements exceed 2
            while (map.size() > 2) {

                int leftElement = arr[left];

                map.put(leftElement, map.get(leftElement) - 1);

                // Remove element if its frequency becomes zero
                if (map.get(leftElement) == 0) {
                    map.remove(leftElement);
                }

                left++;
            }

            // Update maximum valid window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```
