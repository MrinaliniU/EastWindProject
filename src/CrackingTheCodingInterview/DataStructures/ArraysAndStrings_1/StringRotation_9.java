package CrackingTheCodingInterview.DataStructures.ArraysAndStrings_1;

/*
    Assume you have a method isSubString which checks if one word is a substring of another. Given two strings,
    s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubString
    (e.g., "waterbottle" is a rotation of" erbottlewat").

    Note the deference between reverse string and rotation string;
 */
public class StringRotation_9 {

    /* Book implementation: Create new word = word1 + word1. Check if word2 isSubString() of word */
    public boolean isRotation(String word1, String word2){
        int word1Length = word1.length();
        int word2Length = word2.length();
        if(word2Length == 0 || word2Length > word1Length) return false;
        String word = word1 + word1;
        return isSubString(word, word2);
    }

    private static boolean isSubString(String word1, String word2){
        int word1Length = word1.length();
        int word2Length = word2.length();
        if(word2Length == 0 || word2Length > word1Length) return false;
        for(int i = 0; i < word1Length; i++){
            if(i + word2Length > word1Length) return false;
            if(word1.substring(i, i + word2Length).equalsIgnoreCase(word2))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        String testString1 = "waterbottle";
        String testString2 = "erbottlewat";
        StringRotation_9 stringRotation_9 = new StringRotation_9();
        if(stringRotation_9.isRotation(testString1, testString2))
            System.out.println("YES");
        else
            System.out.println("NO");

    }
    /* My implementation: rotate word1 one char at a time and check if the rotated word is equal to word2 */
    public boolean myIsRotation(String word1, String word2){
        int word1Length = word1.length();
        int word2Length = word2.length();
        if(word2Length == 0 || word2Length > word1Length) return false;
        for(int i = word1Length; i >= 0; i--){
            String temp =  word1.substring(i, word1Length) + word1.substring(0, i);
            if(temp.equalsIgnoreCase(word2)) return true;
        }
        return false;
    }

    /* Code to find if a String is reverse of another string */
    public boolean isReverse(String word1, String word2){
        int word1Length = word1.length();
        int word2Length = word2.length();
        if(word1Length != word2Length) return false;
        for(int i = 0, j = word2Length - 1; i < word1Length; i++, j--){
            if(word1.charAt(i) != word2.charAt(j)) return false;
        }
        return true;
    }
}
