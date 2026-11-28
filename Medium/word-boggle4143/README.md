# Word Boggle

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/word-boggle4143/1](https://www.geeksforgeeks.org/problems/word-boggle4143/1)  
**Problem ID:** `702105`  
**Slug:** `word-boggle4143`  
**Accepted Submission Date:** `2026-11-28 10:50:19`  

---

## Problem Statement

Given a string array **dictionary[]** of size **n** containing distinct words and a character matrix** board[][]** of size **r × c**, find all words from the dictionary that can be formed in the board.

- A word can be formed by starting from any cell and moving to any of its 8 adjacent cells (horizontally, vertically, or diagonally).

-  Each cell can be used at most once while forming a single word.

Return all dictionary words that can be formed in the board.

**Note:** The words in the output can be returned in any order.

**Examples :**

```text
**Input: **board[][] = [[C, A, P], [A, N, D], [T, I, E]], dictionary[] = ["CAT"]
**Output: **["CAT"]
**Explanation**: "CAT" can be formed by traversing adjacent cells (8 directions) without reusing any cell.

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929908/Web/Other/blobid0_1781869306.png" />

```

```text
**Input: **board[][] = [[G, I, Z], [U, E, K], [Q, S, E]], dictionary[] = ["GEEKS", "FOR", "QUIZ", "GO"], 
**Output: **["GEEKS","QUIZ"]
**Explanation**: "GEEKS" and "QUIZ" can be formed by traversing adjacent cells (8 directions) without reusing any cell.

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929908/Web/Other/blobid1_1781869321.png" />

```

**Constraints:
**1 ≤ n ≤ 15
1 ≤ r, c ≤ 50
1 ≤ |dictionary[i]| ≤ 60
Each dictionary[i] may contain both lowercase and uppercase English letters.

---

## Solution & Approach

### Approach Explanation

Trie-Guided Depth First Search (Backtracking):
1. Build a Trie containing all dictionary words. Store the full string at each terminal Trie node.
2. Iterate through each cell (i, j) on the r x c grid and initiate DFS with root Trie node.
3. In DFS, check if `node.children[ch]` exists. If so, check if a complete word is formed; if found, add to result and set `node.word = null` to avoid duplicates.
4. Mark cell as visited, explore all 8 adjacent directions recursively, and unmark (backtrack) upon return.

### Complexity Analysis
- **Time Complexity:** O(sum |word| + r * c * 8^L)
- **Auxiliary Space:** O(sum |word| + r * c)

---

## Source Code

```java
import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[128];
        String word;
    }

    public ArrayList<String> wordBoggle(char[][] board, String[] dictionary) {

        ArrayList<String> result = new ArrayList<>();

        int r = board.length;
        int c = board[0].length;

        // Step 1: Build the Trie using dictionary words.
        TrieNode root = new TrieNode();

        for (String word : dictionary) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch;

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.word = word;
        }

        // Step 2: Track visited cells.
        boolean[][] visited = new boolean[r][c];

        // Step 3: Start DFS from every board cell.
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dfs(board, i, j, root, visited, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int row, int col,
                     TrieNode node, boolean[][] visited,
                     ArrayList<String> result) {

        // Do not reuse an already visited cell.
        if (visited[row][col]) {
            return;
        }

        char ch = board[row][col];

        // Check whether this character exists in the Trie.
        TrieNode next = node.children[ch];

        if (next == null) {
            return;
        }

        // Complete word found.
        if (next.word != null) {
            result.add(next.word);

            // Prevent adding the same word again.
            next.word = null;
        }

        // Mark current cell as visited.
        visited[row][col] = true;

        // Explore all 8 adjacent directions.
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {

                if (dr == 0 && dc == 0) {
                    continue;
                }

                int newRow = row + dr;
                int newCol = col + dc;

                if (newRow >= 0 && newRow < board.length &&
                    newCol >= 0 && newCol < board[0].length &&
                    !visited[newRow][newCol]) {

                    dfs(board, newRow, newCol, next,
                        visited, result);
                }
            }
        }

        // Backtracking: allow this cell to be used in other paths.
        visited[row][col] = false;
    }
}
```
