# Max Distance Between Same

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/max-distance-between-same-elements/1](https://www.geeksforgeeks.org/problems/max-distance-between-same-elements/1)  
**Problem ID:** `700402`  
**Slug:** `max-distance-between-same-elements`  
**Accepted Submission Date:** `2024-10-10 11:50:46`  
**Challenge Origin:** `Day_28` from GeekStreak 2024  

---

## Problem Statement

Given an array arr[] with repeated elements, the task is to find the maximum distance between two occurrences of an element.

Note: You may assume that every input array has repetitions.

Examples:

```bash
Input: arr = [1, 1, 2, 2, 2, 1]
Output: 5
Explanation: distance for 1 is: 5-0 = 5, distance for 2 is : 4-2 = 2, So max distance is 5.
```

```bash
Input: arr = [3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2]
Output: 10
Explanation: maximum distance for 2 is 11-1 = 10, maximum distance for 1 is 4-2 = 2 ,maximum distance for 4 is 10-5 = 5, So max distance is 10.
```

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(n)

Constraints:
1 <= arr.size() <= 106
1 <= arr[i] <= 109

### Solution

#### Java

```java
class Solution {
    public int maxDistance(int[] arr) {

        // Use of map here first
        Map<Integer,Integer> map  = new HashMap<>();

        // we need to find length of arr and index (ans) is 0
        int n  =arr.length, ans=0;

        // we need a for loop now
        for(int i=0;i<n;i++){

            // if element present or map contains the element
            if(map.containsKey(arr[i])){

                // current index - previous index present in map
                int diff = i-map.get(arr[i]);
                // update the answer
                ans=  Math.max(ans,diff);
            }else{

                //if not present then add current element with index
                map.put(arr[i],i);
            }
        }
        return ans;
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 5f5331b52549291344a27d6dfe1a9e03bf2403f32da53197df920f353d3294b7`
- **[Solution.js](./Solution.js)** (JavaScript) - `SHA-256: cc1112072893be06ba60a32fbb99dda0fd4f1ec6667a8d8915f0be6025926f42`
