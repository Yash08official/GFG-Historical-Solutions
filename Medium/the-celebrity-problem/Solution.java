class Solution {
    public int celebrity(int mat[][]) {

        int n = mat.length;

        int top = 0;
        int bottom = n - 1;

        // Step 1: Find a possible celebrity
        while (top < bottom) {

            if (mat[top][bottom] == 1) {
                top++;
            } else {
                bottom--;
            }
        }

        // Possible celebrity
        int candidate = top;

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {

            if (i == candidate) {
                continue;
            }

            // Candidate should not know anyone
            // Everyone should know the candidate
            if (mat[candidate][i] == 1 ||
                mat[i][candidate] == 0) {

                return -1;
            }
        }

        return candidate;
    }
}
