class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        //base condition
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return result;
        }

        int r = heights.length;
        int c = heights[0].length;

        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];

        for(int i = 0; i < r; i++){
            dfs(i,0,pacific,heights,Integer.MIN_VALUE);
            dfs(i,c-1,atlantic,heights,Integer.MIN_VALUE);
        }

        for(int j = 0; j < c; j++){
            dfs(0,j,pacific,heights,Integer.MIN_VALUE);
            dfs(r - 1,j,atlantic,heights,Integer.MIN_VALUE);
        }

        //intersection
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }

    public void dfs(int r, int c, boolean[][] reachable, int[][] heights, int prevHeight){
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length){
            return;
        }

        if(heights[r][c] < prevHeight) return; //if prev is greater water can't flow

        if(reachable[r][c]) return; //if it is visited

        reachable[r][c] = true; //if it is not visited then mark it as visited.

        int currentHeight = heights[r][c];

        dfs(r + 1,c,reachable,heights,currentHeight);
        dfs(r - 1,c,reachable,heights,currentHeight);
        dfs(r,c + 1,reachable,heights,currentHeight);
        dfs(r, c - 1,reachable,heights,currentHeight);

    }
}