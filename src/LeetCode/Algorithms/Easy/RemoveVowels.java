package LeetCode.Algorithms.Easy;

public class RemoveVowels {
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 39.1 MB, less than 100.00%
     */
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                sb.append(S.charAt(i));
        }
        return sb.toString();
    }
}
