package com.examole.shortestpath;

import java.util.*;

public class BFSShortestPath {
    public static void main(String[] args) {
    Map<Integer, List<Integer>> graph = Map.of(0, List.of(1, 2),
            1, List.of(3, 0),
            2, List.of(3, 4, 0),
            3, List.of(1,5,2),
            4, List.of(2,5),
            5, List.of(3,4));

    Map<Integer, Integer> distances = shortestPath(graph, 0);
    distances.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "-" + e.getValue()));

    }

    public static  Map<Integer, Integer> shortestPath(Map<Integer, List<Integer>> graph, int start){
        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(start, 0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(! queue.isEmpty()){
            int curr = queue.poll();
            for(Integer neighbor : graph.get(curr)){
                if(! distance.containsKey(neighbor)){
                    distance.put(neighbor, distance.get(curr) + 1);
                    queue.add(neighbor);
                }


            }
        }
        return  distance;
    }
}
