public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) { res++; }
            /**
             * Unsigned right shift in java: 
             * http://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.19
             */
            n >>>= 1;
        }
        return res;
    }
}