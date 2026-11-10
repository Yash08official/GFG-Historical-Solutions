import java.util.*;

class Solution {

    public ArrayList<String> ratInMaze(int[][] maze) {

        ArrayList<String> result = new ArrayList<>();

        int n = maze.length;

        // Check blocked starting or destination cell
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return result;
        }

        boolean[][] visited = new boolean[n][n];

        StringBuilder path = new StringBuilder();

        dfs(0, 0, maze, visited, path, result, n);

        return result;
    }

    private void dfs(int row, int col, int[][] maze,
                     boolean[][] visited, StringBuilder path,
                     ArrayList<String> result, int n) {

        // Destination reached
        if (row == n - 1 && col == n - 1) {
            result.add(path.toString());
            return;
        }

        visited[row][col] = true;

        // D - Down
        if (row + 1 < n && maze[row + 1][col] == 1
                && !visited[row + 1][col]) {

            path.append('D');

            dfs(row + 1, col, maze, visited, path, result, n);

            path.deleteCharAt(path.length() - 1);
        }

        // L - Left
        if (col - 1 >= 0 && maze[row][col - 1] == 1
                && !visited[row][col - 1]) {

            path.append('L');

            dfs(row, col - 1, maze, visited, path, result, n);

            path.deleteCharAt(path.length() - 1);
        }

        // R - Right
        if (col + 1 < n && maze[row][col + 1] == 1
                && !visited[row][col + 1]) {

            path.append('R');

            dfs(row, col + 1, maze, visited, path, result, n);

            path.deleteCharAt(path.length() - 1);
        }

        // U - Up
        if (row - 1 >= 0 && maze[row - 1][col] == 1
                && !visited[row - 1][col]) {

            path.append('U');

            dfs(row - 1, col, maze, visited, path, result, n);

            path.deleteCharAt(path.length() - 1);
        }

        // Backtrack
        visited[row][col] = false;
    }
}
