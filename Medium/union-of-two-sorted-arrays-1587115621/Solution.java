import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.length && j < b.length) {

            int value;

            if (a[i] < b[j]) {
                value = a[i];
                i++;
            }
            else if (a[i] > b[j]) {
                value = b[j];
                j++;
            }
            else {
                value = a[i];
                i++;
                j++;
            }

            // Avoid duplicates
            if (result.isEmpty() || result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        // Remaining elements of array a
        while (i < a.length) {

            int value = a[i++];

            if (result.isEmpty() || result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        // Remaining elements of array b
        while (j < b.length) {

            int value = b[j++];

            if (result.isEmpty() || result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        return result;
    }
}
