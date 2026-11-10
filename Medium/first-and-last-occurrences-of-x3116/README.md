# First and Last in Sorted

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1](https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1)  
**Problem ID:** `703459`  
**Slug:** `first-and-last-occurrences-of-x3116`  
**Topic Tags:** `Arrays`, `Binary Search`  
**Accepted Submission Date:** `2026-11-09 17:44:09`  
**Language:** `Java`  

---

## Problem Statement

Given a sorted array arr[] with possibly duplicate elements, find the first and last occurrences of an element x in the given array. Return [-1, -1] if not found.

### Examples

```
Input: arr[] = [1, 3, 5, 5, 5, 5, 67, 123, 125], x = 5
Output: [2, 5]
Explanation: First occurrence of 5 is at index 2 and last occurrence is at index 5.

Input: arr[] = [1, 3, 5, 5, 5, 5, 7, 123, 125], x = 7
Output: [6, 6]
```

---

## Approach

- **Binary Search (Two Passes):**
  - Pass 1 (First Occurrence): When `arr[mid] == x`, record `first = mid` and search left (`high = mid - 1`).
  - Pass 2 (Last Occurrence): When `arr[mid] == x`, record `last = mid` and search right (`low = mid + 1`).
- **Time Complexity:** $O(\log n)$ two binary search passes.
- **Space Complexity:** $O(1)$ constant auxiliary space.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 61336b13f898e1f6a8e35a53d8f4037c1b789c1bcb5a75437c74e20731d4e233`
