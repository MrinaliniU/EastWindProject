package Notes.Arrays;

public class CircularArrayNavigation {

    public void printCircularArray(char[] circularArray, int startIndex){
        int circularArrayLength = circularArray.length;
        for(int i = startIndex; i < circularArrayLength + startIndex; i++){
            System.out.print(circularArray[i % circularArrayLength] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        CircularArrayNavigation cn = new CircularArrayNavigation();
        char[] circularArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        cn.printCircularArray(circularArray, 0);
        cn.printCircularArray(circularArray, 5);
        cn.printCircularArray(circularArray, 4);
        cn.printCircularArray(circularArray, 7);
    }
}
