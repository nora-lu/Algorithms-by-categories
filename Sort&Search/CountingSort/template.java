public class CountingSort {
  public static int[] sort(int[] ar, int maxValue) {
    if (ar == null) { return null; }
    int[] counts = new int[maxValue + 1];
    // calculate frequencies
    for (int i = 0; i < ar.length; i++) {
      counts[ar[i]]++;
    }
    // calculate start index
    int total = 0;
    for (int i = 0; i <= maxValue; i++) {
      int oldCount = counts[i];
      counts[i] = total;
      total += oldCount;
    }
    // output sorted array
    int[] sorted = new int[ar.length];
    for (int i = 0; i < ar.length; i++) {
      sorted[counts[ar[i]]] = ar[i];
      counts[ar[i]]++;
    }
    return sorted;
  }

  public static void main(String[] args) {
    int maxValue = 100;
    int[] ar = new int[]{ 20, 30, 10, 20, 40, 80, 30, 30, 50, 30, 50, 80 };
    int[] sorted = sort(ar, maxValue);
    System.out.println(Arrays.toString(sorted));
  }
}
