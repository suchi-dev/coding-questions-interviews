package com.examole.list;

import java.util.ArrayList;
import java.util.List;

public class MultiDimArray {

    public static void main(String[] args) {
        int vertexCount = 3;
        List<List<Integer>> graph = new ArrayList<>(vertexCount);
        for(int i =0; i < vertexCount; i++){
          graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(0);
        graph.get(0).add(2);

        int vc = graph.size();
        for(int i =0; i < vc; i++){
            int edgeCount = graph.get(i).size();
            for(int j =0; j < edgeCount; j++){
                int startVertex = i;
                int endVertex = graph.get(i).get(j);
                System.out.println("Start vertex : " +startVertex + " and end vertex is : " +endVertex);
            }
        }

        System.out.println("Lets create a 3D array");
        int x_axis = 2;
        int y_axis  = 2;
        int z_axis = 2;
        List<List<List<String>>> space = new ArrayList<>(x_axis);

        for(int i = 0; i < x_axis; i++){
            space.add(new ArrayList<>(new ArrayList<>(y_axis)));
            for(int j = 0; j < y_axis; j++){
                space.get(i).add(new ArrayList<>(z_axis));
            }
        }

        space.get(0).get(0).add(0, "Red");
        space.get(0).get(0).add(1, "Yellow");

        space.get(0).get(1).add(0, "Blue");
        space.get(0).get(1).add(1, "Green");


        space.get(1).get(0).add(0, "Pink");
        space.get(1).get(0).add(1, "Red");

        space.get(1).get(1).add(0, "Green");
        space.get(1).get(1).add(1, "Yellow");

     space.stream().forEach(System.out::println);


    }
}
