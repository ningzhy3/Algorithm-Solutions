class Solution:
	def numIsLands(self, grid) -> int:
		if not grid:
			return 0

		count = 0
		for i in range(len(grid)):
			for j in range(len(grid[0])):
				if grid[i][j] == '1':
					self.dfs(grid, i, j)
					count+=1
		return count

	def dfs(self, grid, i, j):
		if i<0 or i>=len(grid) or j<0 or j >= len(grid[0]) or grid[i][j]!='1':
			return
		self.dfs(self, i+1, j)
		self.dfs(self, i-1, j)
		self.dfs(self, i, j-1)
		self.dfs(self, i, j+1)