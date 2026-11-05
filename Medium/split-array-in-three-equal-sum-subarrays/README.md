# Split Array in Three Equal Sum Subarrays

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/split-array-in-three-equal-sum-subarrays/1](https://www.geeksforgeeks.org/problems/split-array-in-three-equal-sum-subarrays/1)  
**Problem ID:** `878150`  
**Slug:** `split-array-in-three-equal-sum-subarrays`  
**Accepted Submission Date:** `2024-11-07 11:37:44`  
**Challenge Origin:** `Day_57` from GeekStreak 2024  

---

## Problem Statement

Given an array, arr[], determine if arr can be split into three consecutive parts such that the sum of each part is equal. If possible, return any index pair(i, j) in an array such that sum(arr[0..i]) = sum(arr[i+1..j]) = sum(arr[j+1..n-1]), otherwise return an array {-1,-1}.

Note: Driver code will print true if arr can be split into three equal sum subarrays, otherwise, it is false.

Examples :

```bash
Input:  arr[] = [1, 3, 4, 0, 4]
Output: true
Explanation: [1, 2] is valid pair as sum of subarray arr[0..1] is equal to sum of subarray arr[2..3] and also to sum of subarray arr[4..4]. The sum is 4.
```

```bash
Input: arr[] = [2, 3, 4]
Output: false
Explanation: No three subarrays exist which have equal sum.
```

```bash
Input: arr[] = [0, 1, 1]
Output: false
```

Constraints:
3 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106

### Solution

#### Java

```java
{
    public List<Integer> findSplit(int[] arr) {
        int sum=Arrays.stream(arr).sum();

        if(sum%3!=0)    return Arrays.asList(-1,-1);

        int n=arr.length, cur=0, freq=0, end=-1;

        for(int i=0;i<n;i++){
            cur+=arr[i];
            if(cur==sum/3){
                if(end==-1) end=i;
                freq++;
                cur=0;
            }else if(cur>sum/3){
                return Arrays.asList(-1,-1);
            }
        }

        return Arrays.asList(0,end);
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 623008bc8aaaeed7dec6787ae5e8e5bab5be6cb62daaa1432f4260bf6a3ba201`
