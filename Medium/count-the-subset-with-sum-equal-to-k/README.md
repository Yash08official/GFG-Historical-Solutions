# Count Subset with Sum - Limited Size

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-the-subset-with-sum-equal-to-k/1](https://www.geeksforgeeks.org/problems/count-the-subset-with-sum-equal-to-k/1)  
**Problem ID:** `912664`  
**Slug:** `count-the-subset-with-sum-equal-to-k`  
**Accepted Submission Date:** `2026-11-23 01:14:27`  

---

## Problem Statement

Given an array **arr[]** and an integer **k**, find the count of subsets whose sum is equals to k.

**Note**: Array size is small and allowed values are larger in this problem when compared to Count Subsets with Sum

**Examples:**
```text
**Input: **arr[] = [1, 3, 2], k = 3
**Output: **2
**Explanation:** The two subsets whose sum is equals to k are [1, 2] and [3].

```

```text
**Input: **arr[] = [4, 2, 3, 1, 2], k = 4
**Output: **3
**Explanation:** The three subsets whose sum is equals to k are [4], [2, 2] and [3, 1].

```

```text
**Input: **arr[] = [10, 20, 30], k = 25
**Output: **0
**Explanation:** No subsets exits with sum equals to k.
```

---

## Solution & Approach

### Approach Explanation

Meet in the Middle:
1. Divide the array of size `n` into two halves: left half `[0, mid)` and right half `[mid, n)`.
2. Generate all 2^(n/2) subset sums for the right half and store their frequencies in a hash map.
3. Traverse all 2^(n/2) subset sums for the left half, and for each left sum `s`, look up the count of complementary sums `k - s` in the hash map.
4. Accumulate and return the total count.

### Complexity Analysis
- **Time Complexity:** O(2^(n/2)) meeting in the middle
- **Auxiliary Space:** O(2^(n/2)) for the right half hash map

---

## Source Code

```java
import java.util.*;

class Solution {

    HashMap<Long, Integer> map = new HashMap<>();

    // Generate subset sums of the right half
    void generateRight(int[] arr, int index, int end, long sum) {

        if (index == end) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }

        // Include current element
        generateRight(arr, index + 1, end, sum + arr[index]);

        // Exclude current element
        generateRight(arr, index + 1, end, sum);
    }

    // Generate subset sums of the left half and find matches
    long generateLeft(int[] arr, int index, int end,
                      long sum, long k) {

        if (index == end) {
            return map.getOrDefault(k - sum, 0);
        }

        // Include current element
        long include = generateLeft(
            arr, index + 1, end, sum + arr[index], k
        );

        // Exclude current element
        long exclude = generateLeft(
            arr, index + 1, end, sum, k
        );

        return include + exclude;
    }

    public int countSubset(int[] arr, int k) {

        map.clear();

        int n = arr.length;
        int mid = n / 2;

        // Generate all subset sums of right half
        generateRight(arr, mid, n, 0);

        // Find matching subset sums from left half
        long answer = generateLeft(arr, 0, mid, 0, k);

        return (int) answer;
    }
}
```
