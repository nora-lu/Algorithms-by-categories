/**
 * O(n) time, O(1) space
 */
public class Solution {
	public List<Integer> inorder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		TreeNode cur = root, prev = null;
		while (cur != null) {
			TreeNode next;
			if (cur.parent == prev) {
				if (cur.left != null) {
					next = cur.left;
				} else {
					res.add(cur.val);
					next = cur.right != null ? cur.right : cur.parent;
				}
			} else if (cur.left == prev) {
				res.add(cur.val);
				next = cur.right != null ? cur.right : cur.parent;
			} else {
				next = cur.parent();
			}
			prev = cur;
			cur = next;
		}
		return res;
	}
}