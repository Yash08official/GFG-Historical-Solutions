class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int count = 0;
    }

    private void insert(TrieNode root, int num) {
        TrieNode current = root;

        for (int bit = 16; bit >= 0; bit--) {
            int value = (num >> bit) & 1;

            if (current.children[value] == null) {
                current.children[value] = new TrieNode();
            }

            current = current.children[value];
            current.count++;
        }
    }

    private int countLessThan(TrieNode root, int num, int k) {
        TrieNode current = root;
        int result = 0;

        for (int bit = 16; bit >= 0; bit--) {

            if (current == null) {
                break;
            }

            int numBit = (num >> bit) & 1;
            int kBit = (k >> bit) & 1;

            if (kBit == 1) {

                // XOR bit 0 makes the current XOR prefix smaller
                if (current.children[numBit] != null) {
                    result += current.children[numBit].count;
                }

                // Continue with XOR bit 1
                current = current.children[1 - numBit];

            } else {

                // XOR bit must be 0
                current = current.children[numBit];
            }
        }

        return result;
    }

    public int cntPairs(int[] arr, int k) {

        TrieNode root = new TrieNode();
        int answer = 0;

        for (int num : arr) {

            // Count valid pairs with previously inserted numbers
            answer += countLessThan(root, num, k);

            // Insert current number
            insert(root, num);
        }

        return answer;
    }
}