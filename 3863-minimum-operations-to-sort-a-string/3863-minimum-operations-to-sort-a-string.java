class Solution {
public int minOperations(String s) {
int n = s.length();
char[] arr = s.toCharArray();
boolean sorted = true;
    for (int i = 1; i < n; i++) {
        if (arr[i] < arr[i - 1]) {
            sorted = false;
            break;
        }
    }
    if (sorted) return 0;
    if (n == 2) return -1;
    char min = arr[0];
    char max = arr[0];
    for (char c : arr) {
        min = (char) Math.min(min, c);
        max = (char) Math.max(max, c);
    }
    if (arr[0] == min || arr[n - 1] == max) {
        return 1;
    }
    for (int i = 1; i < n - 1; i++) {
        if (arr[i] == min || arr[i] == max) {
            return 2;
        }
    }
    return 3;
}
}