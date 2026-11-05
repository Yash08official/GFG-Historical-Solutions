# Middle of Linked List

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1](https://www.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1)  
**Problem ID:** `700171`  
**Slug:** `finding-middle-element-in-a-linked-list`  
**Accepted Submission Date:** `2024-09-12 22:29:45`  
**Challenge Origin:** `Day_1` from GeekStreak 2024  

---

## Problem Statement

Given the head of a linked list, the task is to find the middle. For example, the middle of 1-> 2->3->4->5 is 3. If there are two middle nodes (even count), return the second middle. For example, middle of 1->2->3->4->5->6 is 4.

Examples:

Input: Linked list: 1->2->3->4->5
Output: 3

<img src = "./1.png">

Explanation: The given linked list is 1->2->3->4->5 and its middle is 3.

Input: Linked list: 2->4->6->7->5->1
Output: 7

<img src = "./2.png">

Explanation: The given linked list is 2->4->6->7->5->1 and its middle is 7.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= no. of nodes <= 105

## Solution :

```java

class Solution {
    /* Should return data of middle node. If linked list is empty, then  -1*/
    getMiddle(node) {
        let slow = head;
        let fast = head;
        while(fast !== null && fast.next !== null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
```

## JavaScript
```javaScript

class Solution {
    /* Should return data of middle node. If linked list is empty, then  -1*/
    getMiddle(node) {
        let slow = head;
        let fast = head;
        while(fast !== null && fast.next !== null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
```

---

## Recovered Solution Files

- **[sol.java](./sol.java)** (Java) - `SHA-256: 8ff3a1f122247130ee23c208f938d77c3e1d9f898fb6c820dca56c4080765057`
- **[sol.js](./sol.js)** (JavaScript) - `SHA-256: ec1c6f7d9941c6d5359d21b70e59dc64958556d47c244acd1bda961bbd729fb3`
