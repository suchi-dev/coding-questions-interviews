package com.examole.shortestpath;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public static void main(String[] args) {
        int [][] mat = {{0,0,0}, {0,1,0}, {1, 1, 1}};
        int [][] res = updateMatrix(mat);
        System.out.println("The result is :");

        for(int [] m : res){
            for(int n : m){
                System.out.print(n + "|");
            }
            System.out.println();
        }
    }
    public static int[][] updateMatrix(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;
        int [][] output = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for(int r =0; r < rows; r++){
            for(int c =0; c < cols; c++){
                if(mat[r][c] == 0){
                    output[r][c] = 0;
                    queue.offer(new int[] {r, c});
                }else {
                    output[r][c] = -1;
                }
            }
        }

        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        int distance = 1;
        while(! queue.isEmpty()){
            int levelSize = queue.size();
            for(int i =0; i < levelSize; i++){
                int [] curr = queue.poll();
                int cx = curr[0];
                int cy = curr[1];
                for(int [] dir : dirs){
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];

                    if(nx >=0 && nx < rows && ny >=0 && ny < cols){
                        if(output[nx][ny] == -1){
                            output[nx][ny] = distance;
                            queue.offer(new int[] {nx, ny});
                        }
                    }
                }

            }
            distance++;

        }


        return output;
    }
}
