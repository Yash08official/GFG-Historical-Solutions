import java.util.*;

class Solution {

    public ArrayList<Integer> subsetSums(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        findSums(arr, 0, 0, result);

        return result;
    }

    private void findSums(int[] arr, int index, int sum,
                          ArrayList<Integer> result) {

        // Base case: all elements are processed
        if (index == arr.length) {
            result.add(sum);
            return;
        }

        // Choice 1: Include current element
        findSums(arr, index + 1, sum + arr[index], result);

        // Choice 2: Exclude current element
        findSums(arr, index + 1, sum, result);
    }
}
