# Police and Thieves

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1](https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1)  
**Problem ID:** `705822`  
**Slug:** `police-and-thieves--141631`  
**Accepted Submission Date:** `2026-11-24 11:22:33`  

---

## Problem Statement

Given an array **arr[]**, where each element contains either a **'P'** for policeman or a **'T'** for thief. Find the maximum number of thieves** **that can be caught by the police with the following conditions :
- Each policeman can catch only one thief.
- A policeman cannot catch a thief who is more than **k** units away from him.

**Examples:**
```text
**Input: **arr[] = ['P', 'T', 'T', 'P', 'T'], k = 1
**Output:** 2
**Explanation:** Maximum 2 thieves can be caught. First policeman catches first thief and second police man can catch either second or third thief.
```

```text
**Input: **arr[] = ['T', 'T', 'P', 'P', 'T', 'P'], k = 2
**Output:** 3
**Explanation: **Maximum 3 thieves can be caught.
```

---

## Solution & Approach

### Approach Explanation

Greedy Two-Pointer Catching:
1. Maintain pointer `i` for policemen ('P') and pointer `j` for thieves ('T').
2. Advance each pointer to the next available policeman and thief respectively.
3. If `|i - j| <= k`, policeman `i` catches thief `j`; increment count and advance both pointers.
4. If `i < j`, policeman `i` is too far to the left to catch thief `j` (and any subsequent thief); advance `i`.
5. If `j < i`, thief `j` is too far to the left to be caught by policeman `i` (and any subsequent policeman); advance `j`.

### Complexity Analysis
- **Time Complexity:** O(n) linear scan
- **Auxiliary Space:** O(1) constant auxiliary space

---

## Source Code

```java
class Solution {

    public int catchThieves(char[] arr, int k) {

        int n = arr.length;

        int i = 0;
        int j = 0;

        int caught = 0;

        while (i < n && j < n) {

            // Find the next policeman
            while (i < n && arr[i] != 'P') {
                i++;
            }

            // Find the next thief
            while (j < n && arr[j] != 'T') {
                j++;
            }

            // If either pointer reaches the end
            if (i == n || j == n) {
                break;
            }

            // Check whether they are within distance k
            if (Math.abs(i - j) <= k) {

                caught++;

                // Both are used, so move both pointers
                i++;
                j++;
            }
            else if (i < j) {

                // Policeman is too far left
                i++;
            }
            else {

                // Thief is too far left
                j++;
            }
        }

        return caught;
    }
}
```
