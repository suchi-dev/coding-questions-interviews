package com.examole.shortestpath;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {


    public static void main(String[] args) {
        int[][] grid = {{1,1,0}, {0,1,1}, {0,1,2}};
        int mins = orangesRotting(grid);
        System.out.println("Minutes taken to rot all oranges : "+mins);
    }
    public  static int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid == null){
            return -1;
        }

        int mins = 0;
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        for(int r=0; r<rows; r++){
            for(int c =0; c< cols; c++){
                if(grid[r][c] == 2){
                    queue.offer(new int[] {r, c});
                }else if(grid[r][c] == 1){
                    freshOranges++;
                }
            }
        }

        int [][] dirs = {{0,1}, {0, -1}, {1, 0},{-1, 0}};
        while(! queue.isEmpty() && freshOranges > 0){
            mins++;
            int levelSize = queue.size();

            for(int i =0; i < levelSize; i++){
                int []curr = queue.poll();
                int x = curr[0], y = curr[1];

                for(int [] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx >=0 && nx < rows && ny >=0 && ny < cols && grid[nx][ny] == 1){

                        grid[nx][ny] = 2;
                        freshOranges--;
                        queue.offer(new int[] {nx, ny});

                    }







                }


            }
        }



        return freshOranges == 0 ? mins : -1;

    }
}
