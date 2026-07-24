package com.examole.prefixsums;

import java.util.Arrays;
import java.util.Set;

public class NumberOfVowels {

    public static void main(String[] args) {
        String word = "prefixsum";
        int [][] queries = {{0,2},{1,4}, {3,5}};
        int [] res = calculateNumberOfVowels(word, queries);
        Arrays.stream(res).forEach(System.out::println);
    }
    public static int [] calculateNumberOfVowels(String word, int[][] queries){
        int [] res = new int[queries.length];
        int [] prefixSum = new int[word.length()];
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for(int i = 1; i < word.length(); i++){
            boolean isVowel = vowels.contains(word.charAt(i-1));
            prefixSum[i] = prefixSum[i-1] + (isVowel ? 1 : 0);
        }

        for(int i =0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int numberOfVowels = prefixSum[right + 1] - prefixSum[left];
            res [i] = numberOfVowels;
        }

        return  res;


    }
}
