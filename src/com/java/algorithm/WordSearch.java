package com.java.algorithm;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited;
        for(int i = 0; i< r; i++){
            for(int j = 0; j < c; j++){
            if(match(board, word,0, i,j))
                return true;
            }
        }
        return false;
    }
    private boolean match(char[][] board, String word,int idx, int curX, int curY){
        if(board[curX][curY] != word.charAt(idx)) return false;
        if(board[curX][curY] == word.charAt(idx) && idx == word.length()-1) return true;
        board[curX][curY] ^= 256;
        
        for(Integer[] point : getNeighboringPoints(board, curX, curY)){
        	if(match(board, word, idx+1, point[0], point[1])){
            	return true;
        	}
        }
        board[curX][curY] ^= 256;
        return false;
    }
    private List<Integer[]> getNeighboringPoints(char[][] board, int x, int y){
    	List<Integer[]> points = new ArrayList<Integer[]>();
    	if(x + 1 < board.length){
    		points.add(new Integer[]{x+1, y});
    	}
    	if(y + 1 < board[0].length){
    		points.add(new Integer[]{x, y+1});
    	}
    	if(x - 1 >= 0){
    		points.add(new Integer[]{x-1, y});
    	}
    	if(y - 1 >= 0){
    		points.add(new Integer[]{x, y-1});
    	}    	
    	return points;
    }
	public static void main(String[] args) {
		WordSearch wSearch  = new WordSearch();
		char[][] board = {{'a','b','c','e'},{'s','f','e','s'},{'a','d','e','e'}};
		String word = "abcefsadeese";
		System.out.println(wSearch.exist(board, word));
		
		char c = 'a';
		System.out.println((char)(c ^ 256 ^ 256) );
	}

}
