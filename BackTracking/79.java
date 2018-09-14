/**
* 79.Word Search
* Given a 2D board and a word, find if the word exists in the grid.
* The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
* The same letter cell may not be used more than once.
* board =
* [
*   ['A','B','C','E'],
*   ['S','F','C','S'],
*   ['A','D','E','E']
* ]
* Given word = "ABCCED", return true.
* Given word = "SEE", return true.
* Given word = "ABCB", return false.
*/

/**
* This backtracking problem is different from others, I should put the funtion call in if(), this is very important
* Be careful when I am finding if the four character next to current character is valid, some character may be traverse more than once
* So there should be a boolean[][] visited to track if a character is visited
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backTracking(board,word,visited,i,j,0)) return true;
            }
        }
        return false;
    }
    public boolean backTracking(char[][] board, String word, boolean[][] visited, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j])
            return false;
        visited[i][j] = true;
        if(backTracking(board,word,visited,i+1,j,index+1)||
           backTracking(board,word,visited,i-1,j,index+1)||
           backTracking(board,word,visited,i,j+1,index+1)||
           backTracking(board,word,visited,i,j-1,index+1))
            return true;
        visited[i][j] = false;
        return false;
    }
}
