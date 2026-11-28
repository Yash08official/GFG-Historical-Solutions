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