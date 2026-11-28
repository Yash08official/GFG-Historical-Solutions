import java.util.*;

class Solution {
    public int minXor(int[] arr) {

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {

            int xor = arr[i] ^ arr[i - 1];

            min = Math.min(min, xor);
        }

        return min;
    }
}