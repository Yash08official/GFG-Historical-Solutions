# Rotate by 90 degree

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1](https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1)  
**Problem ID:** `701267`  
**Slug:** `rotate-by-90-degree-1587115621`  
**Accepted Submission Date:** `2024-11-05 23:13:50`  
**Challenge Origin:** `Day_55` from GeekStreak 2024  

---

## Problem Statement

Given a square mat[][]. The task is to rotate it by 90 degrees in clockwise direction without using any extra space.

**Examples:**

```bash
Input: mat[][] = [[1 2 3], [4 5 6], [7 8 9]]
Output:
7 4 1
8 5 2
9 6 3
```

```bash
Input: mat[][] = [1 2], [3 4]
Output:
3 1
4 2
```

```bash
Input: mat[][] = [[1]]
Output:
1
```

Constraints:
1 ≤ mat.size() ≤ 1000
1 <= mat[][] <= 100

### Solution

#### Java

```java
class GFG
{
    static void rotate(int matrix[][])
    {
        int n=matrix.length;
        int l=0, r=n-1;

        //rotation (inside sq.)
        for(int op=0;op<n/2;op++){

            for(int i=l;i<r;i++){

                int top_left=matrix[l][i];
                int top_right=matrix[i][r];
                int bottom_left=matrix[n-1-i][l];
                int bottom_right=matrix[n-1-l][n-1-i];

                matrix[l][i]=bottom_left;
                matrix[i][r]=top_left;
                matrix[n-1-l][n-1-i]=top_right;
                matrix[n-1-i][l]=bottom_right;

            }

            l++;
            r--;

        }
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 4d30bd8b2b2abbf13ea2347864357361366c637e90748f3b0241796a731fd9a6`
