/**
130.Surrounded regions
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
*/

/**
The main idea is to use Union Find. First, connect all the 'O'. Then traverse board again, check if the 'O' is connected to one of the 'O' on boarder.
The trick here, when creating uf, we add an extra node(in id), we connect all the 'O's on boarder to this extra one.
Because I only want to know if the 'O' is connected to 'O' on boarder, I don't care which 'O' it is. So with all the 'O's on
boarder connecting to this extra one, I only have to check if current 'O' is connected to it. This will reduce the time complexity.
*/

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        UF uf = new UF(m*n+1);
        //connect all the 'O'
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int id = i*n+j;
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(board[i][j] == 'O') uf.union(id,m*n);      //id = m*n is the extra point I create in uf.
                }else{
                    if(board[i][j] == 'O'){
                        if(board[i-1][j] == 'O') uf.union(id,id-n);
                        if(board[i][j-1] == 'O') uf.union(id,id-1);
                        if(board[i][j+1] == 'O') uf.union(id,id+1);
                        if(board[i+1][j] == 'O') uf.union(id,id+n);
                    }
                }
            }
        }
        
        //flip
        for(int i = 1; i < m-1; i++){
            for(int j = 1; j < n-1; j++){
                int id = i*n+j;
                if(board[i][j] == 'O' && !uf.connected(id,m*n)){
                    board[i][j] = 'X';
                }
            }
        } 
    }
}

public class UF {
    private int[] id;           //parents array
    private int[] sz;           //record the size of the set which each vertex belongs to
    private int count;          //the total number of set at a certain time

    public UF(int n){
        count = n;
        id = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int getCount(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        //find the root of the set which p belongs to
        while(p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j) return;
        //link the root with smaller size to the root with greater size
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}

