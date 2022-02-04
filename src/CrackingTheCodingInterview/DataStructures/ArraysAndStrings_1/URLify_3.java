package CrackingTheCodingInterview.DataStructures.ArraysAndStrings_1;

/*
	Write a method to replace all spaces in a string with `%20`. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
EXAMPLE
Input: 'Mr John Smith      ', 13
Output: "Mr%20John%20Smith"
*/

public class URLify_3 {

    public String url(String input){
        String[] splitArray = input.trim().split("\\s+"); // Nice regex to remove space
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < splitArray.length - 1; i++){
            result.append(splitArray[i].trim()).append("%20");
        }
        result.append(splitArray[splitArray.length - 1]);
        return result.toString();
    }

    public static void main(String[] args){
        String input = " Mr John  Smith   ";
        URLify_3 u3 = new URLify_3();
        System.out.println("URL " + u3.url(input));
    }
}
