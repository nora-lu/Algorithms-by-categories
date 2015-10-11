public class Solution {
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode cur1 = l1, cur2 = l2;
		while (cur1 != null && cur2 != null) {
			if (cur1.val <= cur2.val) {
				tail.next = cur1;
				cur1 = cur1.next;
			} else {
				tail.next = cur2;
				cur2 = cur2.next;
			}
			tail = tail.next;
		}
		if (cur1 == null) { tail.next = cur2; }
		else if (cur2 == null) { tail.next = cur1; }
		return dummy.next;
	}
}