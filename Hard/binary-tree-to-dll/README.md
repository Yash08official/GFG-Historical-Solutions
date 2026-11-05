# Binary Tree  to DLL

**Difficulty:** `Hard`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1](https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1)  
**Problem ID:** `700144`  
**Slug:** `binary-tree-to-dll`  
**Accepted Submission Date:** `2024-09-15 17:11:46`  
**Challenge Origin:** `Day_4` from GeekStreak 2024  

---

## Problem Statement

Given a Binary Tree (BT), convert it to a Doubly Linked List (DLL) in place. The left and right pointers in nodes will be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be the same as the order of the given Binary Tree. The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.

Note: h is the tree's height, and this space is used implicitly for the recursion stack.

<img src = "./1.png">

Examples:

```
Input:
      1
    /  \
   3    2
Output:
3 1 2 
2 1 3
```

<img src = "./2.png">

Explanation: DLL would be 3<=>1<=>2

```
Input:
       10
      /   \
     20   30
   /   \
  40   60
Output:
40 20 60 10 30 
30 10 60 20 40
```

<img src = "./3.png">

Explanation:  DLL would be 40<=>20<=>60<=>10<=>30.

Expected Time Complexity: O(no. of nodes)
Expected Space Complexity: O(height of the tree)

Constraints:
1 ≤ Number of nodes ≤ 105
0 ≤ Data of a node ≤ 105

---

## Recovered Solution Files

- **[sol.java](./sol.java)** (Java) - `SHA-256: cb054db5bd36b88f07dd6e7b796d339bcbe0a857b371ff1b2fe543cc0db32add`
- **[sol.js](./sol.js)** (JavaScript) - `SHA-256: a76eca006c7b1550f7bc05dc087a0e3f8b3f5c81dc8e61d2d0f0b9c4bf780050`
