package com.java.algorithm;

public class SudokuAlgorithm {

	//
//	public static void sudoku(int[][]a ,int n){
//		for(int i = 0; i<a.length;i++){
//			for(int j =0; j < )
//		}
//	}
	public static void sudoku(int[][] a, int n, int r, int c){
		if(r == n-1 && c == n-1) return;
		if(a[r][c] == 0){
			for(int i=1; i<=n; i++){
				if(isSafe(a,r,c, i)){
					a[r][c] = i;
					if(r == n-1 && c == n-1){
						printBoard(a);
					}else{
						if(c == n-1){
							sudoku(a, n, r+1, 0);
						}else{
							sudoku(a, n, r, c+1);
						}
					}


				}
			}
		}
	}
	
	private static boolean isSafe(int[][]a, int r, int c, int n){		
		for(int i = 0; i<a.length; i++){
			if(a[i][c] == n) return false;
		}
		for(int i =0; i<a[0].length;i++){
			if(a[r][i] == n) return false;
		}
		return true;
	}
	private static void printBoard(int[][] a){
		for(int i = 0; i<a.length;i++){
			for(int j=0; j<a[0].length;j++){
				System.out.print(a[i][j]+ "		");
			}
			System.out.println();
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[4][4];
		/*
		 * 1 2 x x
		 * x x 1 x
		 * x 1 x x
		 * 4 x x 1
		 */
		a[0][0]= 1; a[0][1] = 2;
		a[1][2] = 1;
		a[2][1] = 1;
		a[3][0] = 4; a[3][3] = 1;
		SudokuAlgorithm.sudoku(a, 4, 0, 0);
	}

}
