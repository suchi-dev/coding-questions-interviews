package com.examole.shortestpath;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {


    public static void main(String[] args) {
        int [][] heights = {{1,2,2}, {3,8,2}, {5,3,5}};
        int minEfforts = minimumEffortPath(heights);
        System.out.println("The minimum efforts needed for the elevation path is : "+minEfforts);
    }

    public static  int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;
        int [][] dist = new int[rows][cols];
        for(int [] r : dist){
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        //effort, row, col

        heap.offer(new int[] {0, 0, 0});

        int [][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

        while(! heap.isEmpty()){
            int [] curr = heap.poll();
            int effort = curr[0], row = curr[1], col = curr[2];
            if(row == rows-1 && col == cols-1) {
                return  effort;
            }
            if(effort > dist[row][col]) continue;

            for(int [] dir : dirs){
                int nr = dir[0] + row;
                int nc = dir[1] + col;
                if(nr >=0 && nr < rows  && nc >=0 && nc < cols){
                    int diff = Math.abs(heights[nr][nc] - heights[row][col]);
                    int newEffort = Math.max(diff, effort);
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        heap.offer(new int[]{newEffort, nr, nc});
                    }


                }

            }



        }


    return dist[rows -1][cols -1];

    }
}
