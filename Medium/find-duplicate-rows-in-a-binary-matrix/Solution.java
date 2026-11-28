import java.util.*;

class Solution {
    public ArrayList<Integer> repeatedRows(int[][] mat) {

        ArrayList<Integer> result = new ArrayList<>();

        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < mat.length; i++) {

            StringBuilder row = new StringBuilder();

            // Convert the current row into a string.
            for (int j = 0; j < mat[i].length; j++) {
                row.append(mat[i][j]);
            }

            String currentRow = row.toString();

            // Check whether this row appeared before.
            if (seen.contains(currentRow)) {
                result.add(i);
            } else {
                seen.add(currentRow);
            }
        }

        return result;
    }
}