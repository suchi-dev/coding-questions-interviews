package com.examole.shortestpath;

import java.util.*;

public class CheapestFlights {

    public static void main(String[] args) {
        int [][] flights = {{0,1,100}, {1,2,100}, {2,3,100}, {0,3, 500}};
        int src = 0, n = 4, dest = 3, k = 1;
        int costToTravel = calculateCost(flights, src, dest, k);
        System.out.println("The cheapest flight  cost is : "+costToTravel);
    }


    public  static Integer calculateCost(int [][] flights, int src, int dest, int maxStops){
        Map<String, Integer> distances = new HashMap<>();
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int [] flight : flights){
            graph.computeIfAbsent(flight[0], k -> new ArrayList<>())
                    .add(new int[] { flight[1], flight[2]});


        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // cost, city, stops
        heap.offer(new int[] {0, src, 0});

        while(! heap.isEmpty()){
            int [] curr = heap.poll();
            int cost = curr[0], city = curr[1], stops = curr[2];
            if(city == dest){
                return  cost;
            }
            if(stops > maxStops) continue;
            String key = city + ","+stops;
            if(distances.containsKey(key) && distances.get(key) <= cost){
                continue;
            }
            distances.put(key, cost);

            // neighbors:

            for(int [] edge : graph.getOrDefault(city, new ArrayList<>())){
                int neighborCity = edge[0];
                int  newCost = cost + edge[1];
                heap.offer(new int[] {newCost, neighborCity, stops + 1});

            }


        }

        return -1;


    }
}
