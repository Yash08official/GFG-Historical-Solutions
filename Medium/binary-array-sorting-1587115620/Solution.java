class Solution {
    public void binSort(int[] arr) {
        
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // Skip zeros from the left
            while (left < right && arr[left] == 0) {
                left++;
            }

            // Skip ones from the right
            while (left < right && arr[right] == 1) {
                right--;
            }

            // Swap misplaced elements
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }
}