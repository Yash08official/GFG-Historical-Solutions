# Minimize the Heights

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1](https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1)  
**Problem ID:** `703444`  
**Slug:** `minimize-the-heights3351`  
**Accepted Submission Date:** `2024-09-17 03:21:48`  
**Challenge Origin:** `Day_6` from GeekStreak 2024  

---

## Problem Statement

Given an array arr[] denoting heights of N towers and a positive integer K.

For each tower, you must perform exactly one of the following operations exactly once.

Increase the height of the tower by K
Decrease the height of the tower by K

Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem here.
Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

Examples :

```
Input: k = 2, arr[] = {1, 5, 8, 10}
Output: 5
Explanation: The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between the largest and the smallest is 8-3 = 5.
```

```
Input: k = 3, arr[] = {3, 9, 12, 16, 20}
Output: 11
Explanation: The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference between the largest and the smallest is 17-6 = 11.
```

Expected Time Complexity: O(n\*logn)
Expected Auxiliary Space: O(n)

Constraints
1 ≤ k ≤ 107
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ 107

## Solution : JavaScript

```javaScript

/**
 * @param {number[]} arr
 * @param {number} k
 * @returns {number}
 */

class Solution {
    // Function to get the minimum difference between the heights.
    getMinDiff(arr, k) {
        arr.sort((a, b) => a - b);
        let n = arr.length;
        let ans = arr[n - 1] - arr[0];

        for (let i = 1; i < n; i++) {
            // 0 to i-1 value inc.
            // i to n-1 value dec.

            // before dec check if it is still stays +ve
            if (arr[i] - k < 0) continue;

            let min = Math.min(arr[0] + k, arr[i] - k);
            let max = Math.max(arr[i - 1] + k, arr[n - 1] - k);

            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
```

## Solution : Java

```java
class Solution {
    int getMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int ans = arr[n-1] - arr[0];

        for(int i=1;i<n;i++){
            //0 to i-1 value inc.
            //i to n-1 value dec.

            //before dec check if it is still stays +ve
            if(arr[i]-k<0)  continue;

            int min = Math.min(arr[0]+k, arr[i]-k);
            int max = Math.max(arr[i-1]+k, arr[n-1]-k);

            ans = Math.min(ans, max-min);
        }
        return ans;
    }
}
```

---

## Recovered Solution Files

- **[sol.js](./sol.js)** (JavaScript) - `SHA-256: a482e882c8a36b0a329f8a3ce1bda22714c53c84d21a76b9201e4e6d45faab02`
- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 99044419de4534db636e1a294d1e4d01e34a18aa6b169f2a393fbc3b89d51d4d`
