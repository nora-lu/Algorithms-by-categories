/*Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?*/
public class ThreeSumSmaller {
  public int threeSumSmaller(int[] nums, int target) {
    if (nums == null) { return 0; }
    
    Arrays.sort(nums);
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      int lo = i + 1, hi = nums.length - 1;
      while (lo < hi) {
        if (nums[i] + nums[lo] + nums[hi] >= target) {
          while (lo < hi && nums[hi] == nums[hi - 1]) { hi--; }
          hi--;
        } else {
          res += (hi - lo);  // all k's: nums[i] + nums[lo] + nums[k] < target (lo < k <= hi)
          lo++;
        }
      }
    }
    return res;
  }
}