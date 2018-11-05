/**
190. Reverse Bits
Reverse bits of a given 32 bits unsigned integer.

Example:

Input: 43261596
Output: 964176192
Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
             return 964176192 represented in binary as 00111001011110000010100101000000.

Follow up:
If this function is called many times, how would you optimize it?
*/
/**
Use the shift operation.
We first intitialize result to 0. We then iterate from
0 to 31 (an integer has 32 bits). In each iteration:
We first shift result to the left by 1 bit.
Then, if the last digit of input n is 1, we add 1 to result. To
find the last digit of n, we just do: (n & 1)
Example, if n=5 (101), n&1 = 101 & 001 = 001 = 1;
however, if n = 2 (10), n&1 = 10 & 01 = 00 = 0).

Finally, we update n by shifting it to the right by 1 (n >>= 1). This is because the last digit is already taken care of, so we need to drop it by shifting n to the right by 1.

At the end of the iteration, we return result.
*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}

/**
For follow up divide 32bits to 4bytes, and use HashMap to improve the performence.
*/

// cache
private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
public int reverseBits(int n) {
    byte[] bytes = new byte[4];
    for (int i = 0; i < 4; i++) // convert int into 4 bytes
        bytes[i] = (byte)((n >>> 8*i) & 0xFF);
    int result = 0;
    for (int i = 0; i < 4; i++) {
        result += reverseByte(bytes[i]); // reverse per byte
        if (i < 3)
            result <<= 8;
    }
    return result;
}

private int reverseByte(byte b) {
    Integer value = cache.get(b); // first look up from cache
    if (value != null)
        return value;
    value = 0;
    // reverse by bit
    for (int i = 0; i < 8; i++) {
        value += ((b >>> i) & 1);
        if (i < 7)
            value <<= 1;
    }
    cache.put(b, value);
    return value;
}
