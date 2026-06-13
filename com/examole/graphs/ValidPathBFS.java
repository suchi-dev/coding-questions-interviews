package com.examole.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPathBFS {

    public static void main(String[] args) {
        int n = 6, src= 0, dest = 5;
        int [][] edges = {
                {0,1}, {0,2}, {3,4}, {3,5}, {4,5}

        };

        boolean res = validPathBFS(src, dest, n, edges);
        System.out.println("The valid path exists ? "+res);
    }

    public static boolean validPathBFS(int src, int dest, int n, int [][] edges) {
        boolean [][] graph = new boolean[n][n];
        for(boolean [] row: graph){
            Arrays.fill(row, false);
        }

        for(int [] edge : edges){
            int u = edge[0], v = edge[1];
            graph[u][v] = true;
            graph[v][u] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        boolean [] visited = new boolean[n];
        for(int i =0; i < n; i++){
            visited[i] = false;
        }

        while(! queue.isEmpty()){
            int curr = queue.poll();
            if(curr == dest) return  true;
            for(int i =0; i < n; i++){
                if(graph[curr][i] && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return  false;
    }
}
