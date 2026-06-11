package com.examole.twopointers;

public class TrappingRainwater {
    public static void main(String[] args) {
        int [] heights = new int[] {3,4,1,2,2,5,1,0,2};
        int count = calculateRainWater(heights);
        System.out.println("The count is : "+count);
    }

    public  static int calculateRainWater(int [] heights) {
        if(heights.length == 0){
            return 0;
        }
        int count = 0;
        int left = 0, right = heights.length - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];

        while(left < right) {
            if(leftMax < rightMax){
                left++;
                if(heights[left] > leftMax){
                    leftMax = heights[left];
                }else {
                    count+= leftMax - heights[left];
                }
            }else {
                right --;
                if(heights[right] > rightMax){
                    rightMax = heights[right];
                }else {
                    count += rightMax - heights[right];
                }
            }
        }
        return count;
    }
}
