class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        if(board == null || board.length == 0){
            return false;
        }

        //scan the board
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                //if starting point is found begin dfs
                if(board[r][c] == word.charAt(0) && dfs(board,r,c,0,word)){
                    return true;
                }
            }
        }

        //if entire board is scanned and no path is found
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int index, String word){

        //base case
        if(index == word.length()) return true;

        //failure case
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, i + 1, j, index + 1 ,word) ||
                    dfs(board, i - 1, j , index + 1 ,word) ||
                    dfs(board, i , j - 1, index + 1 ,word) ||
                    dfs(board, i , j + 1, index + 1,word);

        board[i][j] = temp;
        
        return found;
    }
}