package LeetCode.Algorithms.Easy;

public class NumberStepsReduceNumberToZero {
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 36.4 MB, less than 100.00%
     */
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0){
            num = num % 2 == 0 ? num >> 1 : num - 1;
            count++;
        }
        return count;
    }
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 36 MB, less than 100.00%
     */
    public int numberOfSteps3 (int num) {
        int count = 0;
        while (num != 0) {
            num = (num & 1) == 1 ? num - 1 : num >> 1;
            count++;
        }
        return count;
    }
    public int countingBitsMethod(int num) {
        String binaryString = Integer.toBinaryString(num); // Get the binary for num, as a String.
        int steps = 0; // Iterate over all the bits in the binary string.
        for (char bit : binaryString.toCharArray()) {
            if (bit == '1') steps = steps + 2; //  If the bit is a 1, Then it'll take 2 to remove.
            else steps = steps + 1; // bit == '0', Then it'll take 1 to remove.
        }
        return steps - 1; // We need to subtract 1, because the last bit was over-counted.
    }

    public int countingBitsWithBitWiseOperator(int num) {
        if (num == 0) return 0; // We need to handle this as a special case, otherwise it'll return -1.
        int steps = 0;
        for (int powerOfTwo = 1; powerOfTwo <= num; powerOfTwo = powerOfTwo * 2) {
            // Apply the bit mask to check if the bit at "powerOfTwo" is a 1.
            if ((powerOfTwo & num) != 0) steps = steps + 2;
             else steps = steps + 1;
        }
        return steps - 1; // We need to subtract 1, because the last bit was over-counted.
    }
    public static void main(String[] args){
        NumberStepsReduceNumberToZero nt = new NumberStepsReduceNumberToZero();
        System.out.println(nt.numberOfSteps(130));
    }
}
