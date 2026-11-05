# Longest Prefix Suffix

**Difficulty:** `Hard`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1](https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1)  
**Problem ID:** `703402`  
**Slug:** `longest-prefix-suffix2527`  
**Accepted Submission Date:** `2024-09-22 02:22:46`  
**Challenge Origin:** `Day_11` from GeekStreak 2024  

---

## Problem Statement

Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

NOTE: Prefix and suffix can be overlapping but they should not be equal to the entire string.

Examples :

```
Input: str = "abab"
Output: 2
Explanation: "ab" is the longest proper prefix and suffix.
```

```
Input: str = "aaaa"
Output: 3
Explanation: "aaa" is the longest proper prefix and suffix.
```

Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 ≤ |str| ≤ 106
str contains lower case English alphabets

## Solution

### JavaScript

```js
/**
 * @param {string} str
 * @returns {number}
 */
class Solution {
  lps(str) {
    // Initialize variables
    let n = str.length;
    let a = new Array(n).fill(0);
    let j = 0;

    // Iterate through the string
    for (let i = 1; i < n; ) {
      // If characters match, update the lps array and move both pointers
      if (str.charAt(i) === str.charAt(j)) {
        a[i] = j + 1;
        j++;
        i++;
      } else {
        // If characters don't match and j is not at the start, move j to the previous lps value
        if (j === 0) {
          i++;
        } else {
          j = a[j - 1];
        }
      }
    }

    // Return the last value in the lps array
    return a[n - 1];
  }
}
```

### Java

```java
class Solution {
    int lps(String str) {
        int n=str.length();
        int a[] = new int[n];
        int j=0;
        for(int i=1;i<n;){
            if(str.charAt(i)==str.charAt(j)){
                a[i]=j+1;
                j++;
                i++;
            }else{
                if(j==0)    i++;
                else    j=a[j-1];
            }
        }
        return a[n-1];
    }
}
```

---

## Recovered Solution Files

- **[sol.java](./sol.java)** (Java) - `SHA-256: accd6a6493dd35b8e31901abe86e41b08787804818bd414b8fcba24edda6e361`
- **[sol.js](./sol.js)** (JavaScript) - `SHA-256: e3d77da1d74f075b311849ca18e9b1a742f97a6b48c309f02b3c662db76f8a7a`
