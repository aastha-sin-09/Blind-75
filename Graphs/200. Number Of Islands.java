class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int countI = 0;

        if(grid == null || rows == 0 || cols == 0){
            return 0;
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    countI++;
                    dfs(grid, r, c);
                }
            }
        }

        return countI;
    }

    public void dfs(char[][] grid, int r, int c){
        int rows = grid.length;
        int cols = grid[0].length;

        if(r < 0|| r >= rows || c < 0 || c >= cols || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0'; //visited

        dfs(grid, r + 1, c); //down
        dfs(grid, r - 1, c); //up
        dfs(grid, r, c + 1); //right
        dfs(grid, r, c - 1); //left
    }
}