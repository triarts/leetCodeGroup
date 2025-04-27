package org.example.bfsDfsGraphTree;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) return 0;

		int count = 0;
		int rows = grid.length;
		int cols = grid[0].length;

		// Visit every cell
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == '1') {
					count++;
					dfs(grid, r, c);
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int r, int c) {
		int rows = grid.length;
		int cols = grid[0].length;

		// Boundary check
		if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
			return;
		}

		// Mark the land as visited by sinking it
		grid[r][c] = '0';

		// Visit all 4 adjacent cells
		dfs(grid, r + 1, c);
		dfs(grid, r - 1, c);
		dfs(grid, r, c + 1);
		dfs(grid, r, c - 1);
	}

	// Test
	public static void main(String[] args) {
		NumberOfIslands solution = new NumberOfIslands();
		char[][] grid = {
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}
		};
		System.out.println(solution.numIslands(grid)); // Output: 1
	}
}