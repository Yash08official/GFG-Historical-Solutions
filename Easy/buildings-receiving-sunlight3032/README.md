# Buildings with Sunlight

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/buildings-receiving-sunlight3032/1](https://www.geeksforgeeks.org/problems/buildings-receiving-sunlight3032/1)  
**Problem ID:** `702686`  
**Slug:** `buildings-receiving-sunlight3032`  
**Accepted Submission Date:** `2024-09-20 00:25:53`  
**Challenge Origin:** `Day_9` from GeekStreak 2024  

---

## Problem Statement

Given an array height representing the heights of buildings. You have to count the buildings that will see the sunrise (Assume the sun rises on the side of the array starting point).
Note: The height of the building should be strictly greater than the height of the buildings left in order to see the sun.

<img src = "./Building.png">

Examples :

```
Input: height = [7, 4, 8, 2, 9]
Output: 3
Explanation: As 7 is the first element, it can see the sunrise. 4 can't see the sunrise as 7 is hiding it. 8 can see. 2 can't see the sunrise. 9 also can see
the sunrise.
```

```
Input: height = [2, 3, 4, 5]
Output: 4
Explanation: As 2 is the first element, it can see the sunrise.  3 can see the sunrise as 2 is not hiding it. Same for 4 and 5, they also can see the sunrise.
```

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ height.size() ≤ 106
1 ≤ heighti ≤ 108

## Solution

### Java

```java
class Solution {
    public int countBuildings(int[] height) {
        int prev = -1, ans=0;
        for(int i:height){
            if(i>prev){
                ans++;
                prev=i;
            }
        }
        return ans;
    }
}
```

### JavaScript

```js
/**
 * @param {number[]} height
 * @returns {number}
 */

class Solution {
  // Returns count buildings that can see sunlight
  countBuildings(height) {
    let prev = -1,
      ans = 0;
    for (let i of height) {
      if (i > prev) {
        ans++;
        prev = i;
      }
    }
    return ans;
  }
}
```

---

## Recovered Solution Files

- **[sol.java](./sol.java)** (Java) - `SHA-256: 2dcb71d4065111924de9f4d6ccec346e46decbc46d5279e5a2c4f50502a649d4`
- **[sol.js](./sol.js)** (JavaScript) - `SHA-256: b142a0c2a70a6cead29bb70c57df7fd18a13e3032d79fa6ee1eac7c76708bcfb`
