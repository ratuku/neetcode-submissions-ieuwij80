class Solution:
    def reverseBits(self, n: int) -> int:
        #bits = [0] * 32
        bits = []
        # go from an int to binary... need to break number down into sums of 2^i. how do we do this programmatically.. 
        # we would divide by to and check remainders..
        for _ in range(32):
            bits.append(n % 2)
            n //= 2

        # now go from bits to integer... reverse bits first
        num = 0;
        for i in range(32):
            if bits[i] == 1:
                num += 2 ** (31 - i) # position i moves to position 31 -1
        
        return num
        