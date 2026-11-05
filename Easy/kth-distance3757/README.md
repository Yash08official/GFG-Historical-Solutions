# Any Duplicate Within K Distance

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/kth-distance3757/1](https://www.geeksforgeeks.org/problems/kth-distance3757/1)  
**Problem ID:** `702982`  
**Slug:** `kth-distance3757`  
**Accepted Submission Date:** `2024-11-02 13:24:02`  
**Challenge Origin:** `Day_52` from GeekStreak 2024  

---

## Problem Statement

Given an unsorted array arr and a number k which is smaller than size of the array. Find if the array contains any duplicate within k distance.

**Examples:**

```bash
Input: arr[] = [1, 2, 3, 4, 1, 2, 3, 4] and k = 3
Output: false
Explanation: All duplicates are more than k distance away.
```

```bash
Input: arr[] = [1, 2, 3, 1, 4, 5] and k = 3
Output: true
Explanation: 1 is repeated at distance 3.
```

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ k < arr.size()
1 ≤ arr[i] ≤ 105

### Solution

#### Java

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {

        // Initialize a HashMap to store elements and their latest index
        Map<Integer, Integer> map = new HashMap<>();

        int n = arr.length;

        // Traverse the array in reverse to check each element's distance from its duplicate
        for (int i = n - 1; i >= 0; i--) {
            // Check if the current element is already in the map
            if (map.containsKey(arr[i])) {
                // Get the index of the previous occurrence of the current element
                int x = map.get(arr[i]);

                // If the difference between indices is less than or equal to k, return true
                if (x - i <= k) {
                    return true;
                }
            }
            // Update the map with the current element's index
            map.put(arr[i], i);
        }
        // If no duplicates are found within k distance, return false
        return false;
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: c4ebdbd10e208634becb27e502e727ff6ef1f2408bee9e53119cb698d79e4e95`
