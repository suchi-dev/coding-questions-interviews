package com.examole.topologicalsort;

import java.util.Arrays;

public class Indegree1 {

    public static void main(String[] args) {
        int [][] edges = {{0,1}, {1,2}, {1,3}, {3,2}, {3,4}};
        System.out.println("The indegree is :");
        int [] indegrees = calculateIndegree(5, edges);
        Arrays.stream(indegrees).forEach(System.out::println);
    }

    public static int [] calculateIndegree(int n, int [][] edges) {
        int [] indegree = new int[n];
        for(int [] edge: edges) {
            indegree[edge[1]] +=1;
        }
        return indegree;
    }
}
