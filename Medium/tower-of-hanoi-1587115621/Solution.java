class Solution {

    public int towerOfHanoi(int n, int from, int to, int aux) {

        // Base case
        if (n == 0) {
            return 0;
        }

        // Move n-1 disks from source to auxiliary
        int first = towerOfHanoi(n - 1, from, aux, to);

        // Move the largest disk (1 move)
        int move = 1;

        // Move n-1 disks from auxiliary to destination
        int second = towerOfHanoi(n - 1, aux, to, from);

        return first + move + second;
    }
}
