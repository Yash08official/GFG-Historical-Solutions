# Range Vowel Count Queries Static

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/range-vowel-count-queries-static/1](https://www.geeksforgeeks.org/problems/range-vowel-count-queries-static/1)  
**Problem ID:** `935230`  
**Slug:** `range-vowel-count-queries-static`  
**Accepted Submission Date:** `2026-11-22 19:19:01`  

---

## Problem Statement

Given a string **s** and a 2d array **queries[][]**, where each query consists of two integers **l** and **r**, return an array where each element represents the number of vowels in the substring s[l...r] (inclusive).

**Examples:**
```text
**Input: **s = "geeksforgeeks", queries[][] = [[1, 3], [2, 4], [1, 9]] 
**Output: **[2, 1, 4]
**Explanation:
**Query 1: "eek" has 2 vowels (e, e). 
Query 2: "eks" has 1 vowel (e). 
Query 3: "eeksforge" has 4 vowels (e, e, o, e).
```

```text
**Input:** s = "hello world", queries[][] = [[0, 4], [6, 10], [0, 10]]
**Output:** [2, 1, 3]
**Explanation:**
Query 1: "hello" has 2 vowels (e, o).
Query 2: "world" has 1 vowel (o).
Query 3: "hello world" has 3 vowels (e, o, o).
```

---

## Solution & Approach

### Approach Explanation

Prefix Sum Array for O(1) Range Queries:
1. Precompute a prefix sum array `prefix` of length `n`, where `prefix[i]` holds the total number of vowels in substring `s[0...i]`.
2. For each query `[l, r]`:
   - If `l == 0`, answer is `prefix[r]`.
   - Else, answer is `prefix[r] - prefix[l - 1]`.
3. Collect and return the answers for all queries.

### Complexity Analysis
- **Time Complexity:** O(N + Q) where N is string length and Q is number of queries
- **Auxiliary Space:** O(N) for prefix sum array

---

## Source Code

```java
import java.util.*;

class Solution {

    public ArrayList<Integer> countVowels(String s, int[][] queries) {

        int n = s.length();

        int[] prefix = new int[n];

        // Build prefix sum array
        for (int i = 0; i < n; i++) {

            int isVowel = isVowel(s.charAt(i)) ? 1 : 0;

            if (i == 0) {
                prefix[i] = isVowel;
            } else {
                prefix[i] = prefix[i - 1] + isVowel;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Process each query
        for (int[] query : queries) {

            int l = query[0];
            int r = query[1];

            int count;

            if (l == 0) {
                count = prefix[r];
            } else {
                count = prefix[r] - prefix[l - 1];
            }

            result.add(count);
        }

        return result;
    }

    // Check whether character is a vowel
    private boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' ||
               ch == 'i' || ch == 'o' ||
               ch == 'u';
    }
}
```
