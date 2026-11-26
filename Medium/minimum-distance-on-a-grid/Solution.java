class Solution {
    public int minDistance(int sx, int sy, int dx, int dy) {
        
        // Check if destination is reachable
        if (dx < sx || dy < sy) {
            return -1;
        }

        // Calculate total number of moves
        return (dx - sx) + (dy - sy);
    }
}