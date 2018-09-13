/**
* 74. Search a 2D Matrix
* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
*   Integers in each row are sorted from left to right.
*   The first integer of each row is greater than the last integer of the previous row.
*/

/**
* Consider the whole matirx as an array and do binary search
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length, start = 0, end = m*n - 1;
        //if no "=", then when matrix has only one row and one col can't be searched
        while(start <= end){
            int mid = (start + end) / 2, mid_value = matrix[mid/n][mid%n];
            if(mid_value == target)
                return true;
            else if(mid_value < target)
                start = mid + 1;
            else
                end = mid - 1; //because we use "start <= end", if we use end = mid here, it will loop forever
        }
        return false;
    }
}
