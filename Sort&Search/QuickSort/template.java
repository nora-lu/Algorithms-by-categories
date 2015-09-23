import java.util.Arrays;

public class QuickSort {
	  public static void quickSort(int[] ar) {
	    if (ar == null) { return; }
	    quickSort(ar, 0, ar.length - 1); 
	  }

	  private static void quickSort(int[] ar, int lo, int hi) {
	    if (lo >= hi) { return; }
	    int pos = partition(ar, lo, hi);
	    quickSort(ar, lo, pos - 1);
	    quickSort(ar, pos + 1, hi);
	  }

	  
	  // partition the subarray ar[lo..hi] so that ar[lo..j-1] <= ar[j] <= a[j+1..hi]
	  // and return index j
	  private static int partition(int[] ar, int lo, int hi) {
	    int i = lo, j = hi + 1;  // 特别注意初始值
	    int pivot = ar[lo];
	    while (true) {
	      /**
	       * 注意这里i和j很容易出bug
	       */
	      while (i < hi && ar[++i] < pivot);
	      while (j > lo && ar[--j] > pivot);
	      // check if pointers cross
	      if (i >= j) { break; }
	      swap(ar, i, j);
	    }
	    swap(ar, lo, j);
	    return j;
	  }

	  private static void swap(int[] ar, int i, int j) {
	    int tmp = ar[i];
	    ar[i] = ar[j];
	    ar[j] = tmp;
	  }

	  public static void main(String[] args) {
	    int[][] test = new int[][]{{0}, {1, 0}, {2, 6, 1, -1, 3, 7, -2, 9}, {3,3,3,3}};
	    for (int[] ar : test) {
	      System.out.println("Before sort: " + Arrays.toString(ar));
	      quickSort(ar);
	      System.out.println("After sort: " + Arrays.toString(ar));
	  }
	}
}