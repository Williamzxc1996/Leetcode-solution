/**
263. Ugly Number
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
*/

/**
If a number only has prime factors 2,3,5, then we just remove these factors, it will end up at 1.
*/

class Solution {
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        while(num % 2 == 0){
            num /= 2;
        }
        while(num % 3 == 0){
            num /= 3;
        }
        while(num % 5 == 0){
            num /= 5;
        }
        return num == 1;
    }
}
