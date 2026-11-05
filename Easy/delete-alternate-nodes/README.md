# Delete Alternate Nodes

**Difficulty:** `Easy`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/delete-alternate-nodes/1](https://www.geeksforgeeks.org/problems/delete-alternate-nodes/1)  
**Problem ID:** `700584`  
**Slug:** `delete-alternate-nodes`  
**Accepted Submission Date:** `2024-10-13 22:23:35`  
**Challenge Origin:** `Day_31` from GeekStreak 2024  

---

## Problem Statement

Given a Singly Linked List, Delete all alternate nodes of the list ie delete all the nodes present in even positions.

Examples :

```bash
Input: LinkedList: 1->2->3->4->5->6
 
Output: 1->3->5

Explanation: Deleting alternate nodes ie 2, 4, 6 results in the linked list with elements 1->3->5.
```

<img src = "./1.png">
<img src = "./2.png">

```bash
Input: LinkedList: 99->59->42->20
 
Output: 99->42
```
<img src = "./3.png">
<img src = "./4.png">

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= number of nodes <= 105
1 <= node->data <= 103

### Solution 
#### Java
```java
class Solution {
    public void deleteAlt(Node head) {
        Node cur = head;
        while(cur!=null && cur.next!=null){
            cur.next = cur.next.next;
            cur = cur.next;
        }
    }
}
```

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: fdb5e9f13ef32e691d10ff69949b64f59f0c3dedd12cd3b515350f889e5fe4d6`
