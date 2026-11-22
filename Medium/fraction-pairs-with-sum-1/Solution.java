import java.util.*;

class Solution {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int countFractions(int[] numerator, int[] denominator) {

        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < numerator.length; i++) {

            int num = numerator[i];
            int den = denominator[i];

            // Find complementary fraction: (den - num) / den
            int complementNum = den - num;
            int complementDen = den;

            // Simplify complementary fraction
            int g = gcd(complementNum, complementDen);

            complementNum /= g;
            complementDen /= g;

            String key = complementNum + "/" + complementDen;

            // Check if complementary fraction exists
            count += map.getOrDefault(key, 0);

            // Simplify current fraction
            g = gcd(num, den);

            num /= g;
            den /= g;

            String currentKey = num + "/" + den;

            // Store current fraction
            map.put(currentKey, map.getOrDefault(currentKey, 0) + 1);
        }

        return count;
    }
}
