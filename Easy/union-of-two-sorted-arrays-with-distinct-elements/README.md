# Union of Two Sorted with Distinct

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-with-distinct-elements/1](https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-with-distinct-elements/1)  
**Problem ID:** `876745`  
**Slug:** `union-of-two-sorted-arrays-with-distinct-elements`  
**Accepted Submission Date:** `2024-11-10 12:27:06`  
**Challenge Origin:** `Day_60` from GeekStreak 2024  

---

## Problem Statement

Given two sorted arrays a[] and b[], where each array contains distinct elements , the task is to return the elements in the union of the two arrays in sorted order.

Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.
**Examples:**

```bash
Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: 1 2 3 4 5 6 7
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
```

```bash
Input: a[] = [2, 3, 4, 5], b[] = [1, 2, 3, 4]
Output: 1 2 3 4 5
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.
```

```bash
Input: a[] = [1], b[] = [2]
Output: 1 2
Explanation: Distinct elements including both the arrays are: 1 2.
```

**Constraints:**
1 <= a.size(), b.size() <= 105
-109 <= a[i] , b[i] <= 109

### Solution

#### Java

```java
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> al = new ArrayList<>();
        int i=0, j=0, n=a.length, m=b.length;
        while(i<n && j<m){
            if(a[i]==b[j]){
                al.add(a[i]);
                i++;
                j++;
            }else if(a[i]<b[j]){
                al.add(a[i++]);
            }else{
                al.add(b[j++]);
            }
        }

        while(i<n)  al.add(a[i++]);
        while(j<m)  al.add(b[j++]);

        return al;
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: d238ccc5ec12bf038b4c3ce6a1d9f23d120f239a2893c6e5c83584a580e11efb`
