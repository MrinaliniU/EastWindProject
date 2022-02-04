package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

public class Implement_strStr {
    /* This is the implementation of java String.indexOf()
    * returns the stating index of where the substring needle begins in the haystack.
    * Now, if needle is empty return 0, if needle is not found return -1 */
    String needle, haystack;
    /*
        Runtime: 0 ms
        Memory Usage: 37.8 MB
     */
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;
        this.haystack = haystack;
        this.needle = needle;
        int last_index = haystack.length() - needle.length();
        for(int i = 0; i <= last_index; i++){
            if(haystack.charAt(i) == needle.charAt(0) && needleMatch(i))
                return i;
        }
        return -1;
    }
    public boolean needleMatch(int index){
        for(int i = 0; i < needle.length(); i++, index++){
            if(needle.charAt(i) != haystack.charAt(index)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Implement_strStr s = new Implement_strStr();
        String hayStack = "hello";
        String needle = "ll";
        System.out.println(hayStack.indexOf(needle));
        System.out.println(s.strStr(hayStack, needle));
    }
}
