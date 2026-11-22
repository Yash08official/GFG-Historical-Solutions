# Children Sum in a Binary Tree

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/children-sum-parent/1](https://www.geeksforgeeks.org/problems/children-sum-parent/1)  
**Problem ID:** `700618`  
**Slug:** `children-sum-parent`  
**Accepted Submission Date:** `2026-11-22 20:36:12`  

---

## Problem Statement

Given a binary tree, find if it satisfies the Children Sum Property which has the following rules
- Each non-leaf node must have a value equal to the sum of its left and right children's values. 
- A NULL child is considered to have a value of 0, and all leaf nodes are considered valid by default.

**Examples:**
```text
**Input: **root =** **[35, 20, 15, 15, 5, 10, 5]
**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/907368/Web/Other/blobid1_1754457377.webp" />

**
**Output: **true**
Explanation: **Here, every node is sum of its left and right child.
```

```text
**Input: **root = [1, 4, 3, 5]**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/907368/Web/Other/blobid2_1754457435.webp" />

**  
**Output: **false**
Explanation: **Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given condition.
```

---

## Solution & Approach

### Approach Explanation

Recursive Binary Tree Traversal:
1. Base cases: An empty tree or a leaf node inherently satisfies the children sum property.
2. For an internal node, compute the values of left and right children (defaulting to 0 if null).
3. If `root.data != leftValue + rightValue`, return `false`.
4. Recursively check both left and right subtrees; return `true` only if both satisfy the property.

### Complexity Analysis
- **Time Complexity:** O(n) where n is the number of nodes in the binary tree
- **Auxiliary Space:** O(h) where h is the height of the tree for recursion stack

---

## Source Code

```java
class Solution {
    public boolean isSumProperty(Node root) {

        // Empty tree or leaf node is valid
        if (root == null ||
            (root.left == null && root.right == null)) {
            return true;
        }

        int leftValue = (root.left != null) ? root.left.data : 0;
        int rightValue = (root.right != null) ? root.right.data : 0;

        // Check current node
        if (root.data != leftValue + rightValue) {
            return false;
        }

        // Check left and right subtrees
        return isSumProperty(root.left) &&
               isSumProperty(root.right);
    }
}
```
