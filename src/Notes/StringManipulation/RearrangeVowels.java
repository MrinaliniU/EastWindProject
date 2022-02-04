package Notes.StringManipulation;

/*  Given a String re-arrange the vowels in the string in a reverse order. So given "San Fransisco" would be
    "Son Frinsasca".
 */

import java.util.Stack;

public class RearrangeVowels {

    /*
        Say you need to check if a char is a Vowel. A fun way to check this would be to make a Sting of vowels like
        so "aeiouAEIOU". Now all you need to do is to check if a char is present in this string or not.
        To do this you could use "indexOf()" method in String class.
        "aeiouAEIOU".indexOf(<charYouNeedToCheck>) would be -1 if it is not a vowel.
     */

    private static String reArrange(String word){
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";
        int wordLength = word.length();
        Stack<Character> storeVowels = new Stack<>();
        for(int i = 0; i < wordLength; i++){
            char temp = word.charAt(i);
            if(vowels.indexOf(temp) >= 0){
                storeVowels.add(temp);
            }
        }
        for(int i = 0; i < wordLength; i++){
            char temp = word.charAt(i);
            if(vowels.indexOf(temp) < 0){
                result.append(temp);
            }else{
                result.append(storeVowels.pop());
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        String example = "San FransiscO";
        System.out.println(reArrange(example));
    }
}
