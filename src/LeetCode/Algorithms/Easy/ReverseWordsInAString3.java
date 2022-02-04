package LeetCode.Algorithms.Easy;

public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < s.length()) {
            int end = i;
            if (s.charAt(i) != ' ') {
                while (end < s.length() && s.charAt(end) != ' ') end++;
                reverse(sb, i, end - 1);
            }
            end++;
            i = end;
        }
        return sb.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAString3 rs3 = new ReverseWordsInAString3();
        String s = "Let's take LeetCode contest";
        System.out.println(rs3.reverseWords(s));;
    }
}
