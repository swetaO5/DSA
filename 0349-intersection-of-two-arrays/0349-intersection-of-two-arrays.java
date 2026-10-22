import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> values = new HashSet<>();
        Set<Integer> common = new HashSet<>();
        for (int n : nums1) {
            values.add(n);
        }
        for (int n : nums2) {
            if (values.contains(n)) {
                common.add(n);
            }
        }
        int[] result = new int[common.size()];
        int i = 0;
        for (int n : common) {
            result[i++] = n;
        }
        return result;
    }
}