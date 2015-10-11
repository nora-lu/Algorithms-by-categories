/** Three way partition */

public void dutchFlagPartition(int pivotIdx, int[] arr) {
	int pivot = arr[pivotIdx];
	/**
     * Keep the following invariants during partitioning:
     * bottom group: A.subList(0 : smaller).
     * middle group: A.subList(smaller : equal).
     * unclassified group: A.subList(equal : larger + 1).
     * top group: A.subList(larger + 1, A.size()).
     */
	int smaller = 0, equal = 0, larger = arr.length - 1;
	while (equal <= larger) {
		if (arr[equal] < pivot) {
			swap(arr, smaller, equal);
			smaller++; equal++;
		} else if (arr[equal] == pivot) {
			equal++;
		} else {
			swap(arr, equal, larger);
			larger--;
		}
	}
}

private void swap();