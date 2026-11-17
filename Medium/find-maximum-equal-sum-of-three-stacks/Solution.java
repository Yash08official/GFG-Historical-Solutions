import java.util.*;

class Solution {

    public int maxEqualSum(ArrayList<Integer> s1,
                           ArrayList<Integer> s2,
                           ArrayList<Integer> s3) {

        // Calculate initial sums
        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;

        for (int x : s1) {
            sum1 += x;
        }

        for (int x : s2) {
            sum2 += x;
        }

        for (int x : s3) {
            sum3 += x;
        }

        // Top pointers (first element is top)
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < s1.size() &&
               j < s2.size() &&
               k < s3.size()) {

            // All three sums are equal
            if (sum1 == sum2 && sum2 == sum3) {
                return (int) sum1;
            }

            // Remove from stack with largest sum
            if (sum1 >= sum2 && sum1 >= sum3) {

                sum1 -= s1.get(i);
                i++;

            } else if (sum2 >= sum1 && sum2 >= sum3) {

                sum2 -= s2.get(j);
                j++;

            } else {

                sum3 -= s3.get(k);
                k++;
            }
        }

        return 0;
    }
}
