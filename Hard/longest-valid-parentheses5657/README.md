# Longest Valid Parentheses Substring

**Difficulty:** `Hard`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/longest-valid-parentheses5657/1](https://www.geeksforgeeks.org/problems/longest-valid-parentheses5657/1)  
**Problem ID:** `705195`  
**Slug:** `longest-valid-parentheses5657`  
**Accepted Submission Date:** `2024-09-16 02:31:09`  
**Challenge Origin:** `Day_5` from GeekStreak 2024  

---

## Problem Statement

Given a string str consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

A parenthesis string is valid if:

    For every opening parenthesis, there is a closing parenthesis.
    Opening parenthesis must be closed in the correct order.

Examples :

```
Input: str = ((()
Output: 2
Explaination: The longest valid parenthesis substring is "()".
```

```
Input: str = )()())
Output: 4
Explaination: The longest valid parenthesis substring is "()()".
```

Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 ≤ |str| ≤ 105

## Solution :

### Java

```
class Solution {
    static int maxLength(String S) {
        int open = 0, close = 0, res = 0;
        for(int i = 0; i < S.length(); i++){
            if (S.charAt(i) == '(') open ++;
            else close++;
            if(open == close) res = Math.max(res, open + close);
            else if (close > open) open = 0; close = 0;
        }

        open = 0; close = 0;
        for(int i = S.length() - 1; i >= 0; i--){
            if  (S.charAt(i) == '(') open++;
            else close++;
            if(open == close) res = Math.max(res, open + close);
            else if(close < open) open = 0; close = 0;
        }
        return res;
    }
}
```

### JavaScript

```
/**
 * @param {string} str
 * @returns {number}
 */

class Solution {
    maxLength(str) {
        let open = 0, close = 0, res = 0;
        for(let i = 0; i < str.length; i++){
            if (str[i] === '(') open ++;
            else close++;
            if(open === close) res = Math.max(res, open + close);
            else if (close > open) open = 0, close = 0;
        }

        open = 0, close = 0;
        for(let i = str.length - 1; i >= 0; i--){
            if  (str[i] === '(') open++;
            else close++;
            if(open === close) res = Math.max(res, open + close);
            else if(close < open) open = 0, close = 0;
        }
        return res;
    }
}
```

---

## Recovered Solution Files

- **[sol.java](./sol.java)** (Java) - `SHA-256: b3ed52e835d5679253eb43704f87aaf334d80b2bb78d088bceeaee0bacb99d34`
- **[sol.js](./sol.js)** (JavaScript) - `SHA-256: 698df7ce91bcacf1825aad911f43b880606f810b3afffc315805296ef6b85ad7`
