/**
 * You will be given a list of 32 bits unsigned integers. 
 * You are required to output the list of the unsigned integers you get 
 * by flipping bits in its binary representation (i.e. unset bits must be set, and set bits must be unset).
 */
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        long mask = (1L << 32) - 1;
        
        for (int i = 0; i < size; i++) {
            long x = in.nextLong();
            System.out.println(x ^ mask);
        }
    }
}