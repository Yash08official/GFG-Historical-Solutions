# Parenthesis Checker

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1](https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1)  
**Problem ID:** `701331`  
**Slug:** `parenthesis-checker2744`  
**Accepted Submission Date:** `2024-09-18 23:12:45`  
**Challenge Origin:** `Day_7` from GeekStreak 2024  

---

## Problem Statement

Given an expression string x. Examine whether the pairs and the orders of {,},(,),[,] are correct in exp.

For example, the function should return 'true' for exp = [()]{}{[()()]()} and 'false' for exp = [(]).

Note: The driver code prints "balanced" if function return true, otherwise it prints "not balanced".

Examples :

```
Input: {([])}
Output: true
Explanation: { ( [ ] ) }. Same colored brackets can form balanced pairs, with 0 number of unbalanced bracket.
```

```
Input: ([]
Output: false
Explanation: ([]. Here square bracket is balanced but the small bracket is not balanced and Hence , the output will be unbalanced.
```

Expected Time Complexity: O(|x|)
Expected Auixilliary Space: O(|x|)

Constraints:
1 ≤ |x| ≤ 105

## Solution

### Java

```java

class Solution
{
    static boolean ispar(String x)
    {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<x.length();i++){
            char ch=x.charAt(i);

            if(ch=='[' || ch=='{' || ch=='('){
                s.push(ch);
                continue;
            }

            if(s.empty())
                return false;

            if(ch==']'){
                if(s.peek()=='[')
                    s.pop();
                else
                    return false;
            }

            if(ch==')'){
                if(s.peek()=='(')
                    s.pop();
                else
                    return false;
            }

            if(ch=='}'){
                if(s.peek()=='{')
                    s.pop();
                else
                    return false;
            }

        }

        if(s.empty())
            return true;
        else
            return false;
    }
}
```

### JavaScript

```js
/**
 * @param {string} x
 * @returns {boolean}
 */
class Solution {
  // Function to check if brackets are balanced or not.
  ispar(x) {
    // Create a stack to store opening brackets
    let stack = [];

    // Iterate over each character in the string
    for (let i = 0; i < x.length; i++) {
      let ch = x.charAt(i);

      // If the character is an opening bracket, push it onto the stack
      if (ch === "[" || ch === "{" || ch === "(") {
        stack.push(ch);
        continue;
      }

      // If the stack is empty and we encounter a closing bracket, return false
      if (stack.length === 0) {
        return false;
      }

      // Check if the top of the stack matches the current closing bracket
      if (ch === "]") {
        if (stack[stack.length - 1] === "[") {
          stack.pop();
        } else {
          return false;
        }
      }

      if (ch === ")") {
        if (stack[stack.length - 1] === "(") {
          stack.pop();
        } else {
          return false;
        }
      }

      if (ch === "}") {
        if (stack[stack.length - 1] === "{") {
          stack.pop();
        } else {
          return false;
        }
      }
    }

    // If the stack is empty after iterating over the entire string, return true
    // Otherwise, return false
    return stack.length === 0;
  }
}
```

---

## Recovered Solution Files

- **[sol.java](./sol.java)** (Java) - `SHA-256: 2a2e3a03acdf8a2ac31ce0eb797766f6197205e993c513c3e045daf11398b123`
