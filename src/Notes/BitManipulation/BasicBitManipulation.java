package Notes.BitManipulation;

public class BasicBitManipulation {

    boolean getBit(int num, int i){
        /* left shift number 1 till the index i to create a mask
        Because 1 is represented as ..00001, i will be 0 indexed with the least significant bit considered as
        the 0th index bit. If i is not 0 indexed that is if it starts from 1 the use int mask = 1 << (i + 1);
         */
        int mask = 1 << i;
        // We want to set all the bits other than the ith bit as 0. So we perform AND operation. (num & mask)
        // the result will be 0 if the ith bit was 0 else it will equal to mask
        int result = num & mask;
        return(result != 0);
    }
   int setBit(int num, int i){
        /* The bit at index i can be 0 or 1. To set it to 1 we need to OR it with 1, which gives the result 1.
            The rest of the bits must be the same.
         */
        // left shift number 1 till the index i to create a mask
       int mask = 1 << i;
       return num | mask;
    }
    int clearBit(int num, int i){
        /* The bit at index i can be 0 or 1, we can clear it by performing an AND operation with 0.
            We need all other bits to remain unchanged and so we will AND all other bits with 1.
         */
        // create a mask by left shifting 1 by i and then inverting it.
        int mask = ~(1 << i);
        return num & mask;
    }
    int clearBitTillI(int num, int i){
        /*
        My approach:
            The largest number in int is represented with all 1s. If we create a mask by right shifting it
            such that till ith index we have 0s and rest are 1s we can perform AND to clear the bits
            from most significant bit to i.
            But when it comes to a -ve number which has the most significant bit set to 1 the number of times we need
            to right shift varies by 1 count.
            so we can find the number of times right shift is required by calculating it as
            i = num >= 0 ? 32 - i : 31 - i; // this will tell us how many right shift is required,
            and create a mask like so
            int mask = Integer.MAX_VALUE >> i;
            Instead of all these complication a simpler way shown in CCI book is
        CCI approach:

         */
        int mask = (1 << i) - 1;
        return num & mask;
    }
    int clearBitFromI(int num, int i){
        /*
            This is my logic CCI has something else but this is simpler for me.
         */
        i++; // without this the ith index does not get cleared (0 indexed)
        int mask = ~(1 << i) + 1;
        return num & mask;
    }
    int updateBit(int num, int i, boolean isBit1){
        /*
            This is my logic CCI has something else but this is way simpler for me.
         */
        if(isBit1) return setBit(num, i);
        else return clearBit(num, i);
    }
    public static void main(String[] args){
        BasicBitManipulation bbm = new BasicBitManipulation();
        int convertToBinary = 10;
        System.out.println("Binary of int " + convertToBinary + " is " + Integer.toBinaryString(convertToBinary));
        /* To covert a byte to binary */
        byte b1 = 2;
        byte b2 = (byte) 129; // -127
        String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
        String s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println("Binary of byte " + b1 + " is " + s1); // 00000010
        System.out.println("Binary of byte " + b2 + " is " + s2); // 10000001
        int getBit = -5345345, getI = 3;
        int getBitResult = bbm.getBit(getBit, getI) ? 1 : 0;
        System.out.println("The " + getI + "th bit of " + Integer.toBinaryString(getBit) + " is " + getBitResult);
        int setBit = -232354, setI = 0;
        System.out.println(Integer.toBinaryString(setBit) + " with bit at index " + setI + " set to 1 is " + Integer.toBinaryString(bbm.setBit(setBit, setI)));
        int clearBit = -232354, clearI = 1;
        System.out.println(Integer.toBinaryString(clearBit) + " with bit at index " + clearI + " set to 0 is " + Integer.toBinaryString(bbm.clearBit(clearBit, clearI)));
        int clearTill = -3423534, clearTillI = 15;
        System.out.println(Integer.toBinaryString(clearTill) + " with bits cleared till index " + clearTillI + " included is " + Integer.toBinaryString(bbm.clearBitTillI(clearTill, clearTillI)));
        /*
            Result for clearTill = -3423534 at index 15, ie 15th index mut be cleared
            11111111110010111|100001011010010
            00000000000000000|100001011010010
         */
        int clearFrom = 3423534, clearFromI = 2;
        System.out.println(Integer.toBinaryString(clearFrom) + " with bits cleared from index " + clearFromI + " included is " + Integer.toBinaryString(bbm.clearBitFromI(clearFrom, clearFromI)));
        /*
            Result for clearFrom = 3423534 at index 2, including index 2
            1101000011110100101|110
            1101000011110100101|000
         */
        int clearFrom2 = -3423534, clearFromI2 = 16;
        System.out.println(Integer.toBinaryString(clearFrom2) + " with bits cleared from index " + clearFromI2 + " included is " + Integer.toBinaryString(bbm.clearBitFromI(clearFrom2, clearFromI2)));
         /*
            Result for clearFrom2 = -3423534 at index 16, including index 16
            111111111100101|11100001011010010
            111111111100101|00000000000000000
         */
         int updateNum = -8757654, i = 10, v = 0;
         System.out.println(Integer.toBinaryString(updateNum) + " " + i + "th index updated to " + v + " is " + Integer.toBinaryString(bbm.updateBit(updateNum, i, v == 1)));
         /*
         Result:
         111111110111101001011|1|1001101010
         111111110111101001011|0|1001101010
          */
    }
}
