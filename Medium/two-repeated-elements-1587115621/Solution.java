import java.util.*;

class Solution {

    public int[] twoRepeated(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        int[] result = new int[2];
        int index = 0;

        for (int num : arr) {

            // If the number is already present,
            // this is its second occurrence.
            if (!set.add(num)) {

                result[index] = num;
                index++;

                // We found both repeating numbers.
                if (index == 2) {
                    break;
                }
            }
        }

        return result;
    }
}
