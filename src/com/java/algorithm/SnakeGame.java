package com.java.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame {
    
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private int width; 
    private int height;
    private int[][] foods;
    private int score; 
    private int x;
    private int y;
    private List<int[]> list; 
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.foods = food;
        score = 0;
        x = 0;
        y = 0;
        list = new ArrayList<int[]>();
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
   public int move(String direction) {
        if(direction.equalsIgnoreCase("U")){
            if(x < 1) return -1;
            else x = x - 1;
        }else if(direction.equalsIgnoreCase("D")){
            if(x >= height - 1) return -1;
            else x = x + 1;
        }else if(direction.equalsIgnoreCase("L")){
            if(y < 1) return -1;
            else y = y - 1;
        }else if(direction.equalsIgnoreCase("R")){
            if(y >= width - 1) return -1;
            else y = y + 1;
        }
        int[] pos = {x, y};
        for(int i = 1; i< list.size(); i++){
            if(x == list.get(i)[0] && y == list.get(i)[1]){
                return -1;
            }
        }
        
        if(score < foods.length && foods[score][0] == x && foods[score][1] == y){
            score ++;
        }else if(list.size() >0){
            list.remove(0);
        }
        list.add(pos);
        
        return score;
    }
    
 


	public static void main(String[] args) {
		SnakeGame sg = new SnakeGame(2,2, new int[][]{{1,1},{0,0}});
		System.out.println(sg.move("R"));
		System.out.println(sg.move("D"));
		System.out.println(sg.move("L"));
		System.out.println(sg.move("U"));
		System.out.println(sg.move("R"));
//		SnakeGame sg = new SnakeGame(3,3, new int[][]{{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}});
//		System.out.println(sg.move("D"));
//		System.out.println(sg.move("D"));
//		System.out.println(sg.move("R"));
//		System.out.println(sg.move("U"));
//		System.out.println(sg.move("U"));
//		System.out.println(sg.move("L"));
//		System.out.println(sg.move("D"));
//		System.out.println(sg.move("R"));
//		System.out.println(sg.move("R"));
//		System.out.println(sg.move("U"));
//		System.out.println(sg.move("L"));
//		System.out.println(sg.move("L"));
//		System.out.println(sg.move("D"));
//		System.out.println(sg.move("R"));
//		System.out.println(sg.move("U"));

	}

}
