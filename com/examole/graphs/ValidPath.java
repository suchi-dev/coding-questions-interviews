package com.examole.graphs;

import java.util.Arrays;

public class ValidPath {

    public static void main(String[] args) {
        int[][] edges = {
                {0,1}, {2,0}, {3,4}, {4,5}, {3,5}
        };
        boolean result = validPathExists(6, edges, 0, 5);
        System.out.println("There is a valid path : " + result);
    }

    public static boolean validPathExists(int n , int [][] edges, int src, int dest){
        boolean [][] graph = new boolean[n][n];
        for(boolean[] row: graph){
            Arrays.fill(row, false);
        }
        for(int [] edge: edges) {
            int u = edge[0], v = edge[1];
            graph[u][v] = true;
            graph[v][u] = true;

        }
        boolean [] visited = new boolean[n];
        return dfs(graph, src, dest, visited, n);





    }

    private static boolean dfs(boolean[][] graph,
                               int src, int dest,
                               boolean[] visited, int n) {
        if(src == dest) return  true;
        visited[src] = true;

        for(int i =0; i < n; i++){
            if(graph[src][i] && !visited[i]) {
                if(dfs(graph, i, dest, visited, n)) {
                    return  true;
                }
            }
        }
        return false;
    }
}
