class Solution {

    public boolean isValid(String s) {

        // Step 1: Split using dot
        String[] parts = s.split("\\.", -1);

        // Exactly 4 parts required
        if (parts.length != 4) {
            return false;
        }

        // Step 2: Validate each part
        for (String part : parts) {

            // Empty part is invalid
            if (part.length() == 0) {
                return false;
            }

            // Leading zero is invalid
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }

            // Check only digits
            for (int i = 0; i < part.length(); i++) {

                if (part.charAt(i) < '0' || part.charAt(i) > '9') {
                    return false;
                }
            }

            // Maximum 3 digits
            if (part.length() > 3) {
                return false;
            }

            // Convert to integer
            int num = Integer.parseInt(part);

            // Check range
            if (num < 0 || num > 255) {
                return false;
            }
        }

        return true;
    }
}
