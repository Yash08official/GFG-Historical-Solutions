# Duplicate Rows in Binary Matrix

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-duplicate-rows-in-a-binary-matrix/1](https://www.geeksforgeeks.org/problems/find-duplicate-rows-in-a-binary-matrix/1)  
**Problem ID:** `706337`  
**Slug:** `find-duplicate-rows-in-a-binary-matrix`  
**Accepted Submission Date:** `2026-11-28 10:57:33`  

---

## Problem Statement

Given a boolean matrix **mat[][]**, where each element is either **0** or **1**, identify all rows that are duplicates of a previously occurring row. 

Return the **0-based** indices of such rows in the order they occur.

**Examples:**
```text
**Input: **mat[][] = [[1, 0], [1, 0]]
**Output: **[1]
**Explanation: **Row 1 is duplicate of Row 0.
```

```text
**Input: **mat[][] = [[1, 0, 0], [1, 0, 0], [0, 0, 0], [0, 0, 0]]
**Output: **[1, 3]
**Explanation: **Row 1 and Row 3 are duplicates of Row 0 and 2 respectively.
```

```text
**Input: **mat[][] = [[1, 1], [0, 0], [0, 0], [1, 1], [1, 1]]
**Output: **[2, 3, 4]
**Explanation: **Row 2 is a duplicate of row 1, and rows 3 and 4 are duplicates of row 0.

```

**Constraints:**
1 ≤ n, m ≤ 103
0 ≤ mat[i][j] ≤ 1

---

## Solution & Approach

### Approach Explanation

Row Serialization with Hash Set / Bitmask:
1. Traverse matrix rows from index 0 to r - 1.
2. Serialize each row into a string (or integer bitmask for up to 64 columns).
3. Use a hash set `seen` to detect duplicates. If the serialized representation has already been seen, add the row index to the result; otherwise insert into `seen`.

### Complexity Analysis
- **Time Complexity:** O(r * c)
- **Auxiliary Space:** O(r * c)

---

## Source Code

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> repeatedRows(int[][] mat) {

        ArrayList<Integer> result = new ArrayList<>();

        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < mat.length; i++) {

            StringBuilder row = new StringBuilder();

            // Convert the current row into a string.
            for (int j = 0; j < mat[i].length; j++) {
                row.append(mat[i][j]);
            }

            String currentRow = row.toString();

            // Check whether this row appeared before.
            if (seen.contains(currentRow)) {
                result.add(i);
            } else {
                seen.add(currentRow);
            }
        }

        return result;
    }
}
```
