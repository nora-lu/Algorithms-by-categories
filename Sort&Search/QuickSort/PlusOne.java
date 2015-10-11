public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) { return digits; }
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) { digits[i--] = 0; }
        if (i == -1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        digits[i]++;
        return digits;
    }
}