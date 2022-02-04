package CrackingTheCodingInterview.DataStructures.ArraysAndStrings_1;

/* Implement an algorithm to determine if a String has all unique characters. What if
you cannot use additional data structures.
 */

/*
    Time Complexity: O(N) N is length of string. It could also be argued to be O(1) because the for loop won't iterate
    more than O(128).
    Space Complexity: O(1) or O(c) where c is size of character set.
 */

public class IsUnique_1 {

    public boolean isUnique(String word){
        int[] trackCharacters = new int[128]; // There are 128 ASCII characters.
        String tempString = word.toUpperCase(); // if both upper and lower case is considered same
        if(word.length() > 128 || word.length() == 0)
            return false;
        for(int i = 0; i < tempString.length(); i++){
            if(trackCharacters[(int) tempString.charAt(i)] == 0){
                if((int) tempString.charAt(i) != 32) // ignore white space
                    trackCharacters[(int) tempString.charAt(i)]++;
            }else{
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        String word = "V A B C / b";
        IsUnique_1 unique_1 = new IsUnique_1();
        if(unique_1.isUnique(word))
            System.out.print("The word \"" + word + "\" has all unique characters.");
        else
            System.out.print("The word \"" + word + "\" does not have all unique characters.");
    }
}
