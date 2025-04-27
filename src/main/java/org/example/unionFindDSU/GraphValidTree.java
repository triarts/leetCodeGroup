package org.example.unionFindDSU;

import java.util.*;

public class GraphValidTree {

	private int[] parent;

	public boolean validTree(int n, int[][] edges) {
		if (edges.length != n - 1) {
			return false; // A valid tree must have exactly n-1 edges
		}

		// Initialize Union-Find data structure
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i; // Initially, each node is its own parent
		}

		// Step 2: Process each edge
		for (int[] edge : edges) {
			int node1 = edge[0];
			int node2 = edge[1];

			if (!union(node1, node2)) {
				return false; // Cycle detected
			}
		}

		return true; // No cycle and exactly n-1 edges, valid tree
	}

	// Helper function to find the root of a node
	private int find(int node) {
		if (parent[node] != node) {
			parent[node] = find(parent[node]); // Path compression
		}
		return parent[node];
	}

	// Helper function to union two sets
	private boolean union(int node1, int node2) {
		int root1 = find(node1);
		int root2 = find(node2);

		if (root1 == root2) {
			return false; // Cycle detected
		}

		parent[root2] = root1; // Union the two components
		return true;
	}

	// Test
	public static void main(String[] args) {
		GraphValidTree solution = new GraphValidTree();
		int n = 5;
		int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};

		System.out.println(solution.validTree(n, edges)); // Output: true
	}
}