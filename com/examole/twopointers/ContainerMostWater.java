package com.examole.twopointers;
public class ContainerMostWater {

    public static void main(String[] args) {
        int [] heights = new int[] {3, 4, 1, 2, 2, 4, 1, 3, 2};
        int result = getMostWater(heights);
        System.out.println("The result is : "+ result);

    }

    public static int getMostWater(int [] heights) {
        int left = 0;
        int right = heights.length - 1;

        int currentMaxArea = 0;
        while(left < right){
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int currentArea = width * height;
            currentMaxArea = Math.max(currentArea, currentMaxArea);

            if(heights[left] < heights[right]){
                left ++;
            }else {
                right --;
            }
        }

        return currentMaxArea;
    }


}
