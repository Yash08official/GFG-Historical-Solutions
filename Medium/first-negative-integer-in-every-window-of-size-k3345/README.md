# First Negative in Windows of Size K

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1](https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1)  
**Problem ID:** `703375`  
**Slug:** `first-negative-integer-in-every-window-of-size-k3345`  
**Accepted Submission Date:** `2026-11-27 00:15:05`  

---

## Problem Statement

Given an array **arr[] ** and a positive integer **k**, find the first negative integer for each and every window(contiguous subarray) of size **k.**

**Note:** If a window does not contain a negative integer, then return 0 for that window.

**Examples:**
```text
**Input: **arr[] = [-8, 2, 3, -6, 10] , k = 2
**Output: **[-8, 0, -6, -6]
**Explanation:**
Window [-8, 2] First negative integer is -8.
Window [2, 3] No negative integers, output is 0.
Window [3, -6] First negative integer is -6.
Window [-6, 10] First negative integer is -6.

```

```text
**Input: **arr[] = [12, -1, -7, 8, -15, 30, 16, 28] , k = 3
**Output: **[-1, -1, -7, -15, -15, 0] 
**Explanation:
**Window [12, -1, -7] First negative integer is -1.
Window [-1, -7, 8] First negative integer is -1.
Window [-7, 8, -15] First negative integer is -7.
Window [8, -15, 30] First negative integer is -15.
Window [-15, 30, 16] First negative integer is -15.
Window [30, 16, 28] No negative integers, output is 0.

```

```text
**Input: **arr[] = [12, 1, 3, 5] , k = 3
**Output: **[0, 0] 
**Explanation:
**Window [12, 1, 3] No negative integers, output is 0.
Window [1, 3, 5] No negative integers, output is 0.
```

---

## Solution & Approach

### Approach Explanation

Sliding Window with Deque:
1. Maintain a double-ended queue dq storing indices of negative numbers within the current sliding window.
2. Iterate i from 0 to n - 1:
   - If arr[i] < 0, push index i to the back of dq.
   - Remove elements from the front of dq whose indices fall outside the window (index <= i - k).
   - Once the window reaches size k (i >= k - 1): if dq is empty, record 0; otherwise record arr[dq.peekFirst()].

### Complexity Analysis
- **Time Complexity:** O(n)
- **Auxiliary Space:** O(k)

---

## Source Code

```java
import java.util.*;

class Solution {

    static List<Integer> firstNegInt(int arr[], int k) {

        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            // Step 1: Store index if current element is negative
            if (arr[i] < 0) {
                dq.addLast(i);
            }

            // Step 2: Remove negative elements outside the window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // Step 3: Process window once its size becomes k
            if (i >= k - 1) {

                if (dq.isEmpty()) {
                    result.add(0);
                } else {
                    result.add(arr[dq.peekFirst()]);
                }
            }
        }

        return result;
    }
}
```
