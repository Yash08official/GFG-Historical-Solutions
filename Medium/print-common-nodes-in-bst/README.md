# Common Nodes in Two BSTs

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/print-common-nodes-in-bst/1](https://www.geeksforgeeks.org/problems/print-common-nodes-in-bst/1)  
**Problem ID:** `700500`  
**Slug:** `print-common-nodes-in-bst`  
**Accepted Submission Date:** `2026-11-13 14:42:56`  

---

## Problem Statement

Given the roots `r1` and `r2` of two Binary Search Trees (BST), find all nodes that are present in both trees i.e. the intersection nodes of the two BSTs. Return the common node values in sorted order.

**Examples:**
```text
Input: r1 = [5, 1, 10, 0, 4, 7, N, N, N, N, N, N, 9], r2 = [10, 7, 20, 4, 9, N, N]
Output: [4, 7, 9, 10]
Explanation: The values present in both BSTs are 4, 7, 9, and 10. Hence, the answer is [4, 7, 9, 10].
```
```text
Input: r1 = [10, 2, 11, 1, 3, N, N], r2 = [2, 1, 3]
Output: [1, 2, 3]
Explanation: The values 1, 2, and 3 are present in both BSTs. Hence, the answer is [1, 2, 3].
```

**Constraints:**
- $1 \le 	ext{number of nodes} \le 10^5$
- $1 \le 	ext{node}->	ext{data} \le 10^9$

---

## Solution & Approach

### Approach Explanation

Simultaneous Iterative Inorder Traversal using Two Stacks:
1. Inorder traversal of a BST visits nodes in strictly increasing (sorted) order.
2. By performing simultaneous iterative inorder traversals on both BSTs with two stacks `s1` and `s2`:
   - Push all left descendants of the current nodes `curr1` and `curr2` onto their respective stacks.
   - Peek at the top nodes `n1` from `s1` and `n2` from `s2`.
   - If `n1.data == n2.data`: a common node is found! Append it to `result`, pop both stacks, and move both pointers to their right children (`curr1 = n1.right`, `curr2 = n2.right`).
   - If `n1.data < n2.data`: the current value in BST 1 is smaller, so advance BST 1's traversal by popping `s1` and setting `curr1 = n1.right`.
   - If `n1.data > n2.data`: the current value in BST 2 is smaller, so advance BST 2's traversal by popping `s2` and setting `curr2 = n2.right`.
3. Stop when either tree's traversal is exhausted.
4. Return `result`.

### Complexity Analysis
- **Time Complexity:** O(n1 + n2) where n1 and n2 are the number of nodes in the two BSTs
- **Auxiliary Space:** O(h1 + h2) where h1 and h2 are the heights of the two BSTs

---

## Source Code

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {

        ArrayList<Integer> result = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        Node curr1 = r1;
        Node curr2 = r2;

        while ((curr1 != null || !s1.isEmpty()) &&
               (curr2 != null || !s2.isEmpty())) {

            // Push left nodes of first BST
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }

            // Push left nodes of second BST
            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.left;
            }

            Node n1 = s1.peek();
            Node n2 = s2.peek();

            if (n1.data == n2.data) {

                result.add(n1.data);

                s1.pop();
                s2.pop();

                curr1 = n1.right;
                curr2 = n2.right;

            } else if (n1.data < n2.data) {

                s1.pop();
                curr1 = n1.right;

            } else {

                s2.pop();
                curr2 = n2.right;
            }
        }

        return result;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: 6d1bb306315cf470e0c5e4e6462a8e693451cf4f0a6921dc00dc7f6fb55d5edb`)
