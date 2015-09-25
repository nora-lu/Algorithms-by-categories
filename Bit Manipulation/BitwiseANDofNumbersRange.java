/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int movefactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            movefactor <<= 1;
        }
        return m * movefactor;
    }
}