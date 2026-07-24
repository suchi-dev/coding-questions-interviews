package com.examole.prefixsums;

public class PrefixSum {

    public static void main(String[] args) {
        int [] arr = new int[] {1,3,4,6,2,5,8};
        int [] prefixSum = calculatePrefixSum(arr);
        // prefixSum between indices i and j is calculated as
        // prefixSum[j+1] - prefixSum[i]
        int prefixSumValue = prefixSum[6] - prefixSum[3];
        System.out.println("The prefix sum between 3 and 5 is : "+prefixSumValue);

    }


    public static int[] calculatePrefixSum(int [] arr){
        int n = arr.length;
        int [] prefixSum = new int[n + 1];
        for(int i =1; i <=n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }
        return prefixSum;

    }
}
