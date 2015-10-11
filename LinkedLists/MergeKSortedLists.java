/*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

/* Divide-and-Conquer takes O(nklog(k)) time */
public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		return merge(lists, 0, lists.length - 1);
	}

	private ListNode merge(ListNode[] lists, int lo, int hi) {
		if (lists == null || lo > hi) { return null; }
		if (lo == hi) { return lists[lo]; }
		int mid = lo + (hi - lo) / 2;
		ListNode left = merge(lists, lo, mid);
		ListNode right = merge(lists, mid + 1, hi);
		return helper(left, right);
	}

	private ListNode helper(ListNode n1, ListNode n2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode tmp1 = n1, tmp2 = n2;
		while (tmp1 != null && tmp2 != null) {
			if (tmp1.val <= tmp2.val) {
				tail.next = tmp1;
				tmp1 = tmp1.next;
			} else {
				tail.next = tmp2;
				tmp2 = tmp2.next;
			}
			tail = tail.next;
		}
		if (tmp1 == null) { tail.next = tmp2; }
		else if (tmp2 == null) { tail.next = tmp1; }
		return dummy.next;
	}
}

public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) { return null; }
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		for (ListNode n : lists) {
			if (n != null) { pq.offer(n); }
		}
		while (!pq.isEmpty()) {
			tail.next = pq.poll();
			tail = tail.next;
			if (tail.next != null) { pq.offer(tail.next); }
		}
		return dummy.next;
	}
}