/*Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 

Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2*/
public class TwoSumII {
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null) { return null; }
    int[] res = new int[2];
    int lo = 0, hi = numbers.length - 1;
    while (lo < hi) {
      int sum = numbers[lo] + numbers[hi];
      if (sum == target) {
        res[0] = lo + 1;
        res[1] = hi + 1;
        return res;
      } else if (sum < target) {
        // not necessary to check duplicates if assuming exactly one solution (meaning no duplicates)
        while (lo < hi && numbers[lo] == numbers[lo + 1]) { lo++; }
        lo++;
      } else {
        while (lo < hi && numbers[hi] == numbers[hi - 1]) { hi--; }
        hi--;
      }
    }
    return res;
  }
}