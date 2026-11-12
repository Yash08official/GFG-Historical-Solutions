# Cycle Length in Linked List

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/find-length-of-loop/1](https://www.geeksforgeeks.org/problems/find-length-of-loop/1)  
**Problem ID:** `700620`  
**Slug:** `find-length-of-loop`  
**Accepted Submission Date:** `2026-11-12 09:41:10`  

---

## Problem Statement

Given the head of a linked list, return the length of the loop (cycle) present in the list. If there is no loop, return `0`.

**Examples:**
```text
Input: LinkedList: 25 -> 14 -> 19 -> 33 -> 10 -> 21 -> 39 -> 90 -> 58 -> 45 (connected to node at index 4)
Output: 7
Explanation: The loop is 10 -> 21 -> 39 -> 90 -> 58 -> 45 -> 10 of length 7.
```
```text
Input: LinkedList: 1 -> 2 -> 3 -> 4 -> 5 (no loop)
Output: 0
```

**Constraints:**
- $1 \le 	ext{number of nodes} \le 10^5$
- $1 \le 	ext{node}->	ext{data} \le 10^5$

---

## Solution & Approach

### Approach Explanation

Floyd's Cycle-Finding Algorithm (Tortoise and Hare):
1. Use two pointers, `slow` and `fast`, both starting at `head`.
2. Move `slow` by 1 step and `fast` by 2 steps.
3. If `fast == null` or `fast.next == null`, no cycle exists; return `0`.
4. If `slow == fast`, a cycle is detected.
5. To find the length of the cycle, keep `slow` stationary and traverse forward with a pointer `temp = slow.next`, counting steps until `temp == slow`.
6. Return `count`.

### Complexity Analysis
- **Time Complexity:** O(n) where n is the number of nodes in the linked list
- **Auxiliary Space:** O(1) auxiliary space

---

## Source Code

```java
class Solution {

    public int lengthOfLoop(Node head) {

        Node slow = head;
        Node fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {

                // Step 2: Count cycle length
                int count = 1;

                Node temp = slow.next;

                while (temp != slow) {

                    count++;

                    temp = temp.next;
                }

                return count;
            }
        }

        // No cycle found
        return 0;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: d3d7bb99458ba3442e0a9939e616d10cfeade1905c9ac0597b8904df505b7e24`)
