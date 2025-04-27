package org.example.bfsDfsGraphTree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root); // Start with the root

		while (!queue.isEmpty()) {
			int levelSize = queue.size(); // Number of nodes at current level
			List<Integer> currentLevel = new ArrayList<>();

			// Process all nodes in this level
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				currentLevel.add(node.val);

				// Add child nodes of current node to queue
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}

			// Add the current level to result
			result.add(currentLevel);
		}

		return result;
	}

	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// Test
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
		TreeNode root = new TreeNode(3,
			new TreeNode(9),
			new TreeNode(20, new TreeNode(15), new TreeNode(7)));

		List<List<Integer>> result = solution.levelOrder(root);
		System.out.println(result); // Output: [[3], [9, 20], [15, 7]]
	}
}