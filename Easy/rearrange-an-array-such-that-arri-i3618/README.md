# Rearrange to Make arr[i] = i

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/rearrange-an-array-such-that-arri-i3618/1](https://www.geeksforgeeks.org/problems/rearrange-an-array-such-that-arri-i3618/1)  
**Problem ID:** `703115`  
**Slug:** `rearrange-an-array-such-that-arri-i3618`  
**Accepted Submission Date:** `2024-10-11 23:14:08`  
**Challenge Origin:** `Day_29` from GeekStreak 2024  

---

## Problem Statement

Given an array of elements arr[] with indices ranging from 0 to arr.size() - 1, your task is to write a program that rearranges the elements of the array such that arr[i] = i. If an element i is not present in the array, -1 should be placed at the corresponding index.

Examples:

```bash
Input: arr[] = [-1, -1, 6, 1, 9, 3, 2, -1, 4, -1]
Output: [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
Explanation: Here We can see there are 10 elements. So, the sorted array will look like [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] but in our array we are not having 0, 5, 7 and 8. So, at there places we will be printing -1 and otherplaces will be having elements.
```

```bash
Input: arr[] = [2, 0, 1]
Output: [0, 1, 2]
Explanation: Here We can see all the elements are present so no -1 is returned in array.
```

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
0 ≤ arr.size() ≤ 105
-1 ≤ arr[i] ≤ arr.size()-1

### Solution

### java

```java
class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        int i=0, n=arr.size();
        while(i<n){
            if(arr.get(i)==-1 || arr.get(i)==i) i++;
            else{
                int id = arr.get(i);
                arr.set(i,arr.get(id));
                arr.set(id,id);
            }
        }
        return arr;
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 25d8b0574b8b710b71b2e4942969f815ee02093afc8b20f8aa30e759da851f3e`
