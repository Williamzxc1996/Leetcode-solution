/**
135.Candy
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
*/

/**
This solution picks each element from the input array only once. First, we give a candy to the first child. Then for each child we have three cases:

His/her rating is equal to the previous one -> give 1 candy.
His/her rating is greater than the previous one -> give him (previous + 1) candies.
His/her rating is less than the previous one -> don't know what to do yet, let's just count the number of such consequent cases.
When we enter 1 or 2 condition we can check our count from 3. If it's not zero then we know that we were descending before and we have everything to update our total candies amount: number of children in descending sequence of raitings - coundDown, number of candies given at peak - prev (we don't update prev when descending). Total number of candies for "descending" children can be found through arithmetic progression formula (1+2+...+countDown). Plus we need to update our peak child if his number of candies is less then or equal to countDown.

It's a greedy strategy.
*/

class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int candy = 1, i = 1, preCandy = 1;
        while(i < ratings.length){
            //ascending sequence
            while(i < ratings.length && ratings[i] > ratings[i-1]){
                candy = candy + preCandy + 1;
                preCandy++;
                i++;
            }
            //descending sequence, end point to next child need to give candy
            int end = i, candyMark = preCandy;
            while(i < ratings.length && ratings[i] <= ratings[i-1]){
                if(i == end){
                    if(ratings[i] == ratings[i-1]){
                        preCandy = 1;
                        candy += preCandy;
                        end = i+1;
                        candyMark = preCandy;
                    }else if(candyMark == 1){
                        candyMark++;
                        preCandy = 1;
                        candy += 1 + preCandy;
                    }else{
                        preCandy = 1;
                        candy += preCandy;
                    }
                }else{
                    if(ratings[i] == ratings[i-1]){
                        candy += preCandy;
                        end = i+1;
                        candyMark = preCandy;
                    }else{
                        if(preCandy + i - end >= candyMark){
                            candyMark++;
                            preCandy = 1;
                            candy += i - end + 1 + preCandy;
                        }else{
                            preCandy = 1;
                            candy += i - end + preCandy;
                        }
                    }
                }
                i++;
            }
        }
        return candy;
    }
}
