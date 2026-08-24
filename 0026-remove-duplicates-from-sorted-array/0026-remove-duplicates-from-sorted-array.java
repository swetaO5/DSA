class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int curr = 1; 
        for (int i= 1; i < len; i++) {
            if (nums[i] != nums[i-1]) {
                nums[curr] = nums[i];
                curr++;
            }
        }
        return curr;
    }
    
}