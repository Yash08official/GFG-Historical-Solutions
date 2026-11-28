# Prefix Suffix Strings

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/prefix-suffix-string--170647/1](https://www.geeksforgeeks.org/problems/prefix-suffix-string--170647/1)  
**Problem ID:** `714218`  
**Slug:** `prefix-suffix-string--170647`  
**Accepted Submission Date:** `2026-11-28 10:58:45`  

---

## Problem Statement

Given two arrays of strings, **s1[] **and **s2[]**, count the number of strings in s2[] that occur as either a prefix** **or a suffix of at least one string in s1[]. 

**Examples :**
```text
**Input: **s1 = ["cat", "catanddog", "lion"], s2 = ["cat", "dog", "rat"]
**Output:** 2
**Explanation:** 
"cat" from s2 is a prefix of "**cat**anddog" in s1.
"dog" from s2 is a suffix of "catand**dog**" in s1.
"rat" is neither a prefix nor a suffix of any string in s1.
Therefore, the count is 2.

```

```text
**Input:** s1 = ["jrjiml", "tchetn", "ucrhye", "ynayhy", "cuhffd", "cvgpoiu", "znyadv"]
s2 = ["jr", "ml", "cvgpoi", "gpoiu", "wnmkmluc", "geheqe", "uglxagyl", "uyxdroj"] 
**Output: **4**
Explanation:** 
"jr" is a prefix of "**jr**jiml" in s1.
"ml" is a suffix of "jrji**ml**" in s1.
"cvgpoi" is a prefix of "**cvgpoi**u" in s1.
"gpoiu" is a suffix of "cv**gpoiu**" in s1.
The remaining strings in s2 are neither prefixes nor suffixes of any string in s1.
Therefore, the count is 4.
```

---

## Solution & Approach

### Approach Explanation

Prefix and Suffix Hash Sets:
1. For every string in `s1`, generate all possible prefixes and suffixes and store them into two hash sets `prefixes` and `suffixes`.
2. For each word in `s2`, check if it exists in either `prefixes` or `suffixes`.
3. Increment count for each valid match and return total count.

### Complexity Analysis
- **Time Complexity:** O(sum |s1_i|^2 + sum |s2_j|)
- **Auxiliary Space:** O(sum |s1_i|^2)

---

## Source Code

```java
import java.util.*;

class Solution {
    public int countPrefixSuffix(String[] s1, String[] s2) {
        HashSet<String> prefixes = new HashSet<>();
        HashSet<String> suffixes = new HashSet<>();

        // Store all prefixes and suffixes of strings in s1
        for (String word : s1) {
            for (int i = 1; i <= word.length(); i++) {
                prefixes.add(word.substring(0, i));
                suffixes.add(word.substring(word.length() - i));
            }
        }

        int count = 0;

        // Check each string in s2
        for (String word : s2) {
            if (prefixes.contains(word) || suffixes.contains(word)) {
                count++;
            }
        }

        return count;
    }
}
```
