# Smallest Subarray GCD

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/smallest-sub-array4107/1](https://www.geeksforgeeks.org/problems/smallest-sub-array4107/1)  
**Problem ID:** `703326`  
**Slug:** `smallest-sub-array4107`  
**Accepted Submission Date:** `2026-11-26 11:01:55`  

---

## Problem Statement

Givenn an array **arr[] **and** **an integer **k **, find the length of the minimum subarray whose Greatest Common Divisor equals **k**.

**Note:** If no such subarray exists, return -1.

**Examples:**
```text
**Input: **arr[] = [6, 9, 7, 10, 12, 24, 36, 27], k = 3
**Output:** 2
**Explanation:** GCD of subarray {6,9} is 3. GCD of subarray {24, 36, 27} is also 3,but {6, 9} is the smallest.
```

```text
**Input: **arr[] = [9, 12, 15, 24, 36, 27], k = 2
**Output:** -1
**Explanation:** GCD 2 is not possible from any subarray from the given array.
```

```text
**Input: **arr[] = [1, 2, 4, 8], k = 1
**Output:** 1
```

**Constraints:**
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105
1 ≤ k ≤ 100

---

## Solution & Approach

### Approach Explanation

Dynamic Subarray GCD Tracking:
1. Maintain a list `prev` of pairs `(gcd_val, min_len)` representing unique GCD values of subarrays ending at index `i-1`. Since GCD is monotonically non-increasing and divides previous values, the number of distinct GCDs for subarrays ending at any index is at most O(log(max(arr))).
2. For each element `arr[i]`, start a new subarray `[arr[i]]` with length 1.
3. Extend all previous subarrays ending at `i-1` by computing `gcd(pair[0], arr[i])` with length `pair[1] + 1`.
4. Merge adjacent entries with identical GCDs keeping the minimal length.
5. Check if any subarray has GCD equal to `k`, updating the minimum answer length.

### Complexity Analysis
- **Time Complexity:** O(n * log^2(max(arr)))
- **Auxiliary Space:** O(log(max(arr)))

---

## Source Code

```java
import java.util.*;

class Solution {

    // Calculate GCD using Euclid's algorithm
    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // Add a GCD and its subarray length.
    // Merge consecutive entries having the same GCD.
    private void add(ArrayList<int[]> list, int g, int len) {

        int size = list.size();

        if (size > 0 && list.get(size - 1)[0] == g) {

            list.get(size - 1)[1] =
                Math.min(list.get(size - 1)[1], len);

        } else {

            list.add(new int[]{g, len});
        }
    }

    int findSmallestSubArr(int[] arr, int k) {

        int n = arr.length;

        int answer = Integer.MAX_VALUE;

        // GCD and minimum length of subarrays
        // ending at the previous index
        ArrayList<int[]> prev = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            ArrayList<int[]> curr = new ArrayList<>();

            // Subarray containing only arr[i]
            add(curr, arr[i], 1);

            // Extend all subarrays ending at i-1
            for (int[] pair : prev) {

                int newGcd = gcd(pair[0], arr[i]);

                int newLength = pair[1] + 1;

                add(curr, newGcd, newLength);
            }

            // Check whether any subarray has GCD = k
            for (int[] pair : curr) {

                if (pair[0] == k) {

                    answer = Math.min(answer, pair[1]);
                }
            }

            prev = curr;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
```
