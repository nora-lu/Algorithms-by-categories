/*Consider a binary tree in which each node contains a binary digit.
Design a algorithm to compute the sum of the binary numbers represented by the root-to-leaf paths.*/
public class Solution {
	public int sum(TreeNode root) {
   		return sum(root, 0);
	}

	private int sum(TreeNode node, int partialSum) {
		if (node == null) { return 0; }
		partialSum = 2 * partialSum + node.val;
		if (node.left == null && node.right == null) {
			return partialSum;
		}
		return sum(node.left, partialSum) + sum(node.right, partialSum);
	}
}