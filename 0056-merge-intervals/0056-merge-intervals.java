class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] merged = new int[intervals.length][2];
        int size = 0;
        for (int[] interval : intervals) {
            if (size == 0 || interval[0] > merged[size - 1][1]) {
                merged[size++] = interval;
            } else {
                merged[size - 1][1] =
                    Math.max(merged[size - 1][1], interval[1]);
            }
        }
        return Arrays.copyOf(merged, size);
    }
}