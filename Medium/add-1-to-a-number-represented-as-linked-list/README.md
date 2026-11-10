# Add 1 to a Linked List Number

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1](https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1)  
**Problem ID:** `700053`  
**Slug:** `add-1-to-a-number-represented-as-linked-list`  
**Topic Tags:** `Linked List`  
**Accepted Submission Date:** `2026-11-09 17:41:56`  
**Language:** `Java`  

---

## Problem Statement

A number n is represented in a linked list such that each node contains a single digit. Add 1 to the number and return the head of the modified linked list.

### Examples

```
Input: LinkedList: 4 -> 5 -> 6
Output: 4 -> 5 -> 7
Explanation: 456 + 1 = 457.

Input: LinkedList: 9 -> 9
Output: 1 -> 0 -> 0
Explanation: 99 + 1 = 100.
```

---

## Approach

- **Reverse & Carry Addition:**
  - Reverse the linked list so least significant digit is at head.
  - Add carry = 1 to the reversed list nodes, updating `data = (data + carry) % 10` and `carry = (data + carry) / 10`.
  - If carry remains after the last node, append a new node with value `carry`.
  - Reverse the list back to restore original orientation.
- **Time Complexity:** $O(n)$ three linear passes.
- **Space Complexity:** $O(1)$ in-place list modification.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 29a6d61f46ce6be46bcf97ad72c4441ceeb276701f16f5d0dc023542d50fffa3`
