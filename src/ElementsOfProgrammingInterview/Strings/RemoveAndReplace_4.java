package ElementsOfProgrammingInterview.Strings;

public class RemoveAndReplace_4 {

    public static int replaceAndRemove(char[] input, int k) {
        int finalValidLength = findFinalLength(input, k);
        int validLenAfterBRemoved = removeB(input, k);
        replaceA(input, validLenAfterBRemoved, finalValidLength);
        return finalValidLength;
    }

    private static void replaceA(char[] input, int w, int l) {
        --w; --l; // zero index
        while (w >= 0 && l >= 0) {
            if (input[w] == 'a') {
                input[l--] = 'd';
                input[l--] = 'd';
            } else {
                input[l--] = input[w];
            }
            w--;
        }
    }

    private static int removeB(char[] input, int k) {
        int bIndex = 0;
        for (int i = 0; i < k; i++) {
            if (input[i] != 'b') {
                input[bIndex++] = input[i];
            }
        }
        return bIndex;
    }

    private static int findFinalLength(char[] input, int k) {
        for (char c : input) {
            if (c == 'a') k++;
            if (c == 'b') k--;
        }
        return k;
    }

    public static void main(String[] args) {
        char[] ch = new char[] {'a', 'b', 'b', 'a', 'b', 'c'};
        int ans = replaceAndRemove(ch, 6);
        for (int i = 0; i < ans; i++) {
            System.out.print(ch[i] + ",");
        }
    }
}
