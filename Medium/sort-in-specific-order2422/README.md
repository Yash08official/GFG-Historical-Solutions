# Sort in Specific Order

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/sort-in-specific-order2422/1](https://www.geeksforgeeks.org/problems/sort-in-specific-order2422/1)  
**Problem ID:** `702996`  
**Slug:** `sort-in-specific-order2422`  
**Accepted Submission Date:** `2026-11-19 18:24:39`  

---

## Problem Statement

Given an array `arr[]` of non-negative integers. Sort them so that the first part of the array contains odd numbers sorted in descending order, and the rest contains even numbers sorted in ascending order.

**Examples:**
```text
Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
Output: [7, 5, 3, 1, 2, 4, 10]
Explanation: 7, 5, 3, 1 are odd numbers in descending order and 2, 4, 10 are even numbers in ascending order.
```
```text
Input: arr[] = [0, 4, 5, 3, 7, 2, 1]
Output: [7, 5, 3, 1, 0, 2, 4]
Explanation: 7, 5, 3, 1 are odd numbers in descending order and 0, 2, 4 are even numbers in ascending order.
```

**Constraints:**
- $1 \le 	ext{arr.size()} \le 10^5$
- $0 \le 	ext{arr}[i] \le 10^9$

---

## Solution & Approach

### Approach Explanation

Partition & Dual Sorting:
1. Traverse the array and partition elements into two auxiliary lists: `odd` and `even`.
2. Sort the `odd` list in descending order using `Collections.sort(odd, Collections.reverseOrder())`.
3. Sort the `even` list in ascending order using `Collections.sort(even)`.
4. Overwrite `arr[]` with the sorted odd numbers followed by the sorted even numbers.

### Complexity Analysis
- **Time Complexity:** O(n log n) where n is the number of elements in arr[]
- **Auxiliary Space:** O(n) auxiliary space for storing separated odd and even numbers

---

## Source Code

```java
import java.util.*;

class Solution {

    public void sortIt(int[] arr) {

        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        // Separate odd and even numbers
        for (int num : arr) {

            if (num % 2 != 0) {
                odd.add(num);
            } else {
                even.add(num);
            }
        }

        // Sort odd numbers in descending order
        Collections.sort(odd, Collections.reverseOrder());

        // Sort even numbers in ascending order
        Collections.sort(even);

        // Put odd numbers first
        int index = 0;

        for (int num : odd) {
            arr[index++] = num;
        }

        // Put even numbers after odd numbers
        for (int num : even) {
            arr[index++] = num;
        }
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: d98dc27973281142029a48a8397bfb1cee0de513d970a3f4a35fd399c1359287`)
