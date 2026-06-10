package com.examole.twopointers;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int [] nums = new int[] {2, 0, 4, 0, 9, 0};
        moveZeros(nums);
    }

    public static void moveZeros(int [] nums) {
        int nonZeros = 0;
        for(int i =0; i < nums.length; i++){
            if(nums[i] !=0){
                int tmp = nums[nonZeros];
                nums[nonZeros] = nums[i];
                nums[i] = tmp;
                nonZeros++;
            }
        }

        Arrays.stream(nums).forEach(e -> System.out.print(e + ","));

    }
}
