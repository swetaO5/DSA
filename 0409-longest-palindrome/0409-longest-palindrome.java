class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        int length = 0;
        boolean hasOddCount = false;
        for (int count : counts) {
            length += (count / 2) * 2;
            if (count % 2 == 1) {
                hasOddCount = true;
            }
        }
        return hasOddCount ? length + 1 : length;
    }
}