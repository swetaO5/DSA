class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) {
            int min = Integer.MAX_VALUE;
            for (int num : nums) {
                min = Math.min(min, num);
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum - 2 * min;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}