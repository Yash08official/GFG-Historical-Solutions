# Rotate and Delete

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/rotate-and-delete-1587115621/1](https://www.geeksforgeeks.org/problems/rotate-and-delete-1587115621/1)  
**Problem ID:** `701204`  
**Slug:** `rotate-and-delete-1587115621`  
**Accepted Submission Date:** `2024-10-02 15:56:09`  
**Challenge Origin:** `Day_21` from GeekStreak 2024  

---

## Problem Statement

Given an array arr integers. Assume sz to be the initial size of the array. Do the following operations exactly sz/2 times. In every kth (1<= k <= sz/2 ) operation:

- Right-rotate the array clockwise by 1.
- Delete the (n– k + 1)th element from begin.

Now, Return the first element of the array.

Note: Here n keeps on decreasing with every operation.

Examples:

```bash
Input: arr = [1, 2, 3, 4, 5, 6]
Output: 3
Explanation: Rotate the array clockwise i.e. after rotation the array A = {6, 1, 2, 3, 4, 5} and delete the last element that is {5} that will be A = {6, 1, 2, 3, 4}. Again rotate the array for the second time and deletes the second last element that is {2} that will be A = {4, 6, 1, 3}, doing similar operation when we perform 4th operation, 4th last element does not exist. Then we deletes 1st element ie {1} that will be A = {3, 6}. So, continuing this procedure the last element in A is {3}. So, the output will be 3.
```

```bash

Input: arr = [1, 2, 3, 4]
Output: 2
Explanation: Rotate the vector clockwise i.e. after rotation the vector arr = [4, 1, 2, 3] and delete the last element that is 3 that will be arr = [4, 1, 2]. After doing all the operations, the output will be 2.
```

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 103
1 <= arr[i] <= 106

## Solution

### Java

```java
import java.util.ArrayList;

class Solution {
    public static int rotateDelete(ArrayList<Integer> arr) {
        // Initial size of the array
        int n = arr.size();
        // Initially k = 1, which keeps track of the delete step
        int k = 1;

        // While loop: continue until only one element is left in the array
        while (n > 1) {
            // Rotate: Remove the last element and add it to the front
            arr.add(0, arr.remove(n - 1));

            // Calculate the index to delete: (n - k)
            int id = n - k;

            // If the calculated index is negative, set it to 0 to avoid an invalid index
            if (id < 0) id = 0;

            // Remove the element at the calculated index
            arr.remove(id);

            // Increment k to move to the next step
            k++;

            // Decrease the size of the array after the deletion
            n--;
        }

        // Return the last remaining element in the array
        return arr.get(0);
    }
}
```

### JavaScript

```js
// User function Template for javascript
class Solution {
  rotateDelete(arr) {
    // initial size of the array
    let n = arr.length;
    // initially k = 1 which keeps track of the deletion step
    let k = 1;

    // while loop: continue until only one element is left in the array
    while (n > 1) {
      // Rotate: Remove the last element and add it to the front
      arr.unshift(arr.pop());

      // Calculate the index to delete: (n - k)
      let id = n - k;

      // If the calculated index is negative, set it to 0 to avoid an invalid index
      if (id < 0) id = 0;

      // Remove the element at the calculated index
      arr.splice(id, 1);

      // Increment k to move to the next step
      k++;

      // Decrease the size of the array after the deletion
      n--;
    }

    // Return the last remaining element in the array
    return arr[0];
  }
}
```

---

## Recovered Solution Files

- **[sol.js](./sol.js)** (JavaScript) - `SHA-256: 8ed738c15b42c5c6b0e61caeaceea481b569c54ecbb52a94e6a7a6480e9efd89`
- **[solution.java](./solution.java)** (Java) - `SHA-256: f8a022ecfd5564befd72fa073914b1b7f929932df09e8f3123315ca79a72e51a`
