# Rat in Maze

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1](https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1)  
**Problem ID:** `700408`  
**Slug:** `rat-in-a-maze-problem`  
**Topic Tags:** `Backtracking`  
**Accepted Submission Date:** `2026-11-09 17:33:17`  
**Language:** `Java`  

---

## Problem Statement

Find all possible paths that a rat can take from source (0, 0) to destination (n-1, n-1) in a grid of size n x n with 0s (blocked) and 1s (open). Directions: D, L, R, U.

### Examples

```
Input: maze[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) through two valid paths.

Input: maze[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path can reach (1, 1).
```

---

## Approach

- **Backtracking DFS in Lexicographical Order:**
  - Explore moves in alphabetical order: Down ('D'), Left ('L'), Right ('R'), Up ('U').
  - If reaching `(n-1, n-1)`, record `path.toString()`.
  - Mark `visited[row][col] = true`, recurse on valid adjacent open unvisited cells, and backtrack with `visited[row][col] = false`.
- **Time Complexity:** $O(4^{n^2})$ worst-case.
- **Space Complexity:** $O(n^2)$ recursion stack and visited array.

---

## Recovered Solution Files

- **[Solution.java](./Solution.java)** (Java) - `SHA-256: 075c25d8e4d6590daec1508263939e2662bb617dd05a055180bf965c4a197d53`
