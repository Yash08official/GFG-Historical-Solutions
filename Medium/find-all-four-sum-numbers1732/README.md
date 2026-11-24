# 4 Sum - All Quadruples

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1](https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1)  
**Problem ID:** `702139`  
**Slug:** `find-all-four-sum-numbers1732`  
**Accepted Submission Date:** `2026-11-24 11:23:20`  

---

## Problem Statement

Given an array **arr[]** of integers and another integer **target**. You have to find all **unique **quadruples from the given array whose **sum **is equal to the given **target**.

**Note:** All the quadruples should be internally sorted, i.e for any quadruple [q1, q2, q3, q4] it should be : q1 ≤ q2 ≤ q3 ≤ q4.

**Examples :**
```text
**Input: **arr[] = [0, 0, 2, 1, 1], target = 3
**Output:** [[0, 0, 1, 2]]**
Explanation: **Sum of 0, 0, 1, 2 is equal to 3.

```

```text
**Input: **arr[] = [10, 2, 3, 4, 5, 7, 8], target = 23
**Output: **[[2, 3, 8, 10], [2, 4, 7, 10], [3, 5, 7, 8]] **
Explanation: **Sum of [2, 3, 8, 10] is 23, sum of [2, 4, 7, 10] is 23 and sum of [3, 5, 7, 8] is also 23.
```

```text
**Input: **arr[] = [0, 0, 2, 1, 1], target = 2
**Output:** [[0, 0, 1, 1]]**
Explanation: **Sum of [0, 0, 1, 1] is equal to 2.
```

---

## Solution & Approach

### Approach Explanation

Sorting & Nested Two Pointers with Deduplication:
1. Sort the array in non-decreasing order.
2. Run two outer loops fixing the first two elements `arr[i]` and `arr[j]`, skipping duplicate values.
3. Use two pointers `left = j + 1` and `right = n - 1` to find pairs matching `target - arr[i] - arr[j]`.
4. When a quadruple is found, advance both pointers while skipping adjacent identical elements to avoid duplicates.

### Complexity Analysis
- **Time Complexity:** O(n^3) where n is array length
- **Auxiliary Space:** O(1) auxiliary space (excluding result storage)

---

## Source Code

```java
import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first elements
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second elements
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) arr[i] + arr[j]
                             + arr[left] + arr[right];

                    if (sum == target) {

                        ArrayList<Integer> quad = new ArrayList<>();

                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[left]);
                        quad.add(arr[right]);

                        result.add(quad);

                        left++;
                        right--;

                        // Skip duplicate third elements
                        while (left < right &&
                               arr[left] == arr[left - 1]) {
                            left++;
                        }

                        // Skip duplicate fourth elements
                        while (left < right &&
                               arr[right] == arr[right + 1]) {
                            right--;
                        }
                    }
                    else if (sum < target) {

                        left++;
                    }
                    else {

                        right--;
                    }
                }
            }
        }

        return result;
    }
}
```
