class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int r = matrix.length;
        int c = matrix[0].length;

        int top = 0, bottom = r - 1, left = 0, right = c - 1;

        if(matrix == null || matrix.length == 0) return result;

        while(top <= bottom && left <= right){

            //left to right
            for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;

            //top to bottom
            for(int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            //right to left
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            //bottom to top
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        
        }
        return result;
    }
}