class Solution {

    public void mergeSort(int arr[], int l, int r) {

        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        // Divide into two halves
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        // Merge sorted halves
        merge(arr, l, mid, r);
    }

    private void merge(int arr[], int l, int mid, int r) {

        int n1 = mid - l + 1;
        int n2 = r - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        // Copy elements into temporary arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // Merge both sorted arrays
        while (i < n1 && j < n2) {

            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements from left
        while (i < n1) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements from right
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
}
