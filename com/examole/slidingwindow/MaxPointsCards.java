package com.examole.slidingwindow;

public class MaxPointsCards {

    public static void main(String[] args) {
        int [] cards = new int [] {2,11,4,5,3,9,2};
        int maxScore = calculateMaxPoints(cards, 3);
        System.out.println("The maximum score is : "+maxScore);
    }

    public static int calculateMaxPoints(int [] cards, int k){
        int maxPoints = 0;
        int total = 0;
        int state = 0;
        int start = 0;
        for(int card : cards){
            total += card;
        }

        if(cards.length == k){
            return  total;
        }

        for(int end = 0; end < cards.length; end++){
            state += cards[end];

            if(end - start + 1 == cards.length -k ){
                maxPoints = Math.max(total - state, maxPoints);
                state-= cards[start];
                start ++;
            }
        }

        return  maxPoints;
    }
}
