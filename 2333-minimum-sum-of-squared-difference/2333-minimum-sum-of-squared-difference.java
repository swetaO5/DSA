class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }
        int low = 0, high = max;
        while (low < high) {
            int mid = (low + high) / 2;
            long operations = 0;
            for (int d : diff) {
                operations += Math.max(0, d - mid);
            }
            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        long operations = 0;
        long ans = 0;
        for (int d : diff) {
            int remaining = Math.min(d, low);
            operations += d - remaining;
            ans += (long) remaining * remaining;
        }
        long extra = k - operations;
        for (int d : diff) {
            if (extra == 0) {
                break;
            }
            if (d >= low && low > 0) {
                ans -= (long) low * low;
                ans += (long) (low - 1) * (low - 1);
                extra--;
            }
        }
        return ans;
    }
}