# Remove Duplicates from Array

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/remove-duplicates-in-small-prime-array/1](https://www.geeksforgeeks.org/problems/remove-duplicates-in-small-prime-array/1)  
**Problem ID:** `700258`  
**Slug:** `remove-duplicates-in-small-prime-array`  
**Accepted Submission Date:** `2024-10-28 10:08:26`  
**Challenge Origin:** `Day_46` from GeekStreak 2024  

---

## Problem Statement

Given an array arr consisting of positive integers numbers, remove all duplicates numbers.

Example:

```bash
Input: arr[] = [2, 2, 3, 3, 7, 5]
Output: [2, 3, 7, 5]
Explanation: After removing the duplicates 2 and 3 we get 2 3 7 5.
```

```bash
Input: arr[] = [2, 2, 5, 5, 7, 7]
Output: [2, 5, 7]
Explanation: After removing the duplicates 2, 5 and 7 we get 2 5 7.
```

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1<= arr.size() <=106
2<=arr[i]<=100

### Solution

#### Java

```java
class Solution {
    // Method to remove duplicates from the array and return the result in an ArrayList
    ArrayList<Integer> removeDuplicate(int arr[]) {

        // Initialize an ArrayList to store the result without duplicates
        ArrayList<Integer> ans = new ArrayList<>();

        // Boolean array to keep track of visited elements
        // Assuming the array contains elements in the range 0 to 100
        boolean vis[] = new boolean[101];

        // Iterate through each element in the input array
        for (int i : arr) {
            // Check if the element has not been visited before
            if (!vis[i]) {
                // If not visited, add it to the result list
                ans.add(i);

                // Mark this element as visited to avoid adding it again
                vis[i] = true;
            }
        }

        // Return the result list containing unique elements
        return ans;
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 400264a07da1c3f9e06d3b317b158a9ac30b237beac1d90251ab0c5d2dbf312a`
