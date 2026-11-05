# Minimum Increments to Make Distinct

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/make-array-elements-unique--170645/1](https://www.geeksforgeeks.org/problems/make-array-elements-unique--170645/1)  
**Problem ID:** `713145`  
**Slug:** `make-array-elements-unique--170645`  
**Accepted Submission Date:** `2024-11-11 11:06:08`  
**Challenge Origin:** `Day_61` from GeekStreak 2024  

---

## Problem Statement

Given an array arr[ ], your task is to find the minimum number of increment operations required to make all the elements of the array unique. i.e.- no value in the array should occur more than once. In one operation, a value can be incremented by 1 only.

**Examples :**

```bash
Input: arr[] = [1, 2, 2]
Output: 1
Explanation: If we increase arr[2] by 1 then the resulting array becomes {1, 2, 3} and has all unique values.Hence, the answer is 1 in this case.
```

```bash
Input: arr[] = [1, 1, 2, 3]
Output: 3
Explanation: If we increase arr[0] by 3, then all array elements will be unique. Hence, the answer is 3 in this case.
```

```bash
Input: arr[] = [5, 4, 3, 2, 1]
Output: 0
Explanation: All elements are unique.
```

**Constraints:**
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106

### Solution

#### Java

```java
class Solution {
    public int minIncrements(int[] arr) {
        Arrays.sort(arr);
        int prev=arr[0], ans=0, n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]<=prev){
                ans+=(prev-arr[i]+1);
                prev++;
            }else{
                prev=arr[i];
            }
        }
        return ans;
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 7accbeb4d72f67bcfad3cd76071d95dd314efb9342a30654bfae036644c88616`
