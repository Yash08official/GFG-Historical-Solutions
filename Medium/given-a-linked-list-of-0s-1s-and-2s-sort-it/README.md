# Sort Linked List of 0s, 1s and 2s

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1](https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1)  
**Problem ID:** `700028`  
**Slug:** `given-a-linked-list-of-0s-1s-and-2s-sort-it`  
**Accepted Submission Date:** `2026-11-12 09:43:45`  

---

## Problem Statement

Given a linked list where nodes can contain values 0s, 1s, and 2s only, rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

**Examples:**
```text
Input: head = 1 -> 2 -> 2 -> 1 -> 2 -> 0 -> 2 -> 2
Output: 0 -> 1 -> 1 -> 2 -> 2 -> 2 -> 2 -> 2
Explanation: All the 0s are segregated to the beginning followed by 1s and then 2s.
```
```text
Input: head = 2 -> 2 -> 0 -> 1
Output: 0 -> 1 -> 2 -> 2
```

**Constraints:**
- $1 \le 	ext{number of nodes} \le 10^5$
- $0 \le 	ext{node}->	ext{data} \le 2$

---

## Solution & Approach

### Approach Explanation

Three-Way Partitioning with Dummy Nodes:
1. Initialize three dummy heads: `zeroDummy`, `oneDummy`, and `twoDummy` with pointers `zero`, `one`, `two`.
2. Traverse the list node by node:
   - If node data is 0, append to `zero` list.
   - If node data is 1, append to `one` list.
   - If node data is 2, append to `two` list.
3. Link the three sublists:
   - Connect `zero` list to `oneDummy.next` (if 1s exist), else directly to `twoDummy.next`.
   - Connect `one` list to `twoDummy.next`.
   - Terminate the end of `two` list with `null`.
4. Return `zeroDummy.next`.

### Complexity Analysis
- **Time Complexity:** O(n) where n is the number of nodes in the linked list
- **Auxiliary Space:** O(1) auxiliary space (modifying existing node pointers in-place)

---

## Source Code

```java
class Solution {
    public Node segregate(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Dummy nodes for three lists
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        Node zero = zeroDummy;
        Node one = oneDummy;
        Node two = twoDummy;

        Node curr = head;

        // Distribute nodes into separate lists
        while (curr != null) {

            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            }
            else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            }
            else {
                two.next = curr;
                two = two.next;
            }

            curr = curr.next;
        }

        // Connect all three lists
        zero.next = (oneDummy.next != null)
                    ? oneDummy.next
                    : twoDummy.next;

        one.next = twoDummy.next;

        two.next = null;

        return zeroDummy.next;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: 13a802beb4462c0eed9668cd3a62760a2c664906a4eda0e5bc3c6eae07c5928b`)
