/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    let result = [];
    let board = [];
    for(let i=0;i<n;i++){
        board[i] = [];
        for(let j=0;j<n;j++){
            board[i][j] = ".";
        }
    }
    let backtrack = (board,rowIndex,colSet,diagonalSet,antiDiagonalSet) => {
        if(rowIndex == n){
          result.push(transform(board));
        }
        for(let col = 0;col<n;col++){
            if(colSet.has(col) || diagonalSet.has(rowIndex-col) || antiDiagonalSet.has(rowIndex+col)) continue;
            board[rowIndex][col] = "Q";
            colSet.add(col);
            diagonalSet.add(rowIndex-col);
            antiDiagonalSet.add(rowIndex+col);
            backtrack(board,rowIndex+1,colSet,diagonalSet,antiDiagonalSet);
            board[rowIndex][col] = ".";
            colSet.delete(col);
            diagonalSet.delete(rowIndex-col);
            antiDiagonalSet.delete(rowIndex+col);
        }
    }
    backtrack(board,0,new Set(),new Set(),new Set());
    
return result;
};

let transform = (board) => {
    let newBoard = [];
    for(let i=0;i<board.length;i++){
        newBoard.push(board[i].join(""));
    }
    return newBoard;
}