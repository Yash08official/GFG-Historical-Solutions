# At Least K Occurrences

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/first-element-to-occur-k-times5150/1](https://www.geeksforgeeks.org/problems/first-element-to-occur-k-times5150/1)  
**Problem ID:** `703319`  
**Slug:** `first-element-to-occur-k-times5150`  
**Topic Tags:** `Arrays`, `Hash`  
**Accepted Submission Date:** `2026-11-10 09:17:50`  
**Language:** `Java`  

---

## Problem Statement

Given an array `arr[]` and an integer `k`, find the first element that occurs at least `k` times in the array. 

If multiple elements satisfy the condition, return the element whose `k`-th occurrence appears earliest in the array. If no element occurs at least `k` times, return -1.

### Examples

```
Input: arr[] = [1, 7, 4, 3, 4, 8, 7], k = 2
Output: 4
Explanation: Both 7 and 4 occur twice. However, 4 reaches its second occurrence before 7, so the answer is 4.
```

```
Input: arr[] = [3, 1, 3, 4, 5, 1, 3, 3, 5, 4], k = 3
Output: 3
Explanation: The element 3 is the only element that occurs at least 3 times in the array.
```

```
Input: arr[] = [10, 8, 2], k = 10
Output: -1
Explanation: No element occurs at least 10 times in the array.
```

---

## Approach

- **HashMap Frequency Counting with Early Return:**
  - Traverse `arr[]` from left to right while maintaining a `HashMap<Integer, Integer> map` storing the frequency of each element encountered so far.
  - Increment the frequency `freq = map.getOrDefault(arr[i], 0) + 1` and update the map.
  - As soon as `freq == k` for any element, return `arr[i]` immediately.
  - Early returning guarantees that if multiple elements occur $k$ times, the one whose $k$-th occurrence appears earliest is returned.
  - If the loop finishes without any element reaching $k$ occurrences, return `-1`.
- **Time Complexity:** $O(n)$ single pass over the array with $O(1)$ average hash map lookups.
- **Space Complexity:** $O(n)$ to store distinct elements in the hash map.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 089151027f72743badcad7d9a79fed287bf40718391080899f8d97f86a068395`
