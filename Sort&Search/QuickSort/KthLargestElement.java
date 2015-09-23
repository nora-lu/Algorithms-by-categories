public class KthLargestElement {
  public int findKthLargest(int[] nums, int k) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int pos = partition(nums, lo, hi);
      if (pos + 1 == k) { return nums[pos]; }
      else if (pos + 1 < k) {
        lo = pos + 1;
      } else { hi = pos - 1; }
    }
    return nums[lo];
  }

  private int partition(int[] nums, int lo, int hi) {
    int pivot = nums[lo];
    int i = lo, j = hi + 1;
    while (true) {
      while (i < hi && nums[++i] > pivot);
	 while (j > lo && nums[--j] < pivot);

      if (i >= j) { break; }
      swap(nums, i, j);
    }
    swap(nums, lo, j);
    return j;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
