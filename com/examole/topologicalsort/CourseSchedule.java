package com.examole.topologicalsort;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int [][] prerequisites = {{1,0}, {0,1}, {3,2}};
       boolean completed =  canCourseComplete(4, prerequisites);
        System.out.println("Topological sort completed :"+ completed);
    }

public static boolean canCourseComplete(Integer numCourses, int [][] prerequisites){
    int count = 0;
    int [] indegrees = new int[numCourses];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for(int[] prerequisite : prerequisites){
        int src = prerequisite[1];
        int dest = prerequisite[0];
        indegrees[dest]++;
        graph.computeIfAbsent(src , k -> new ArrayList<>()).add(dest);
    }
    Queue<Integer> queue = new LinkedList<>();
    for(int i =0; i < indegrees.length; i++){
        if(indegrees[i] == 0){
            queue.add(i);
        }
    }

    while( ! queue.isEmpty()){
        int curr = queue.poll();
        count++;
        for(Integer neighbor : graph.getOrDefault(curr, new ArrayList<>())){
            indegrees[neighbor]--;
            if(indegrees[neighbor] == 0 ){
                queue.add(neighbor);
            }
        }
    }

return count == numCourses;
}
}
