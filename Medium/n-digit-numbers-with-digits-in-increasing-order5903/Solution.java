import java.util.*;

class Solution {

    static ArrayList<Integer> result;

    public static ArrayList<Integer> increasingNumbers(int n) {

        result = new ArrayList<>();

        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }

        if (n > 10) {
            return result;
        }

        generate(0, 1, n);

        return result;
    }

    static void generate(int num, int start, int n) {

        // Required number of digits generated
        if (n == 0) {
            result.add(num);
            return;
        }

        // Try digits from start to 9
        for (int digit = start; digit <= 9; digit++) {

            generate(num * 10 + digit, digit + 1, n - 1);
        }
    }
}
