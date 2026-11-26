class Solution {
    public int maxArea(List<Integer> height) {

        int left = 0;
        int right = height.size() - 1;

        int maxArea = 0;

        while (left < right) {

            // Find the smaller height
            int minHeight = Math.min(
                height.get(left),
                height.get(right)
            );

            // Number of bars between the selected bars
            int width = right - left - 1;

            // Calculate area
            int area = minHeight * width;

            // Update maximum area
            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}