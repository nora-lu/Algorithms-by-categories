public class InsertionSort {
  public static void sort(int[] ar) {
    if (ar == null || ar.length == 0) { return; }
    for (int i = 1; i < ar.length; i++) {
      int toInsert = ar[i];
      int j = i;
      while (j > 0 && ar[j - 1] > toInsert) {
        ar[j] = ar[j - 1];
        j--;
      }
      ar[j] = toInsert;
    }
  }

  public static void main(String[] args) {
    int[][] test = new int[][]{{0}, {1, 0}, {2, 6, 1, -1, 3, 7}};
    for (int[] ar : test) {
      System.out.println("Before sort: " + Arrays.toString(ar));
      sort(ar);
      System.out.println("After sort: " + Arrays.toString(ar));
    }
  }
}
