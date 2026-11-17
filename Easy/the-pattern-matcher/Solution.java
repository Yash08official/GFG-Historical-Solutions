class Solution {

    public boolean findPattern(String s) {

        int i = 0;
        int n = s.length();

        while (i < n) {

            // Every group must start with x
            if (s.charAt(i) != 'x') {
                return false;
            }

            // Count consecutive x's
            int countX = 0;

            while (i < n && s.charAt(i) == 'x') {
                countX++;
                i++;
            }

            // Count consecutive y's
            int countY = 0;

            while (i < n && s.charAt(i) == 'y') {
                countY++;
                i++;
            }

            // Both counts must be equal
            if (countX != countY) {
                return false;
            }
        }

        return true;
    }
}
