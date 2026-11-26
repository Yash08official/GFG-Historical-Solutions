import java.util.*;

class Solution {

    public static int closestToZero(int arr[]) {

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        int bestSum = arr[left] + arr[right];

        while (left < right) {

            int currentSum = arr[left] + arr[right];

            // Update if closer to zero
            // In case of a tie, choose the greater sum
            if (Math.abs(currentSum) < Math.abs(bestSum) ||
                (Math.abs(currentSum) == Math.abs(bestSum)
                && currentSum > bestSum)) {

                bestSum = currentSum;
            }

            if (currentSum == 0) {
                return 0;
            }

            if (currentSum < 0) {

                left++;

            } else {

                right--;
            }
        }

        return bestSum;
    }
}