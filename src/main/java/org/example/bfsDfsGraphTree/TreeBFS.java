package org.example.bfsDfsGraphTree;

import java.util.*;

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}

public class TreeBFS
{
	public void bfs(TreeNode root)
	{
		if (root == null) return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			System.out.print(current.val + " ");

			if (current.left != null) queue.offer(current.left);
			if (current.right != null) queue.offer(current.right);
		}
	}

	public static void main(String[] args) {
		// Build a simple tree:
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

		TreeBFS tree = new TreeBFS();
		System.out.println("BFS of the tree:");
		tree.bfs(root);
	}
}