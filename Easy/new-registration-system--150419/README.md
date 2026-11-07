# Generate Usernames

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/new-registration-system--150419/1](https://www.geeksforgeeks.org/problems/new-registration-system--150419/1)  
**Problem ID:** `881608`  
**Slug:** `new-registration-system--150419`  
**Topic Tags:** `Strings`  
**Accepted Submission Date:** `2026-11-07 10:30:16`  
**Language:** `Java`  

---

## Problem Statement

Given an array of strings `arr[]`. The array represents first names of users, generate a unique username for each entry in the order it appears.

- Initially, consider all usernames present in the input array as reserved.
- If a username has not already been assigned to any previous user, keep it unchanged.
- Otherwise, append the smallest positive integer suffix that produces a username that has not been reserved or assigned to any previous user.

Return the array of generated usernames.

### Examples

```
Input: arr[] = ["aba", "ab", "aba", "aba", "ab"]
Output: ["aba", "ab", "aba1", "aba2", "ab1"]
Explanation: The first occurrences of "aba" and "ab" are new, so they remain unchanged. The next "aba" is already used, so "aba1" is assigned. When "aba" appears again, "aba1" is already used, so "aba2" is assigned. Similarly, the second occurrence of "ab" becomes "ab1".
```

```
Input: arr[] = ["a", "a", "a1", "a"]
Output: ["a", "a2", "a1", "a3"]
Explanation: Initially, "a" and "a1" are reserved. The first occurrence of "a" retains its name. For the second occurrence, "a1" is already reserved, so the smallest available username is "a2". The original "a1" retains its name when processed. Finally, the last occurrence of "a" gets "a3".
```

```
Input: arr[] = ["aba1", "aba", "aba"]
Output: ["aba1", "aba", "aba2"]
Explanation: Initially, "aba1" and "aba" are reserved. The first occurrence of each retains its original name. For the second occurrence of "aba", "aba1" is already reserved, so "aba2" is assigned.
```

---

## Approach

- **HashSet Reservation & HashMap Suffix Tracking:**
  - First, add all strings from the input array into a `HashSet` called `used` to reserve all original names upfront.
  - Maintain a `HashMap<String, Integer> nextSuffix` to track the lowest prospective suffix number for each base name.
  - For each name in `arr[]`:
    - If it is the first time encountering this name (`!nextSuffix.containsKey(name)`), keep the original name, add it to results, and set `nextSuffix.put(name, 1)`.
    - If it has already appeared:
      - Retrieve the current suffix counter for this name.
      - Increment the suffix counter in a loop until `candidate = name + suffix` is not present in `used`.
      - Add the candidate to the results and mark it as `used`.
      - Update `nextSuffix` with `suffix + 1` for the next time this name is requested.
- **Time Complexity:** $O(n \cdot L)$ on average, where $n$ is the number of users and $L$ is the maximum length of a username string.
- **Space Complexity:** $O(n \cdot L)$ for storing strings in `HashSet` and `HashMap`.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 3c4ad0777b431d2ee41323e3547c78bf2aed7a02fbd8b01716d5a3a1fc43caf5`
