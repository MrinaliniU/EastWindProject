package LeetCode.Algorithms.Easy;
import java.util.*;
public class ReorderDataInLogFiles {

/**
You are given a list of logs each log is a string delimited by a single space. Every part of the log that is de-limited
by space is called a "word". Say the first log looks like this "dig1 8 1 5 1","let1 art can" "dig1", "8" "1" ...
are called words.
    - A log file format is like so and is guaranteed to be so always
        - The first word in each log file is the identifier and is alphanumerical : dig1
        - The words that follow the identifier will all be either numeric or alphabetic not both
There are technically two types of logs
    - type1 : let1 art can
    - type2 : dig1 8 1 5 1
How to sort the log files?
    1. All type1 logs come at the beginning of the final sorted logs
    2. These logs are sorted lexicographically. (Doesn't mean the word in logs are sorted)
    3. identifier is used as a tie breaker
    4. All type2 logs are at the end of the final sorted logs
    5. These logs need not be be sorted, they are just at the end of the sorted logs list.


When two string are compared like so:
    - "a".compareTo("b"), you get 1 because a is greater than b.
    - "7".compareTo("8"), you get -1 because 7 is smaller than 8.
if equal you get 0.

 1. All type1 logs come at the beginning of the final sorted logs
     - String[] s1 = a.split(" ", 2); is used to split the identifier and the rest of the string
      dig1 8 1 5 1 => [dig1][8 1 5 1]
     - if(!isDigit1 && !isDigit2) every logic for type1 log goes inside this condition
 2. These logs are sorted lexicographically. (Doesn't mean the word in logs are sorted)
     s1[1].compareTo(s2[1]) this comparision when returned to Arrays.sort() sort them lexicographically.
 3. identifier is used as a tie breaker
     if the previous comparision value is 0, i.e they are same then return s1[0].compareTo(s2[0]) to Arrays.sort()
 4. All type2 logs are at the end of the final sorted logs
     isDigit1 ? (isDigit2 ? 0 : 1) : -1. Note that strings should be at the beginning of the sorted list which in
        other words mean that type1 are smaller than type2, hence when type1 is compared to type2 the returned digit
        must be -1.
 5. These logs need not be be sorted, they are just at the end of the sorted logs list.
        Type2 need not be sorted hence we DON'T have a condition  if(isDigit1 && isDigit2)
 */
/*
    Runtime: 5 ms, faster than 67.92%
    Memory Usage: 40.4 MB, less than 14.71%
 */
    public String[] reorderLogFiles1(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] s1 = a.split(" ", 2);
            String[] s2 = b.split(" ", 2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int compare = s1[1].compareTo(s2[1]);
                if(compare != 0) return compare;
                return s1[0].compareTo(s2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
    /* Same as above without lambda function
    public String[] reorderLogFiles2(String[] logs) {
        String[][] iden_log_split = new String[logs.length][];
        for(int i = 0; i < logs.length; i++){
            iden_log_split[i] = logs[i].split(" ", 2);
        }
    } */

    public static void main(String[] args) {
        ReorderDataInLogFiles ro = new ReorderDataInLogFiles();
        String[] logs1 = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] logs2 = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        ro.reorderLogFiles1(logs1);
        for(String s : logs1){
            System.out.println(s);
        }
    }
}
