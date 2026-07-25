package com.examole.topologicalsort;

import java.util.*;

public class ParallelCourses {

    public static void main(String[] args) {
        int [][] prerequsiistes = {{1,3}, {2,3}, {3,4}, {3,5}};
        int semesters = minSemesters(6, prerequsiistes);
        System.out.println(semesters);
    }
    public static int minSemesters(int n , int [][] prerequisites){
        int [] indegrees = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int [] prerequisite : prerequisites){
            int src = prerequisite[0];
            int dest = prerequisite[1];
            indegrees[dest]++;
            graph.computeIfAbsent(src, k -> new ArrayList<>())
                    .add(dest);


        }

        for(int i =0; i < indegrees.length; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
            }
        }

        int semesters = 0;
        int cousesRemaining = n;
        while(! queue.isEmpty()){
            semesters++;
            int coursesThisSemester = queue.size();

            for(int i =0; i < coursesThisSemester; i++){
                int curr = queue.poll();
                cousesRemaining--;
                for(Integer neighbor : graph.getOrDefault(curr, new ArrayList<>())){
                    indegrees[neighbor]--;
                    if(indegrees[neighbor] == 0){
                        queue.offer(neighbor);
                    }
                }
            }
        }


        return cousesRemaining == 0 ? semesters : -1;

    }
}
