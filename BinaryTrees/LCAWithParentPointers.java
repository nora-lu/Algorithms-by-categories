public class LCAWithParentPointers {
	public static TreeNode LCA(TreeNode p, TreeNode q) {
		int pDepth = getDepth(p), qDepth = getDepth(q);
		// Makes p as the deeper node
		if (qDepth > pDepth) {
			TreeNode tmp = p;
			p = q;
			q = tmp;
		}
		// Ascends from the deeper node
		int diff = pDepth - qDepth;
		while (diff-- > 0) {
			p = p.getParent();
		}
		// Now ascends both nodes until we reach the LCA.
		while (p != q) {
			p = p.getParent();
			q = q.getParent();
		}
		return p;
	}

	private static int getDepth(TreeNode node) {
		int depth = 0;
		TreeNode tmp = node;
		while (tmp != null) {
			depth++;
			tmp = tmp.getParent();
		}
		return depth;
	}
}