# Any Duplicate Within K Distance

**Difficulty:** Easy  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/kth-distance3757/1](https://www.geeksforgeeks.org/problems/kth-distance3757/1)  
**Problem ID:** 702982  
**Slug:** kth-distance3757  
**Latest Accepted Submission Date:** 2026-11-11 10:13:21  
**Historical Solve Date:** 2024-11-02 13:24:02  
**Challenge Origin:** Day_52 from GeekStreak 2024  

---

## Problem Statement

Given an unsorted array rr and a number k which is smaller than the size of the array. Find if the array contains any duplicate within k distance.

**Examples:**

`	ext
Input: arr[] = [1, 2, 3, 4, 1, 2, 3, 4] and k = 3
Output: false
Explanation: All duplicates are more than k distance away.
`

`	ext
Input: arr[] = [1, 2, 3, 1, 4, 5] and k = 3
Output: true
Explanation: 1 is repeated at distance 3.
`

### Constraints:
-  \le arr.size() \le 10^6$
-  \le k < arr.size()$
-  \le arr[i] \le 10^5$

---

## Solutions

### Approach 1: Reverse Traversal with HashMap

Traverse the array from right to left, storing elements and their latest encountered index in a HashMap. If an element is re-encountered at an index difference $\le k$, return 	rue.

- **Time Complexity:** (n)$
- **Auxiliary Space:** (n)$

`java
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
`

### Approach 2: Sliding Window with HashSet

Maintain a sliding window of size at most $ using a HashSet. For each element, if it already exists in the set, a duplicate within $ distance is found. When the window exceeds $, remove the element that slipped out of the window (rr[i - k]).

- **Time Complexity:** (n)$
- **Auxiliary Space:** (k)$

`java
import java.util.*;

class Solution {

    public boolean checkWithinK(int[] arr, int k) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            // Check whether duplicate exists
            if (set.contains(arr[i])) {
                return true;
            }

            // Add current element
            set.add(arr[i]);

            // Maintain window of size k
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }

        return false;
    }
}
`

---

## Solution Files

- **[Solution.java](./Solution.java)** (Java - Approach 1: HashMap) — SHA-256: c4ebdbd10e208634becb27e502e727ff6ef1f2408bee9e53119cb698d79e4e95
- **[solution2.java](./solution2.java)** (Java - Approach 2: Sliding Window) — SHA-256: b67a0b265a3493d340d407ceed77c6a919324c1fdec907d40a8aa08779c56975
