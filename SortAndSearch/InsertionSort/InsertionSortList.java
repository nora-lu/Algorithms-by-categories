/**
 * Sort a linked list using insertion sort.
 */
 

// Definition for singly-linked list.
public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) { return head; }
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;  // insert node between pre and pre.next
    ListNode cur = head;
    while (cur != null) {
      pre = dummy;  // traverse from start to find right pos to insert
      while (pre.next != null && pre.next.val < cur.val) { pre = pre.next; }
      ListNode old = cur;
      cur = cur.next;
      old.next = pre.next;
      pre.next = old;
    }
    return dummy.next;
  }
}
