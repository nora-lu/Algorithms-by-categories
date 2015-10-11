/*Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.*/

/*如果没有给n是valid的条件，要向面试官询问n是否valid
  如果n不valid，先计算list的大小，判断n是否valid*/

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n == 0) { return head; }
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;

		// move fast n steps ahead of slow
		for (int i = 0; i < n; i++) { fast = fast.next; }
		// move fast, slow together until fast reaches end
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		// remove slow.next
		slow.next = slow.next.next;
		return dummy.next;
	}
}