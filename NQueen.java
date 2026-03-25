//Java Program to implement NQueen problem using back-tracking
public class NQueen{
	static int N=4;
	public static void main(string [] args){
	int [] [] board=new int[N][N];
	solveNQueen(board,0);
	}
	static void solveQueen(int [][] board,int row){
		if(row==N){
			printBoard(board);
			System.out.println();
			return;
		}
		for(int col=0;col<N;col++){
			if(isSafe(board,row,col)){
				board[row][cou]=1;
				solveNQueen(board,row+1);
				board[row][col]=0;
			}
		}
	}
	static boolean isSafe(int[][]board,int row,int col){
		for(int i=0;i<row;i++){
			if(board[i][col]==1)
				return false;
		}
		for(int i=row-1,j=col-1;i>=0 &&j>=0;i--,j--){
			if(board[i][j]==1)
				return false;
		}
		for(int i=row-1,j=col+1;i>=0 &&j>=0;i--,j--){
			if(board[i][j]==1)
				return false;
		}
		return true;
	}
	static void printBooard(int[][] board){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
			System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
