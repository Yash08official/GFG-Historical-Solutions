# Max Sum of 2 Smallest Across Subarrays

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/1](https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/1)  
**Problem ID:** `702877`  
**Slug:** `max-sum-in-sub-arrays0824`  
**Accepted Submission Date:** `2024-10-12 22:31:48`  
**Challenge Origin:** `Day_30` from GeekStreak 2024  

---

## Problem Statement

Given an array of integers arr, the task is to find and return the maximum sum of the smallest and second smallest element among all possible subarrays of size greater than one. If it is not possible, then return -1.

Examples:

```bash
Input: arr = [4, 3, 1, 5, 6]
Output: 11
Explanation: Subarrays with smallest and second smallest are,
Subarray: [4, 3], smallest = 3, second smallest = 4, sum = 7
Subarray: [4, 3, 1], smallest = 1, second smallest = 3, sum = 4
Subarray: [4, 3, 1, 5], smallest = 1, second smallest = 3, sum = 4
Subarray: [4, 3, 1, 5, 6], smallest = 1, second smallest = 3, sum = 4
Subarray: [3, 1], smallest = 1, second smallest = 3, sum = 4
Subarray: [3, 1, 5], smallest = 1, second smallest = 3, sum = 4
Subarray: [3, 1, 5, 6], smallest = 1, second smallest = 3, sum = 4
Subarray: [1, 5], smallest = 1, second smallest = 5, sum = 6
Subarray: [1, 5, 6] ,smallest = 1, second smallest = 5, sum = 6
Subarray: [5, 6], smallest = 5, second smallest = 6, sum = 11
Maximum sum among all above choices is, 5 + 6 = 11, hence the answer is 11.
```

```bash
Input: arr = [1]
Output: -1
Explanation: Here the size of array is 1, but we need minimum 2 elements. Hence, the answer is -1.
```

Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraints:
1<=arr.size()<=105
1<=arr[i]<=105

### Solution

#### Java

```java
class Solution {
    public int pairWithMaxSum(int[] arr) {
        int n = arr.length;
        if(n==1)    return -1;

        int ans=0;
        for(int i=0;i<n-1;i++){
            int cur = arr[i]+arr[i+1];
            ans = Math.max(ans,cur);
        }
        return ans;
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 02b1e500f4eb3e9e4b3a0b66e128bafddcc04fda332b7e143d5a7f15947a2a4c`
- **[Solution.js](./Solution.js)** (JavaScript) - `SHA-256: b43ba23336f61fa8c7eb7c04124c9af0c0ff3e3fb97d1efea431bbea9ff7bee6`
