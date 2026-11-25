import java.util.*;

class Solution {

    public static ArrayList<Integer> countLessEq(int a[], int b[]) {

        Arrays.sort(b);

        ArrayList<Integer> result = new ArrayList<>();

        for (int x : a) {

            int left = 0;
            int right = b.length;

            // Find the first element greater than x
            while (left < right) {

                int mid = left + (right - left) / 2;

                if (b[mid] <= x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // left represents the count of elements <= x
            result.add(left);
        }

        return result;
    }
}
