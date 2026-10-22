import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums1) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int size = 0;
        for (int n : nums2) {
            int count = counts.getOrDefault(n, 0);
            if (count > 0) {
                result[size++] = n;
                counts.put(n, count - 1);
            }
        }
        return Arrays.copyOf(result, size);
    }
}