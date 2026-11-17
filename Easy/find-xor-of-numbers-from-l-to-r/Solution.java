class Solution {

    private int xorUpto(int n) {

        if (n % 4 == 0) {
            return n;
        }
        else if (n % 4 == 1) {
            return 1;
        }
        else if (n % 4 == 2) {
            return n + 1;
        }
        else {
            return 0;
        }
    }

    public int findXOR(int l, int r) {

        return xorUpto(r) ^ xorUpto(l - 1);
    }
}
