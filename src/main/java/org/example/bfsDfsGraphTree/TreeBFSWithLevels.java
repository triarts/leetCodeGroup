package org.example.bfsDfsGraphTree;

import java.util.*;

//Level Order Traversal
//class TreeNode
//{
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}

// sama psersis dengan
//BinaryTreeLevelOrderTraversal

public class TreeBFSWithLevels {
	public void bfsWithLevels(TreeNode root) {
		if (root == null) return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size(); // Number of nodes at current level

			// Process all nodes for this level
			for (int i = 0; i < levelSize; i++) {
				TreeNode current = queue.poll();
				System.out.print(current.val + " ");

				if (current.left != null) queue.offer(current.left);
				if (current.right != null) queue.offer(current.right);
			}

			System.out.println(); // Move to next line after each level
		}
	}

	public static void main(String[] args) {
		// Build the tree:
		//      1
		//     / \
		//    2   3
		//   / \    \
		//  4   5    6

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		TreeBFSWithLevels tree = new TreeBFSWithLevels();
		System.out.println("BFS with levels:");
		tree.bfsWithLevels(root);
	}

//	BFS with levels:
//		1
//		2 3
//		4 5 6
}