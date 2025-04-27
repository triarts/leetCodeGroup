package org.example.bfsDfsGraphTree;

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}

public class TreeDFS {
	public void dfs(TreeNode root) {
		if (root == null) return;

		System.out.print(root.val + " "); // Preorder: Node first
		dfs(root.left);
		dfs(root.right);
	}

	public static void main(String[] args) {
		// Build this tree:
		//      1
		//     / \
		//    2   3
		//   / \
		//  4   5

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		TreeDFS tree = new TreeDFS();
		System.out.println("DFS (Preorder) of the tree:");
		tree.dfs(root);
	}
}