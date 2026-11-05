# Ways to Split into 2 with Same XOR

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/split-the-array0238/1](https://www.geeksforgeeks.org/problems/split-the-array0238/1)  
**Problem ID:** `702780`  
**Slug:** `split-the-array0238`  
**Accepted Submission Date:** `2024-10-21 23:00:07`  
**Challenge Origin:** `Day_39` from GeekStreak 2024  

---

## Problem Statement

Given an array arr[] of integers, the task is to count the number of ways to split given array elements into two non-empty subsets such that the XOR of elements of each group is equal. Each element should belong to exactly one subset.
Note:

- The answer could be very large so print it by doing modulo with 109 + 7.
- Subsets with the same elements but derived from different indices are different.
  Examples:

```bash
Input : arr[] = [1, 2, 3]
Output : 3
Explanation: {(1),(2, 3)}, {(2),(1, 3)}, {(3),(1, 2)} are three ways with equal XOR value of two groups.
```

```bash
Input : arr[] = [5, 2, 3, 2]
Output : 0
Explanation: No way to split into  two groups whose XOR is equal.
```

```bash
Input : arr[] = [2, 2, 2, 2]
Output : 7
Explanation: There are 7 ways to split the array into two groups with equal XOR, such that there are multiple combinations of {(2), (2,2,2)},{(2,2),(2,2)}.
```

Constraints:
1<=arr.size()<=106
1<=arr[i]<=106

### Solution

#### Java

```java
class Solution {
    public static int countgroup(int arr[]) {
        int xor=0, n=arr.length;
        for(int i:arr)  xor^=i;
        if(xor!=0)  return 0;
        return (1<<(n-1))-1;
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 6858d44ecf52bd1ec386526ddf0e571aff1aa5e9460c22009c33ce1ae888a7a1`
