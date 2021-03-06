/*
204. Count Primes
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/

/*
https://leetcode.com/problems/count-primes/ hints.
Sieve of Eratosthenes
*/

class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        for(int i = 2; i*i < n; i++){
            if(notPrime[i] == false){
                for(int j = i*i; j < n; j += i){
                    notPrime[j] = true;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false){
                count++;
            }
        }
        return count;
    }
}
