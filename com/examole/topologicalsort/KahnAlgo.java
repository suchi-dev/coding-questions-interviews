package com.examole.topologicalsort;

import java.util.*;

public class KahnAlgo {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjList =
                Map.of(0, List.of(1, 3),
                        1, List.of(2),
                        2, List.of(),
                        3, List.of(1,4,5),
                        4, List.of(5),
                        5, List.of()
                        );

        List<Integer> topSortOrder = topologicalOrder(6, adjList);
        topSortOrder.stream()
                .forEach(System.out::println);
    }

    public static List<Integer>topologicalOrder(int n, Map<Integer, List<Integer>> adjList) {
        List<Integer> order = new ArrayList<>();
        int [] indegrees = new int[n];
        for(int u : adjList.keySet()){
            for(int v : adjList.get(u)){
                indegrees[v] +=1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i < indegrees.length; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int u = queue.poll();
            order.add(u);

            for(int v : adjList.getOrDefault(u, new ArrayList<>())){
                indegrees[v]--;

                if(indegrees[v] == 0){
                    queue.offer(v);
                }
            }

        }

        return order.size() == n  ? order : new ArrayList<>();



    }
}
