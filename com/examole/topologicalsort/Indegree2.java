package com.examole.topologicalsort;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Indegree2 {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjList = Map.of(0, List.of(1),
                1, List.of(2,3), 2, List.of(), 3 , List.of(2,4),
                4, List.of());

        int [] indegrees = calculateIndegree(5, adjList);
        Arrays.stream(indegrees).forEach(System.out::println);
    }

    public static int [] calculateIndegree(int n , Map<Integer, List<Integer>> adjList){
        int [] indegrees = new int[n];
        for(int u : adjList.keySet()){
            for(int v : adjList.get(u)){
                indegrees[v] +=1;
            }
        }
        return  indegrees;

    }
}
