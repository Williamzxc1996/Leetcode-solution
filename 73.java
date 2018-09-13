class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        Set<Integer> set = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            boolean row_flag = false;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(!set.contains(j)){
                        set.add(j);
                    }
                    row_flag = true;
                }
            }
            if(row_flag == true){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j : set){
            for(int i = 0; i < m; i++){
                matrix[i][j] = 0;
            }
        }
    }
    
}
