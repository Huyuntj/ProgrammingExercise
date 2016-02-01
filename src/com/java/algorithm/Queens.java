package com.java.algorithm;

public class Queens {
	int[] x;
	int n;
	public Queens(int queenNum){
		this.n = queenNum;
		x = new int[queenNum];
	}
	public boolean canPlaceQueen(int r, int c){
		for(int i = 0; i<r; i++){
			if(x[i] == c || Math.abs(r -i) == Math.abs(c-x[i])){
				return false;
			}
		}
		return true;
	}
	public void placeNQueens(int r){
		for(int c = 0; c < n;c++){
			if(canPlaceQueen(r,c)){
				x[r] = c;
				if(r == n - 1){
					printQueens(x);
				}else{
					placeNQueens(r+1);
				}
			}
		}

	}
	public void printQueens(int[] x){
		for(int i = 0; i<x.length;i++){
			for(int j = 0; j<x.length;j++){
				if(x[i] == j){
					System.out.print("Q ");
				}else{
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		System.out.println("----------");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queens q = new Queens(8);
		q.placeNQueens(0);
	}

}
