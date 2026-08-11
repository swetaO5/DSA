class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int unplaced = 0;

        for (int fruit : fruits) {
            boolean placed = false;

            for (int j = 0; j < n; j++) {
                if (baskets[j] >= fruit) {
                    baskets[j] = -1; // basket is now used
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                unplaced++;
            }
        }

        return unplaced;
    }
}