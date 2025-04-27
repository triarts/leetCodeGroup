package org.example.bfsDfsGraphTree;

import java.util.*;

//with graph
public class DFSExampleGraph {
	private Map<Integer, List<Integer>> adjList = new HashMap<>();

	// Add edge
	public void addEdge(int src, int dest) {
		adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
		adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src); // for undirected graph
	}

	// DFS helper
	private void dfsHelper(int node, Set<Integer> visited) {
		visited.add(node);
		System.out.print(node + " ");

		for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
			if (!visited.contains(neighbor)) {
				dfsHelper(neighbor, visited);
			}
		}
	}

	// DFS main function
	public void dfs(int start) {
		Set<Integer> visited = new HashSet<>();
		dfsHelper(start, visited);
	}

	public static void main(String[] args) {
		DFSExampleGraph graph = new DFSExampleGraph();
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);

		System.out.println("DFS starting from node 0:");
		graph.dfs(0);
	}
}