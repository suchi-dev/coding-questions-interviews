package com.examole.shortestpath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

    public static void main(String[] args) {
        int start = 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, List.of(new int[] {1,4}, new int[] {2,1}));
        graph.put(1, List.of(new int[] {3, 1}));
        graph.put(2, List.of(new int[] {1, 2}, new int[] {3, 5}));
        graph.put(3, List.of(new int[] {4,3}));

        Map<Integer, Integer> distances = calculateShortestPath(graph, start);
        distances.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "->" +
                e.getValue()));


    }
    public static Map<Integer, Integer> calculateShortestPath(Map<Integer, List<int[]>> graph, int start
                                                              ){
    Map<Integer, Integer> distance = new HashMap<>();
    distance.put(start, 0);
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    heap.offer(new int[] {0, start});
    while(! heap.isEmpty()){
        int [] curr = heap.poll();
        int dist = curr[0], node = curr[1];

        if(dist > distance.getOrDefault(node, Integer.MAX_VALUE)){
            continue;
        }

        for(int [] edge : graph.get(node)){
            int neighbor = edge[0], weight = edge[1];
            int newDist = dist + weight;

            if(newDist < distance.getOrDefault(neighbor, Integer.MAX_VALUE)){
                distance.put(neighbor, newDist);
                heap.offer(new int[] {newDist, neighbor});
            }

        }
        return distance;


    }












        return  distance;

    }
}
