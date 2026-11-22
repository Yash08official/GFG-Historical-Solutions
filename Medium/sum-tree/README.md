# Sum Tree

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/sum-tree/1](https://www.geeksforgeeks.org/problems/sum-tree/1)  
**Problem ID:** `700179`  
**Slug:** `sum-tree`  
**Accepted Submission Date:** `2026-11-22 19:28:32`  

---

## Problem Statement

Given the** **root of a Binary Tree with **n** nodes, check whether it is a Sum Tree and return true if it is, otherwise return false. 

A Sum Tree is a Binary Tree in which the value of every non-leaf node is equal to the sum of all nodes present in its left and right subtrees. An empty tree and a leaf node are also considered Sum Trees.

**Examples:**
```text
**Input: **root[] = [3, 1, 2]

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929966/Web/Other/blobid0_1781949612.png" />

 
**Output:** true
**Explanation: **The sum of left subtree and right subtree is 1 + 2 = 3, which is the value of the root node. Therefore, the given binary tree is a sum tree.
```

```text
**Input: **root[] = [10, 20, 30, 10, 10]

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929966/Web/Other/blobid1_1781949647.png" />

 
**Output: **false
**Explanation:** The given tree is not a Sum Tree. For the root node, the sum of nodes in the left and right subtrees is 40 + 30 = 70, which is not equal to the root value 10.
```

---

## Solution & Approach

### Approach Explanation

Post-Order Traversal with Recursive Subtree Validation:
1. Base cases: An empty tree is a Sum Tree with sum 0; a leaf node is a Sum Tree with sum equal to its value.
2. For any internal node, recursively evaluate both left and right subtrees.
3. The current node is a Sum Tree if and only if both left and right subtrees are valid Sum Trees AND node.data == left.sum + right.sum.
4. Return the aggregated subtree sum (node.data + left.sum + right.sum) along with the validity flag.

### Complexity Analysis
- **Time Complexity:** O(n) where n is the number of nodes in the binary tree
- **Auxiliary Space:** O(h) where h is the height of the tree for recursion call stack

---

## Source Code

```java
class Solution {

    public boolean isSumTree(Node node) {
        return checkSumTree(node).isSumTree;
    }

    static class Result {
        boolean isSumTree;
        int sum;

        Result(boolean isSumTree, int sum) {
            this.isSumTree = isSumTree;
            this.sum = sum;
        }
    }

    private Result checkSumTree(Node node) {

        // Empty tree
        if (node == null) {
            return new Result(true, 0);
        }

        // Leaf node
        if (node.left == null && node.right == null) {
            return new Result(true, node.data);
        }

        Result left = checkSumTree(node.left);
        Result right = checkSumTree(node.right);

        // Check whether both subtrees are Sum Trees
        boolean valid = left.isSumTree &&
                        right.isSumTree &&
                        node.data == left.sum + right.sum;

        // Return current subtree's total sum
        int totalSum = node.data + left.sum + right.sum;

        return new Result(valid, totalSum);
    }
}
```
