package com.examole.shortestpath;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {

    public static void main(String[] args) {
        int x = 4, y = 4;
        int moves = minimumKnightMoves(x, y);
        System.out.println("The minimum number of moves for the knight is : "+moves);
    }

    public static Integer minimumKnightMoves(Integer x, Integer y){
        Set<String> visited = new HashSet<>();
        int [][] directions = {{2,1}, {2, -1}, {-2, 1}, {-2, -1},
                {1,2}, {1, -2}, {-1, -2}, {-1,2}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0});
        visited.add(("0, 0"));

        while( ! queue.isEmpty()){
            int [] current = queue.poll();
            int cx = current[0], cy = current[1], moves = current[2];

            if(cx == x && cy == y){
                return moves;
            }
            for(int [] direction: directions){
                int nx = cx + direction[0];
                int ny = cy + direction[1];
                String key = nx + "," + ny;
                if(! visited.contains(key)){
                    visited.add(key);
                    queue.offer(new int [] {nx, ny, moves + 1});
                }
            }


        }


        return  -1;
    }
}
