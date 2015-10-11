/**
 * O(h) time
 */
public class Solution {
	public TreeNode successor(TreeNode node) {
		TreeNode cur = node;
		if (cur.right != null) {
			// find leftmost node in right subtree
			cur = cur.right;
			while (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		}
		// find the closest ancestor whose left subtree contains node
		while (cur.parent != null && cur.parent.right == cur) {
			cur = cur.parent;
		}
		return cur.parent;
	}
}