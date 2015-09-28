/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.*/
public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    int minIdx = findMinIdx(nums);
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int realMid = (mid + minIdx) % nums.length;
      if (nums[realMid] == target) { return realMid; }
      if (nums[realMid] < target) { lo = mid + 1; }
      else { hi = mid - 1; }
    }
    return -1;
  }
  
  /**
   * General approach to find the index of smallest element in a rotated array.
   */
  private int findMinIdx(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] > nums[hi]) { lo = mid + 1; }
      else hi = mid;
    }
    return lo;
  }
}

/*The idea is that when rotating the array, there must be one half of
the array that is still in sorted order. For example, 6 7 1 2 3 4 5,
the order is disrupted from the point between 7 and 1. So when doing
binary search, we can make a judgement that which part is ordered and
whether the target is in that range, if yes, continue the search in
that half, if not continue in the other half.*/

public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) { return -1; }
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) { return mid; }
      if (nums[lo] <= nums[mid]) {
        if (nums[lo] <= target && nums[mid] > target) { hi = mid - 1; }
        else { lo = mid + 1; }
      } else {
        if (nums[mid] < target && nums[hi] >= target) { lo = mid + 1; }
        else { hi = mid - 1; }
      }
    }
    return nums[lo] == target ? lo : -1;
  }
}